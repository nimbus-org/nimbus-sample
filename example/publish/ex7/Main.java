
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.RequestServerConnection;
import jp.ossc.nimbus.service.publish.Message;
import jp.ossc.nimbus.service.publish.MessageReceiver;
import jp.ossc.nimbus.service.publish.RequestMessageListener;
import jp.ossc.nimbus.service.publish.MessageException;
import jp.ossc.nimbus.service.publish.MessageCreateException;
import jp.ossc.nimbus.util.WaitSynchronizeMonitor;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            System.out.println("通信相手が起動したら、送信するメッセージを入力して下さい。");
            
            // サービスを取得する
            ServerConnectionFactory factory
                 = (ServerConnectionFactory)ServiceManagerFactory
                    .getServiceObject("RequestConnectionFactory");
            
            MessageReceiver receiver = (MessageReceiver)ServiceManagerFactory
                    .getServiceObject("RequestConnectionFactory");
            
            try{
                MyRequestMessageListener listener = new MyRequestMessageListener();
                
                Thread thread = new Thread(listener);
                thread.start();
                
                // リスナーを登録
                receiver.addSubject(listener, "hoge");
                
                // サーバコネクションを取得
                RequestServerConnection connection = (RequestServerConnection)factory.getServerConnection();
                listener.connection = connection;
                
                while(true){
                    if(!listener.requestMonitor.initAndWaitMonitor(1000l)){
                        continue;
                    }
                    // メッセージを生成
                    Message message = connection.createMessage("hoge", null);
                    message.setObject(listener.line);
                    
                    // メッセージを送信
                    Message[] responses = connection.request(message, 0, 60000l);
                    System.out.print("receive reply>");
                    for(int i = 0; i < responses.length; i++){
                        System.out.print(responses[i].getObject());
                        if(i != responses.length - 1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    System.out.print("request<");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static class MyRequestMessageListener implements RequestMessageListener, Runnable{
        
        public String line;
        public WaitSynchronizeMonitor requestMonitor = new WaitSynchronizeMonitor();
        public WaitSynchronizeMonitor replyMonitor = new WaitSynchronizeMonitor();
        public RequestServerConnection connection;
        
        public void run(){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                System.out.print("request<");
                while((line = br.readLine()) != null){
                    if(replyMonitor.isWait()){
                        replyMonitor.notifyMonitor();
                    }else{
                        requestMonitor.notifyMonitor();
                    }
                }
            }catch(Exception e){e.printStackTrace();}
        }
        
        public void onMessage(Message message){
        }
        
        public Message onRequestMessage(Object sourceId, int sequence, Message message, String responseSubject, String responseKey){
            try{
                System.out.println();
                System.out.println("receive request>" + message.getObject());
            }catch(MessageException e){
            }finally{
                message.recycle();
            }
            Message response = null;
            try{
                response = connection.createMessage(responseSubject, responseKey);
            }catch(MessageCreateException e){
                return null;
            }
            System.out.print("reply<");
            try{
                replyMonitor.initAndWaitMonitor();
                response.setObject(line);
                return response;
            }catch(MessageException e){
                return null;
            }catch(InterruptedException e){
                return null;
            }finally{
                replyMonitor.releaseMonitor();
            }
        }
    }
}
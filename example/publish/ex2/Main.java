
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.ServerConnection;
import jp.ossc.nimbus.service.publish.Message;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            System.out.println("クライアントが起動したら、送信するメッセージを入力して下さい。");
            
            // サービスを取得する
            ServerConnectionFactory factory
                 = (ServerConnectionFactory)ServiceManagerFactory
                    .getServiceObject("ConnectionFactory");
            try{
                // サーバコネクションを取得
                ServerConnection connection = factory.getServerConnection();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while((line = br.readLine()) != null){
                    
                    // メッセージを生成
                    Message message = connection.createMessage(System.getProperty("Subject"), null);
                    message.setObject(line);
                    
                    // メッセージを送信
                    connection.send(message);
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
    
}
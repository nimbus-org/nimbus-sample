
import java.io.*;
import java.net.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.ServerConnection;
import jp.ossc.nimbus.service.publish.Message;

/**
 * サンプル６実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        if(args != null && args.length != 0 && "server".equals(args[0])){
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                System.out.println("クライアントが起動したら、送信するメッセージを入力して下さい。");
                System.out.println("入力フォーマット：サブジェクト,キー,メッセージ");
                
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
                        String[] params = line.split(",");
                        if(params.length == 3){
                            // メッセージを生成
                            Message message = connection.createMessage(params[0], params[1]);
                            message.setObject(params[2]);
                            
                            // メッセージを送信
                            connection.send(message);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            try{
                final Socket socket = new Socket(InetAddress.getLocalHost(), 10000);
                Thread readThread = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                InputStream is = socket.getInputStream();
                                DataInputStream dis = new DataInputStream(is);
                                int length = 0;
                                while((length = dis.readInt()) > 0){
                                    byte[] bytes = new byte[length];
                                    dis.readFully(bytes);
                                    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                                    DataInputStream dis2 = new DataInputStream(bais);
                                    int length2 = dis2.readInt();
                                    byte[] bytes2 = new byte[length2];
                                    dis2.readFully(bytes2);
                                    String message = new String(bytes2);
                                    if("BYE".equals(message)){
                                        socket.close();
                                        System.out.println("サーバが停止しました。");
                                        System.exit(0);
                                    }
                                    System.out.println(message);
                                }
                            }catch(SocketException e){
                            }catch(EOFException e){
                                System.out.println("サーバが停止しました。");
                                System.exit(0);
                            }catch(Exception e){
                                e.printStackTrace();
                                System.exit(-1);
                            }
                        }
                    }
                );
                readThread.setDaemon(true);
                readThread.start();
                
                System.out.println("受信登録：ADD,サブジェクト,キー1,キー2,....");
                System.out.println("受信解除：DEL,サブジェクト,キー1,キー2,....");
                System.out.println("受信開始：START");
                System.out.println("受信停止：STOP");
                System.out.println("切断    ：BYE");
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                while((line = br.readLine()) != null){
                    if(line.length() != 0){
                        dos.writeInt(line.length() + 4);
                        dos.writeInt(line.length());
                        byte[] bytes = line.getBytes();
                        dos.write(bytes, 0, bytes.length);
                        dos.flush();
                        if("BYE".equals(line)){
                            socket.close();
                            break;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
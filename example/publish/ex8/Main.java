
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.io.CSVReader;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.ServerConnection;
import jp.ossc.nimbus.service.publish.Message;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            System.out.println("クライアントが起動したら、送信するキーとメッセージをカンマ区切りで入力して下さい。");
            
            // サービスを取得する
            ServerConnectionFactory factory
                 = (ServerConnectionFactory)ServiceManagerFactory
                    .getServiceObject("ConnectionFactory");
            try{
                // サーバコネクションを取得
                ServerConnection connection = factory.getServerConnection();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                CSVReader reader = new CSVReader(br);
                String[] csv = null;
                while((csv = reader.readCSVLine()) != null){
                    
                    if(csv.length == 2){
                        // メッセージを生成
                        Message message = connection.createMessage("hoge", csv[0]);
                        message.setObject(csv[1]);
                        
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
    }
    
}
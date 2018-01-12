
import javax.naming.NamingException;

import javax.jms.QueueConnection;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.jms.TextMessage;
import javax.jms.QueueReceiver;
import javax.jms.JMSException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jms.JMSConnectionFactory;
import jp.ossc.nimbus.service.jms.JMSConnectionCreateException;
import jp.ossc.nimbus.service.jndi.JndiFinder;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            JMSConnectionFactory factory
                 = (JMSConnectionFactory)ServiceManagerFactory
                    .getServiceObject("ConnectionFactory");
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                    .getServiceObject("JndiFinder");
            
            // QueueConnectionを取得する
            QueueConnection connection = null;
            try{
                connection = (QueueConnection)factory.getConnection();
                System.out.println("QueueConnection生成");
            }catch(JMSConnectionCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            // Queueを取得する
            Queue queue = null;
            try{
                queue = (Queue)finder.lookup("queue/ex");
                System.out.println("Queue取得");
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // QueueSessionを生成する
                QueueSession session = connection.createQueueSession(
                    false,
                    Session.AUTO_ACKNOWLEDGE
                );
                System.out.println("QueueSession生成");
                
                // QueueSenderを生成する
                QueueSender sender = session.createSender(queue);
                System.out.println("QueueSender生成");
                
                // メッセージを送信する
                TextMessage message = session.createTextMessage();
                message.setText("Hello!");
                System.out.println("メッセージ送信 : " + message.getText());
                sender.send(message);
                System.out.println("メッセージ送信完了");
                sender.close();
                
                // QueueReceiverを生成する
                QueueReceiver receiver = session.createReceiver(queue);
                System.out.println("QueueReceiver生成");
                
                // メッセージを受信する
                System.out.println("メッセージ受信待ち");
                connection.start();
                message = (TextMessage)receiver.receive();
                System.out.println("メッセージ受信 : " + message.getText());
                receiver.close();
                
                session.close();
                connection.close();
            }catch(JMSException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
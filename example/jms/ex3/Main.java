
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
import jp.ossc.nimbus.service.jms.JMSMessageProducerFactory;
import jp.ossc.nimbus.service.jms.JMSMessageProducerCreateException;
import jp.ossc.nimbus.service.jndi.JndiFinder;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            JMSMessageProducerFactory factory
                 = (JMSMessageProducerFactory)ServiceManagerFactory
                    .getServiceObject("MessageProducerFactory");
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                    .getServiceObject("JndiFinder");
            
            // Queueを取得する
            Queue queue = null;
            try{
                queue = (Queue)finder.lookup("queue/ex");
                System.out.println("Queue取得");
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            QueueSender sender = null;
            try{
                // QueueSenderを生成する
                sender = (QueueSender)factory.createProducer();
                System.out.println("QueueSender生成");
            }catch(JMSMessageProducerCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // メッセージを送信する
                QueueSession session = (QueueSession)factory.getSession();
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
                QueueConnection connection = (QueueConnection)factory
                    .getSessionFactory().getConnection();
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
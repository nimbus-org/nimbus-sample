
import javax.naming.NamingException;

import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.jms.TextMessage;
import javax.jms.QueueReceiver;
import javax.jms.JMSException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jms.JMSMessageProducerFactory;
import jp.ossc.nimbus.service.jms.JMSMessageProducerCreateException;
import jp.ossc.nimbus.service.jms.JMSMessageConsumerFactory;
import jp.ossc.nimbus.service.jms.JMSMessageConsumerCreateException;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            JMSMessageProducerFactory producerFactory
                 = (JMSMessageProducerFactory)ServiceManagerFactory
                    .getServiceObject("MessageProducerFactory");
            
            QueueSender sender = null;
            try{
                // QueueSenderを生成する
                sender = (QueueSender)producerFactory.createProducer();
                System.out.println("QueueSender生成");
            }catch(JMSMessageProducerCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // メッセージを送信する
                QueueSession session
                     = (QueueSession)producerFactory.getSession();
                TextMessage message = session.createTextMessage();
                message.setText("Hello!");
                System.out.println("メッセージ送信 : " + message.getText());
                sender.send(message);
                System.out.println("メッセージ送信完了");
                sender.close();
                session.close();
            }catch(JMSException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            // サービスを取得する
            JMSMessageConsumerFactory consumerFactory
                 = (JMSMessageConsumerFactory)ServiceManagerFactory
                    .getServiceObject("MessageConsumerFactory");
            
            QueueReceiver receiver = null;
            try{
                // QueueReceiverを生成する
                receiver = (QueueReceiver)consumerFactory.createConsumer();
                System.out.println("QueueReceiver生成");
            }catch(JMSMessageConsumerCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // メッセージを受信する
                System.out.println("メッセージ受信待ち");
                QueueConnection connection = (QueueConnection)consumerFactory
                    .getSessionFactory().getConnection();
                connection.start();
                TextMessage message = (TextMessage)receiver.receive();
                System.out.println("メッセージ受信 : " + message.getText());
                receiver.close();
                
                QueueSession session
                     = (QueueSession)consumerFactory.getSession();
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
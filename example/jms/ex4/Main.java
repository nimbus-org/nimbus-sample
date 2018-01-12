
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
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            JMSMessageProducerFactory producerFactory
                 = (JMSMessageProducerFactory)ServiceManagerFactory
                    .getServiceObject("MessageProducerFactory");
            
            QueueSender sender = null;
            try{
                // QueueSender�𐶐�����
                sender = (QueueSender)producerFactory.createProducer();
                System.out.println("QueueSender����");
            }catch(JMSMessageProducerCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // ���b�Z�[�W�𑗐M����
                QueueSession session
                     = (QueueSession)producerFactory.getSession();
                TextMessage message = session.createTextMessage();
                message.setText("Hello!");
                System.out.println("���b�Z�[�W���M : " + message.getText());
                sender.send(message);
                System.out.println("���b�Z�[�W���M����");
                sender.close();
                session.close();
            }catch(JMSException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            // �T�[�r�X���擾����
            JMSMessageConsumerFactory consumerFactory
                 = (JMSMessageConsumerFactory)ServiceManagerFactory
                    .getServiceObject("MessageConsumerFactory");
            
            QueueReceiver receiver = null;
            try{
                // QueueReceiver�𐶐�����
                receiver = (QueueReceiver)consumerFactory.createConsumer();
                System.out.println("QueueReceiver����");
            }catch(JMSMessageConsumerCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // ���b�Z�[�W����M����
                System.out.println("���b�Z�[�W��M�҂�");
                QueueConnection connection = (QueueConnection)consumerFactory
                    .getSessionFactory().getConnection();
                connection.start();
                TextMessage message = (TextMessage)receiver.receive();
                System.out.println("���b�Z�[�W��M : " + message.getText());
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
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

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
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            JMSConnectionFactory factory
                 = (JMSConnectionFactory)ServiceManagerFactory
                    .getServiceObject("ConnectionFactory");
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                    .getServiceObject("JndiFinder");
            
            // QueueConnection���擾����
            QueueConnection connection = null;
            try{
                connection = (QueueConnection)factory.getConnection();
                System.out.println("QueueConnection����");
            }catch(JMSConnectionCreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            // Queue���擾����
            Queue queue = null;
            try{
                queue = (Queue)finder.lookup("queue/ex");
                System.out.println("Queue�擾");
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // QueueSession�𐶐�����
                QueueSession session = connection.createQueueSession(
                    false,
                    Session.AUTO_ACKNOWLEDGE
                );
                System.out.println("QueueSession����");
                
                // QueueSender�𐶐�����
                QueueSender sender = session.createSender(queue);
                System.out.println("QueueSender����");
                
                // ���b�Z�[�W�𑗐M����
                TextMessage message = session.createTextMessage();
                message.setText("Hello!");
                System.out.println("���b�Z�[�W���M : " + message.getText());
                sender.send(message);
                System.out.println("���b�Z�[�W���M����");
                sender.close();
                
                // QueueReceiver�𐶐�����
                QueueReceiver receiver = session.createReceiver(queue);
                System.out.println("QueueReceiver����");
                
                // ���b�Z�[�W����M����
                System.out.println("���b�Z�[�W��M�҂�");
                connection.start();
                message = (TextMessage)receiver.receive();
                System.out.println("���b�Z�[�W��M : " + message.getText());
                receiver.close();
                
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
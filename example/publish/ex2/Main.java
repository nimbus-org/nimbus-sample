
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.ServerConnection;
import jp.ossc.nimbus.service.publish.Message;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            System.out.println("�N���C�A���g���N��������A���M���郁�b�Z�[�W����͂��ĉ������B");
            
            // �T�[�r�X���擾����
            ServerConnectionFactory factory
                 = (ServerConnectionFactory)ServiceManagerFactory
                    .getServiceObject("ConnectionFactory");
            try{
                // �T�[�o�R�l�N�V�������擾
                ServerConnection connection = factory.getServerConnection();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while((line = br.readLine()) != null){
                    
                    // ���b�Z�[�W�𐶐�
                    Message message = connection.createMessage(System.getProperty("Subject"), null);
                    message.setObject(line);
                    
                    // ���b�Z�[�W�𑗐M
                    connection.send(message);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
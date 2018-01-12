
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���W���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                // �擾�����T�[�r�X�́APOJOService�̃C���X�^���X�ł��邪�A
                // getMessage()���Ăяo�����C���X�^���X�́AMockService
                // �ƂȂ�
                System.out.println("�擾�����T�[�r�X : " + service1);
                System.out.println("Service1��getMessage() : " + service1.getMessage());
                
            }else{
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
            }
            
            // �T�[�r�X��`�t�@�C�����A�����[�h����
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �A�X�y�N�g��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("aspect-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���R���s�N���X�B
 * �A�X�y�N�g��`�����[�h���邽�߁A���I�A�X�y�N�g���|����B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                System.out.println("POJOService.getMessage2() : " + service1.getMessage2());
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
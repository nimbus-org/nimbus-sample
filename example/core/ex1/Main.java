
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("Nimbus�}�l�[�W������擾�����T�[�r�X�F" + service1);
            
            // �T�[�r�X���擾����
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Group1", "Service1");
            
            System.out.println("Group1�}�l�[�W������擾�����T�[�r�X�F" + service1);
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
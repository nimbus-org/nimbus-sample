
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.core.ServiceNotFoundException;

import sample.service.SampleService;

/**
 * �T���v���X���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �e���v���[�g�T�[�r�X���擾����
            try{
                SampleService template = (SampleService)ServiceManagerFactory
                    .getServiceObject("TemplateService");
            }catch(ServiceNotFoundException e){
                System.out.println("�e���v���[�g�͎擾�ł��܂���");
            }
            
            // �T�[�r�X1���擾����
            SampleService service1 = (SampleService)ServiceManagerFactory
                .getServiceObject("Service1");
            System.out.println("�擾�����T�[�r�X�F" + service1);
            service1.printMessage();
            
            // �T�[�r�X2���擾����
            SampleService service2 = (SampleService)ServiceManagerFactory
                .getServiceObject("Service2");
            System.out.println("�擾�����T�[�r�X�F" + service2);
            service2.printMessage();
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
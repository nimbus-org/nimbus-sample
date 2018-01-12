
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("�擾�����T�[�r�X�F" + service1);
            
            System.out.println("field�v�f�Őݒ肵������ isPrint �̒l�F" + service1.isPrint);
            
            System.out.println("attribute�v�f�Őݒ肵������ IntValue �̒l�F" + service1.getIntValue());
            
            System.out.println("attribute�v�f�Őݒ肵������ Calendar �̒l�F" + service1.getCalendar().getTime());
            
            System.out.println("attribute�v�f�Őݒ肵������ ImageWriter �̒l�F" + service1.getImageWriter());
            
            service1.printMap();
            
            service1.printIndex();
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.core.DefaultServiceLoaderConfig;

import sample.service.POJOService;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // ServiceLoaderConfig�𐶐�����
        // �T�[�r�X��`�t�@�C���̃��[�h���ɁAServiceLoaderConfig��
        // �n�����ŁA�T�[�r�X��`���̃v���p�e�B�Q�ƂŎQ�Ƃł���
        DefaultServiceLoaderConfig config = new DefaultServiceLoaderConfig();
        config.setProperty(
            "loder.Message",
            "ServiceLoaderConfig�̃v���p�e�B�ł��B"
        );
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml", config, false, false)){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            // JavaVM�̃V�X�e���v���p�e�B���Q�Ƃ����T�[�r�X
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager1", "Service1");
            System.out.println("JavaVM�̃V�X�e���v���p�e�B���Q�Ƃ����T�[�r�X : " + service1);
            
            // server-property���Q�Ƃ����T�[�r�X
            POJOService service2 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager1", "Service2");
            System.out.println("server-property���Q�Ƃ����T�[�r�X : " + service2);
            
            // manager-property���Q�Ƃ����T�[�r�X
            POJOService service3 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager2", "Service1");
            System.out.println("manager-property���Q�Ƃ����T�[�r�X : " + service3);
            
            // ServiceLoaderConfig���Q�Ƃ����T�[�r�X
            POJOService service4 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager2", "Service2");
            System.out.println("ServiceLoaderConfig���Q�Ƃ����T�[�r�X : " + service4);
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
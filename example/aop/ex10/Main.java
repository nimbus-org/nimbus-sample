
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Caller;

/**
 * �T���v���P�O���s�N���X�B
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
                final Caller service1 = (Caller)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                try{
                    service1.call1();
                }catch(Exception e){
                    System.out.println("��O���������܂����B" + e);
                }
                try{
                    service1.call2();
                }catch(Exception e){
                    System.out.println("��O���������܂����B" + e);
                }
                try{
                    service1.call3();
                }catch(Exception e){
                    System.out.println("��O���������܂����B" + e);
                }
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
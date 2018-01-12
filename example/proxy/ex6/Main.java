
import jp.ossc.nimbus.core.ServiceManagerFactory;

import java.util.Map;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Map map = (Map)ServiceManagerFactory
                .getServiceObject("Map");
            while(true){
                try{
                    System.out.println(map.get("Message"));
                }catch(Exception e){
                    System.out.println("�Ăяo���Ɏ��s���܂����B" + e);
                }
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    break;
                }
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
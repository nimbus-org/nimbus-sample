
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;
import jp.ossc.nimbus.service.context.ServerInfo;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final ServerInfo context = (ServerInfo)ServiceManagerFactory
                .getServiceObject("Context");
            
            // �T�[�o�����擾����
            System.out.println(ServerInfo.OS_NAME_KEY + " = " + context.get(ServerInfo.OS_NAME_KEY));
            System.out.println(ServerInfo.HOST_NAME_KEY + " = " + context.get(ServerInfo.HOST_NAME_KEY));
            System.out.println(ServerInfo.TOTAL_MEMORY_KEY + " = " + context.getTotalMemory());
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Context context = (Context)ServiceManagerFactory
                .getServiceObject("Context");
            
            // �T�[�r�X��`�Őݒ�ς݂̃R���e�L�X�g�����擾����
            System.out.println("A = " + context.get("A"));
            System.out.println("B = " + context.get("B"));
            System.out.println("C = " + context.get("C"));
            
            // �R���e�L�X�g����ǉ�����
            context.put("D", "fuga");
            
            // �ǉ������R���e�L�X�g�����擾����
            System.out.println("D = " + context.get("D"));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
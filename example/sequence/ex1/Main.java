
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.sequence.Sequence;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Sequence sequence = (Sequence)ServiceManagerFactory
                .getServiceObject("Sequence");
            
            // �ʔԂ��o�͂���
            for(int i = 0; i < 100; i++){
                System.out.println("�ʔ�[" + i + "] : " + sequence.increment());
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
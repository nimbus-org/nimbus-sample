
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;
import jp.ossc.nimbus.service.log.Logger;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // Context�T�[�r�X���擾����
            Context context = (Context)ServiceManagerFactory
                .getServiceObject("Context");
            
            // Context�T�[�r�X�ɁA�C�ӂ̏���ݒ肷��
            // ���O�̓��I�ȃt�H�[�}�b�g�L�[���ڂƂ��Đݒ肷��B
            context.put("THREAD_NAME", Thread.currentThread().getName());
            
            // Logger�T�[�r�X���擾����
            Logger log = (Logger)ServiceManagerFactory
                .getServiceObject("Log");
            
            // �e���O���x���̃��O���o�͂���
            log.debug("Hi.");
            log.write("APL_001");
            log.write("APL_002", "Mr. Hoge");
            log.write("APL_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            log.write("APL_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            log.write("APL_005", "Mr. Hoge", new Exception("�e�X�g"));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
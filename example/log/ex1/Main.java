
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.log.Logger;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Logger log = (Logger)ServiceManagerFactory
                .getServiceObject("Log");
            
            // ���b�Z�[�W�𒼐ڎw�肵�āA�f�o�b�O���O���o�͂���
            log.debug("Hi.");
            
            // ���b�Z�[�WID���w�肵�āA�e���x���̃��O���o�͂���
            
            // SYSTEM_DEBUG���x���̃��O���o�͂���
            log.write("APL_001");
            
            // SYSTEM_INFO���x���̃��O���o�͂���
            // �܂��A���ߍ��݃��b�Z�[�W���w�肷��
            log.write("APL_002", "Mr. Hoge");
            
            // SYSTEM_WARN���x���̃��O���o�͂���
            // �܂��A�����̖��ߍ��݃��b�Z�[�W���w�肷��
            log.write("APL_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            
            // SYSTEM_ERROR���x���̃��O���o�͂���
            // �܂��A�����̖��ߍ��݃��b�Z�[�W���w�肷��
            // �A���A1�Ԗڂ̖��ߍ��݃��b�Z�[�W�̓V�[�N���b�g���ߍ��݃��b�Z�[�W
            log.write("APL_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            
            // SYSTEM_FATAL���x���̃��O���o�͂���
            // �܂��A���ߍ��݃��b�Z�[�W�ƁA��O���w�肷��
            log.write("APL_005", "Mr. Hoge", new Exception("�e�X�g"));
            
            // SYSTEM_FATAL���x���̃��O���o�͂���
            // �܂��A���ߍ��݃��b�Z�[�W�ƁA��O���w�肷��
            // �w�肵����O�́A���b�Z�[�W��`�ɂ���ďo�͂��Ȃ��悤�ɂȂ��Ă���
            log.write("APL_006", "Mr. Hoge", new Exception("�e�X�g"));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
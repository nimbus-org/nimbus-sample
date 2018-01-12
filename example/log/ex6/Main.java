
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import jp.ossc.nimbus.core.ServiceManagerFactory;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // Jakarta Commons Logging ��Log���擾����
            Log log = LogFactory.getLog(Main.class);
            
            // Jakarta Commons Logging �̊e���x���̃��O���o�͂���
            log.trace("Hi.");
            log.debug("Hello.");
            log.info("Good morning.");
            log.warn("Good afternoon.");
            log.error("Good evening.");
            log.fatal("Good night.", new Exception("�e�X�g"));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
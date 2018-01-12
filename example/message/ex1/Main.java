
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.message.MessageRecordFactory;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            MessageRecordFactory messageFactory
                 = (MessageRecordFactory)ServiceManagerFactory
                    .getServiceObject("MessageRecordFactory");
            
            // ���b�Z�[�WID���w�肵�āA���b�Z�[�W���擾����
            System.out.println(messageFactory.findMessage("MSG_001"));
            
            // ���ߍ��݃��b�Z�[�W���w�肷��
            System.out.println(messageFactory.findEmbedMessage("MSG_002", "Mr. Hoge"));
            
            // �����̖��ߍ��݃��b�Z�[�W���w�肷��
            System.out.println(messageFactory.findEmbedMessage("MSG_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"}));
            
            // �����̖��ߍ��݃��b�Z�[�W���w�肷��
            // �A���A1�Ԗڂ̖��ߍ��݃��b�Z�[�W�̓V�[�N���b�g���ߍ��݃��b�Z�[�W
            System.out.println(messageFactory.findEmbedMessage("MSG_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"}));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
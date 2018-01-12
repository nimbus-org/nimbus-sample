
import java.util.Date;
import java.util.HashMap;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.MessageWriter;
import jp.ossc.nimbus.service.writer.WritableRecordFactory;
import jp.ossc.nimbus.service.writer.WritableRecord;
import jp.ossc.nimbus.service.writer.MessageWriteException;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            MessageWriter writer = (MessageWriter)ServiceManagerFactory
                .getServiceObject("Writer");
            WritableRecordFactory recordFactory
                 = (WritableRecordFactory)ServiceManagerFactory
                    .getServiceObject("WritableRecordFactory");
            
            // �o�͏��𐶐�����
            HashMap map = new HashMap();
            map.put("DATE", new Date());
            map.put("MESSAGE", "�e�X�g�̃��b�Z�[�W�ł��B");
            
            // �o�͏����t�H�[�}�b�g����
            WritableRecord record = recordFactory.createRecord(map);
            
            // �o�͂���
            try{
                writer.write(record);
            }catch(MessageWriteException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
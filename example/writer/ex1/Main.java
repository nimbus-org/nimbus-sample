
import java.util.Date;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.MessageWriter;
import jp.ossc.nimbus.service.writer.WritableRecord;
import jp.ossc.nimbus.service.writer.SimpleElement;
import jp.ossc.nimbus.service.writer.DateElement;
import jp.ossc.nimbus.service.writer.MessageWriteException;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            MessageWriter writer = (MessageWriter)ServiceManagerFactory
                .getServiceObject("Writer");
            
            // �o�͏��𐶐�����
            WritableRecord record = new WritableRecord();
            record.addElement(new DateElement(new Date()));
            record.addElement(new SimpleElement(":"));
            record.addElement(new SimpleElement("�e�X�g�̃��b�Z�[�W�ł��B"));
            
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
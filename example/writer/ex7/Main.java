
import java.util.Date;
import java.util.HashMap;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.Category;
import jp.ossc.nimbus.service.writer.MessageWriteException;

import sample.SampleRecord;
import sample.User;

/**
 * �T���v���V���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Category category = (Category)ServiceManagerFactory
                .getServiceObject("Category");
            
            // �Ǝ��̏o�͏��𐶐�����
            SampleRecord record = new SampleRecord(
                new Date(),
                "�e�X�g�̃��b�Z�[�W�ł��B"
            );
            User user = new User("hoge");
            user.setProperty("Age", new Integer(20));
            user.setProperty("Sex", "Male");
            record.setUser(user);
            
            // �t�H�[�}�b�g���ďo�͂���
            try{
                category.write(record);
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
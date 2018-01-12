
import java.util.Date;
import java.util.HashMap;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.Category;
import jp.ossc.nimbus.service.writer.MessageWriteException;

/**
 * �T���v���T���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Category category = (Category)ServiceManagerFactory
                .getServiceObject("Category");
            
            // �o�͏��𐶐�����
            HashMap map = new HashMap();
            map.put("DATE", new Date());
            map.put("MESSAGE", "�e�X�g�̃��b�Z�[�W�ł��B");
            
            // �t�H�[�}�b�g���ďo�͂���
            try{
                category.write(map);
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
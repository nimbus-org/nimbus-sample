
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.cache.Cache;
import jp.ossc.nimbus.service.cache.CachedReference;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Cache cache = (Cache)ServiceManagerFactory
                .getServiceObject("Cache");
            
            // �L���b�V�����āA�L���b�V���Q�Ƃ����炤
            System.out.println("�L���b�V���ǉ�");
            CachedReference ref1 = cache.add("aaa");
            CachedReference ref2 = cache.add("bbb");
            
            // �L���b�V���̃T�C�Y���m�F����
            System.out.println("�L���b�V���T�C�Y : " + cache.size());
            
            // �L���b�V���Q�Ƃ���l�����o��
            System.out.println("�Q��1�̒l : " + ref1.get());
            System.out.println("�Q��2�̒l : " + ref2.get());
            
            // �L���b�V���Q�Ƃ��폜����
            System.out.println("�L���b�V���폜");
            ref1.remove();
            ref2.remove();
            
            // �L���b�V���̃T�C�Y���m�F����
            System.out.println("�L���b�V���T�C�Y : " + cache.size());
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;
import sample.service.Messenger;

/**
 * �T���v���Q���s�N���X�B
 * �A�X�y�N�g��`�����[�h���邽�߁A���I�A�X�y�N�g���|����B
 */
public class MainWithAspect{
    
    public static final void main(String[] args){
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        // �A�X�y�N�g�Ώۂ̃N���X�����[�h����T�[�r�X��`����
        // ��Ƀ��[�h���Ȃ���΂Ȃ�Ȃ��B
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                // ���ӁF
                // MainWithAspect�N���X�̃N���X���[�_�́A�V�X�e���N���X���[�_
                // �ł���̂ɑ΂��āA
                // POJOService�̃N���X���[�_�́ANimbus�N���X���[�_�ł���B
                // POJOService�N���X�́ANimbus�N���X���[�_�ɂ����
                // �A�X�y�N�g����A���I�ɃN���X��ύX����Ă���̂ŁA
                // �V�X�e���N���X���[�_���m���Ă���POJOService�N���X�Ƃ�
                // �قȂ�N���X�ł���B
                // ���̂��߁APOJOService�ɃL���X�g���悤�Ƃ���ƁA
                // ClassCastException���������Ă��܂��B
                // �A���A����̃N���X���[�_���ł̃L���X�g�Ȃ���Ȃ��B
                try{
                    POJOService service1 = (POJOService)ServiceManagerFactory
                        .getServiceObject("Service1");
                }catch(ClassCastException e){
                    System.out.println("POJOService �ɂ̓L���X�g�ł��Ȃ��B" + e);
                }
                
                // �A�X�y�N�g���Ă��Ȃ�POJOService�N���X���������Ă���
                // Messenger�C���^�t�F�[�X�Ƃ��Ď擾����
                Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // �A�X�y�N�g���|�����Ă��Ȃ����\�b�h���Ăяo��
                System.out.println("POJOService.getMessage() : " + service1.getMessage());
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                long start = System.currentTimeMillis();
                System.out.println("POJOService.getMessage2() : " + service1.getMessage2() + ", ��������[ms] : " + (System.currentTimeMillis() - start));
            }else{
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
            }
            
            // �T�[�r�X��`�t�@�C�����A�����[�h����
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �A�X�y�N�g��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("aspect-definition.xml");
    }
    
}
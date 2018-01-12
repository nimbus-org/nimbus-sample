
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * �T���v���Q���s�N���X�B
 * �A�X�y�N�g��`�̓��[�h���Ȃ����߁A���I�A�X�y�N�g�͊|����Ȃ��B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            POJOService service1 = (POJOService)ServiceManagerFactory
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
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler.Scheduler;
import jp.ossc.nimbus.service.scheduler.TimerSchedule;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Scheduler scheduler = (Scheduler)ServiceManagerFactory
                .getServiceObject("Scheduler");
            
            // �X�P�W���[�����S�ďI������܂ōő�20�b�ԑҋ@����
            scheduler.waitUntilScheduleClose(20000);
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
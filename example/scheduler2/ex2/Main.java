
import java.util.List;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler2.Schedule;
import jp.ossc.nimbus.service.scheduler2.ScheduleManager;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml") && ServiceManagerFactory.checkLoadManagerCompleted()){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            ScheduleManager scheduleManager = (ScheduleManager)ServiceManagerFactory
                .getServiceObject("ScheduleManager");
            
            // �X�P�W���[�����S�ďI������܂őҋ@����
            int allCount = scheduleManager.findAllSchedules().size();
            List schedules = null;
            do{
                schedules = scheduleManager.findSchedules(
                    new int[]{
                        Schedule.STATE_END,
                        Schedule.STATE_FAILED
                    }
                );
                Thread.sleep(5000);
            }while(schedules.size() != allCount);
            System.out.println(allCount + "���̃X�P�W���[�����I�����܂����B");
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
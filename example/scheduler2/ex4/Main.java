
import java.io.File;
import java.util.List;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler2.Schedule;
import jp.ossc.nimbus.service.scheduler2.ScheduleManager;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        new File("local/site1").mkdirs();
        new File("local/site2").mkdirs();
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            ScheduleManager scheduleManager = (ScheduleManager)ServiceManagerFactory
                .getServiceObject("ScheduleManager");
            
            // �X�P�W���[�����S�ďI������܂őҋ@����
            List schedules = null;
            do{
                schedules = scheduleManager.findSchedules(
                    new int[]{
                        Schedule.STATE_INITIAL,
                        Schedule.STATE_ENTRY,
                        Schedule.STATE_RUN,
                        Schedule.STATE_RETRY
                    }
                );
                Thread.sleep(1000);
            }while(schedules.size() != 0);
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
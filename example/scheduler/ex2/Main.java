
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler.Scheduler;
import jp.ossc.nimbus.service.scheduler.Schedule;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Scheduler scheduler = (Scheduler)ServiceManagerFactory
                .getServiceObject("Scheduler");
            
            // �X�P�W���[���̋N���L�[�Ƃ��āA���t�I�u�W�F�N�g�𐶐�����
            Object key = null;
            if(args.length == 1){
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                try{
                    key = format.parse(args[0]);
                }catch(ParseException e){
                    e.printStackTrace();
                    System.exit(-1);
                }
            }else{
                key = new Date();
            }
            
            // �X�P�W���[�����擾����
            System.out.println("���s����X�P�W���[���ꗗ");
            Schedule[] schdules = scheduler.getSchedules(key);
            for(int i = 0; i < schdules.length; i++){
                System.out.println(schdules[i].getName());
            }
            
            // �X�P�W���[�����N������
            System.out.println("�X�P�W���[���J�n");
            scheduler.startSchedule(key);
            
            // �X�P�W���[�����S�ďI������܂őҋ@����
            scheduler.waitUntilScheduleClose();
            System.out.println("�X�P�W���[���I��");
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
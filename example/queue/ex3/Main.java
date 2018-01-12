
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Queue queue = (Queue)ServiceManagerFactory
                .getServiceObject("Queue");
            
            // Queue�ɋl�߂�v�f��p�ӂ���
            final List list = new ArrayList();
            for(int i = 1; i <= 10; i++){
                list.add(new Date());
            }
            
            // Queue������������X���b�h���쐬����
            // ����������܂ő҂�������X���b�h
            Thread getter = new Thread(new Runnable(){
                public void run(){
                    while(list.size() != 0){
                        StringBuffer buf = new StringBuffer();
                        buf.append(Thread.currentThread().getName());
                        long start = System.currentTimeMillis();
                        Date pushDate = (Date)queue.get();
                        long end = System.currentTimeMillis();
                        if(pushDate == null){
                            buf.append(" : �����[�X��");
                            System.out.println(buf);
                        }else{
                            buf.append(" : �擾�f�[�^�x������=" + (end - pushDate.getTime()));
                            buf.append(" : �擾�҂�����=" + (end - start));
                            System.out.println(buf);
                            list.remove(pushDate);
                        }
                    }
                }
            }, "getter");
            // ����������܂�6�b�ԑ҂��āA���������Ȃ������炠����߂�X���b�h
            Thread getterWithTimeout = new Thread(new Runnable(){
                public void run(){
                    while(list.size() != 0){
                        StringBuffer buf = new StringBuffer();
                        buf.append(Thread.currentThread().getName());
                        long start = System.currentTimeMillis();
                        Date pushDate = (Date)queue.get(6000);
                        long end = System.currentTimeMillis();
                        if(pushDate == null){
                            buf.append(" : �^�C���A�E�g=" + (end - start));
                        }else{
                        buf.append(" : �擾�f�[�^�x������=" + (end - pushDate.getTime()));
                            buf.append(" : �擾�҂�����=" + (end - start));
                        }
                        System.out.println(buf);
                        list.remove(pushDate);
                    }
                }
            }, "getterWithTimeout");
            
            // Queue������������X���b�h���J�n����
            getter.start();
            getterWithTimeout.start();
            
            // 1�b����Queue�ɋl�߂�
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
            Date[] dates = (Date[])list.toArray(new Date[list.size()]);
            for(int i = 0; i < dates.length; i++){
                dates[i].setTime(System.currentTimeMillis());
                queue.push(dates[i]);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                }
            }
            try{
                Thread.sleep(20000);
            }catch(InterruptedException e){
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
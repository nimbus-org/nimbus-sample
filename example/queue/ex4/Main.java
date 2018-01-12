
import java.util.Date;
import java.text.SimpleDateFormat;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Queue queue = (Queue)ServiceManagerFactory
                .getServiceObject("Queue");
            
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            if("get".equals(args[0])){
                Object element = null;
                while((element = queue.get(1000)) != null){
                    System.out.println("get : " + element);
                }
            }else{
                for(int i = 0; i < 3; i++){
                    if(i != 0){
                        Thread.sleep(1000);
                    }
                    String time = format.format(new Date());
                    System.out.println("push : " + time);
                    queue.push(time);
                }
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
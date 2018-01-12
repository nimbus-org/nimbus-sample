
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                // 100�X���b�h�ŁA�����Ƀ��\�b�h���Ăяo��
                Thread[] threads = new Thread[100];
                for(int i = 0; i < threads.length; i++){
                    threads[i] = new Thread(
                        new Runnable(){
                            public void run(){
                                System.out.println(Thread.currentThread().getName() + " : POJOService.getMessage2() : " + service1.getMessage2());
                            }
                        },
                        "Thread" + (i + 1)
                    );
                }
                for(int i = 0; i < threads.length; i++){
                    threads[i].start();
                }
                for(int i = 0; i < threads.length; i++){
                    threads[i].join();
                }
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
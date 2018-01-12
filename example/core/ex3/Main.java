
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �ʏ�̃T�[�r�X���擾����
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("�ʏ�̃T�[�r�X�擾1��ځF" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("�ʏ�̃T�[�r�X�擾2��ځF" + service1);
            
            // instance������factory�ɐݒ肵���T�[�r�X���擾����
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service2");
            
            System.out.println("�t�@�N�g���T�[�r�X�擾1��ځF" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service2");
            
            System.out.println("�t�@�N�g���T�[�r�X�擾2��ځF" + service1);
            
            // instance������threadlocal�ɐݒ肵���T�[�r�X���擾����
            Thread thread1 = new Thread(
                new Runnable(){
                    public void run(){
                        
                        POJOService service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        String threadName = Thread.currentThread().getName();
                        System.out.println("ThreadLocal�t�@�N�g���T�[�r�X���X���b�h" + threadName + "�Ŏ擾1��ځF" + service);
                        
                        service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        System.out.println("ThreadLocal�t�@�N�g���T�[�r�X���X���b�h" + threadName + "�Ŏ擾2��ځF" + service);
                    }
                }
            );
            
            Thread thread2 = new Thread(
                new Runnable(){
                    public void run(){
                        
                        POJOService service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        String threadName = Thread.currentThread().getName();
                        System.out.println("ThreadLocal�t�@�N�g���T�[�r�X���X���b�h" + threadName + "�Ŏ擾�F" + service);
                    }
                }
            );
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            
            // instance������factory
            // management������true�ɐݒ肵���T�[�r�X���擾����
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service4");
            
            System.out.println("�t�@�N�g������T�[�r�X�擾�F" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service4$0");
            
            System.out.println("�t�@�N�g�����琶������o�^���ꂽ�T�[�r�X�擾�F" + service1);
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
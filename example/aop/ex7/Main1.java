
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���V���s�N���X�B
 */
public class Main1{
    
    public static final void main(String[] args) throws Exception{
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("aspect-definition1.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                final Messenger service2 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service2");
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                // (1)POJOService1.getMessage()�̏������Ԃ�1�b
                // (2)POJOService2.getMessage2()�̏������Ԃ�0.5�b
                // �ł��邽�߁A(2)�̕�����ɏI���͂��ł��邪�A
                // �A�X�y�N�g��VM�������|�����Ă��邽�߁A
                // (1)���I���܂ŁA(2)�͑҂������B
                // �]���āA(1)�A(2)�̏��ɏI���B
                Thread thread1 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(1)POJOService1.getMessage() : " + service1.getMessage());
                        }
                    }
                );
                Thread thread2 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(2)POJOService2.getMessage2() : " + service2.getMessage2());
                        }
                    }
                );
                thread1.start();
                thread2.start();
                
                thread1.join();
                thread2.join();
            }else{
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
            }
            
            // �T�[�r�X��`�t�@�C�����A�����[�h����
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �A�X�y�N�g��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("aspect-definition1.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���V���s�N���X�B
 */
public class Main3{
    
    public static final void main(String[] args) throws Exception{
        
        // �A�X�y�N�g��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("aspect-definition3.xml")){
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                // �T�[�r�X���擾����
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                final Messenger service2 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service2");
                final Messenger service3 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service3");
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                // (1)POJOService1.getMessage3(1000)�̏������Ԃ�1�b
                // (2)POJOService2.getMessage3(500)�̏������Ԃ�0.5�b
                // (3)POJOService1.getMessage2()�̏������Ԃ�0.5�b
                // (4)POJOService1.getMessage3(500)�̏������Ԃ�0.5�b
                // �ł��邽�߁A(2)(3)(4)�A(1)�̏��ɏI���͂��ł��邪�A
                // �A�X�y�N�g�Ń��\�b�h�������|�����Ă��邽�߁A
                // �������\�b�h�ւ̌Ăяo���ł���(1)��(4)�́A
                // (1)���I���܂ŁA(4)���҂������B
                // �܂��A(2)�́A�N���X���قȂ邽�߁A��������Ȃ��B
                // �܂��A(3)�́A���\�b�h���قȂ邽�߁A��������Ȃ��B
                // �]���āA(2)(3)�A(1)�A(4)�̏��ɏI���B
                Thread thread1 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(1)POJOService1.getMessage3(1000) : " + service1.getMessage3(1000));
                        }
                    }
                );
                Thread thread2 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(2)POJOService2.getMessage3(500) : " + service2.getMessage3(500));
                        }
                    }
                );
                Thread thread3 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(3)POJOService1.getMessage2() : " + service3.getMessage2());
                        }
                    }
                );
                Thread thread4 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(4)POJOService1.getMessage3(500) : " + service3.getMessage3(500));
                        }
                    }
                );
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                
                thread1.join();
                thread2.join();
                thread3.join();
                thread4.join();
            }else{
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
            }
            
            // �T�[�r�X��`�t�@�C�����A�����[�h����
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("�A�X�y�N�g��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �A�X�y�N�g��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("aspect-definition3.xml");
    }
    
}
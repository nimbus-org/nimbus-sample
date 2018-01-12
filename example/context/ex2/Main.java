
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Context context = (Context)ServiceManagerFactory
                .getServiceObject("Context");
            
            Runnable runnable = new Runnable(){
                public void run(){
                    
                    // �X���b�h�����擾����
                    String name = Thread.currentThread().getName();
                    
                    // �T�[�r�X��`�Őݒ�ς݂̃R���e�L�X�g�����擾����
                    System.out.println(name + " : A = " + context.get("A"));
                    System.out.println(name + " : B = " + context.get("B"));
                    System.out.println(name + " : C = " + context.get("C"));
                    
                    // �R���e�L�X�g����ǉ�����
                    context.put("D", name);
                    
                    // �ǉ������R���e�L�X�g�����擾����
                    System.out.println(name + " : D = " + context.get("D"));
                }
            };
            
            // �X���b�h���J�n����
            Thread thread1 = new Thread(runnable, "Thread1");
            Thread thread2 = new Thread(runnable, "Thread2");
            Thread thread3 = new Thread(runnable, "Thread3");
            thread1.start();
            thread2.start();
            thread3.start();
            try{
                thread1.join();
                thread2.join();
                thread3.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
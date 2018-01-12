
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.semaphore.Semaphore;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Semaphore semaphore = (Semaphore)ServiceManagerFactory
                .getServiceObject("Semaphore");
            
            // ���\�[�X�̎c����m�F����
            System.out.println("�c�胊�\�[�X�� : " + semaphore.getResourceRemain());
            
            // �Z�}�t�H�l��
            for(int i = 1; i <= 3; i++){
                System.out.print("�Z�}�t�H�l��[" + i + "]...");
                long start = System.currentTimeMillis();
                if(semaphore.getResource(500l)){
                    long end = System.currentTimeMillis();
                    System.out.println("���� " + (end - start) + "[ms]");
                    System.out.println("�c�胊�\�[�X�� : " + semaphore.getResourceRemain());
                }else{
                    long end = System.currentTimeMillis();
                    System.out.println("���s " + (end - start) + "[ms]");
                }
            }
            
            System.out.println();
            
            // �Z�}�t�H�J��
            for(int i = 1; i <= 2; i++){
                System.out.print("�Z�}�t�H�J��[" + i + "] ");
                semaphore.freeResource();
                System.out.println("�c�胊�\�[�X�� : " + semaphore.getResourceRemain());
            }
            
            System.out.println();
            
            // �Z�}�t�H�l���X���b�h���쐬����
            Runnable getterRunnable = new Runnable(){
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " : �Z�}�t�H�l��...");
                    if(semaphore.getResource()){
                        System.out.println(Thread.currentThread().getName() + " : ����");
                    }else{
                        System.out.println(Thread.currentThread().getName() + " : ���s");
                    }
                }
            };
            
            // �Z�}�t�H�l��
            for(int i = 1; i <= 4; i++){
                Thread thread = new Thread(getterRunnable);
                thread.start();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            
            // �Z�}�t�H�l���҂����m�F����
            System.out.println("�Z�}�t�H�l���҂��� : " + semaphore.getWaitingCount());
            
            // �Z�}�t�H�l���҂������w�肵�āA�Z�}�t�H�l��
            // �҂������w�肵�����ȏ�̏ꍇ�A�l���Ɏ��s����
            System.out.print("�Z�}�t�H�l���҂���2���w�肵�ăZ�}�t�H�l��...");
            if(semaphore.getResource(2)){
                System.out.println("����");
            }else{
                System.out.println("���s");
            }
            
            // �Z�}�t�H�l���҂����ĊJ����
            System.out.println("�Z�}�t�H�҂�������~");
            semaphore.release();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println("�Z�}�t�H�҂������J�n");
            semaphore.accept();
            
            // �Z�}�t�H�l���㋭���J�����Ԃ��w�肵�āA�Z�}�t�H�l��
            // �Z�}�t�H�l���㎞�Ԃ��w�肵�����Ԃ𒴂���ƁA�����I�ɊJ�������
            System.out.print("�Z�}�t�H�l���㋭���J�����Ԃ�1�b���w�肵�ăZ�}�t�H�l��...");
            Thread thread = new Thread(getterRunnable);
            thread.start();
            if(semaphore.getResource(-1, -1, 1000)){
                System.out.println("����");
            }else{
                System.out.println("���s");
            }
            
            try{
                Thread.sleep(500);
                System.out.println("0.5�b�� �c�胊�\�[�X�� : " + semaphore.getResourceRemain());
                Thread.sleep(500);
                System.out.println("1.0�b�� �c�胊�\�[�X�� : " + semaphore.getResourceRemain());
            }catch(InterruptedException e){
            }
            
            System.out.println();
            
            // �Z�}�t�H�l���҂����J������
            System.out.println("�Z�}�t�H�l���҂��J��");
            semaphore.release();
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
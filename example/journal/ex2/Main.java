
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.journal.Journal;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Journal journal = (Journal)ServiceManagerFactory
                .getServiceObject("Journal");
            
            // �W���[�i�����o�͂���X���b�h���쐬����
            Runnable runnable = new Runnable(){
                public void run(){
                    try{
                        // �W���[�i�����J�n����
                        journal.startJournal(Thread.currentThread().getName());
                        
                        // �W���[�i���ɃW���[�i������ǉ�����
                        journal.addInfo("INT", new Integer(1));
                        journal.addInfo("ARRAY", new String[]{"A", "B", "C"});
                        
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException e){
                        }
                        
                        try{
                            // �W���[�i���X�e�b�v���J�n����
                            // ����q�ɂ������ꍇ�ɁA�X�e�b�v���g�p����
                            journal.addStartStep("Step1");
                            
                            try{
                                Thread.sleep(200);
                            }catch(InterruptedException e){
                            }
                            
                            // �W���[�i���X�e�b�v�ɃW���[�i������ǉ�����
                            journal.addInfo("STRING", "D");
                        }finally{
                            // �W���[�i���X�e�b�v���I������
                            // �X�e�b�v�̏I���́A�J�n(addStartStep())��
                            // �΂ɂȂ��ĕK���Ă΂Ȃ���΂Ȃ�Ȃ�
                            // ���̂��߁Atry�`finally�߂��g���āA
                            // �K���΂ŌĂяo���܂��傤�B
                            journal.addEndStep();
                        }
                        
                    }finally{
                        
                        // �W���[�i�����I������
                        // �W���[�i���̏I���́A�J�n(startJournal())��
                        // �΂ɂȂ��ĕK���Ă΂Ȃ���΂Ȃ�Ȃ�
                        // ���̂��߁Atry�`finally�߂��g���āA
                        // �K���΂ŌĂяo���܂��傤�B
                        journal.endJournal();
                    }
                }
            };
            Thread thread1 = new Thread(runnable, "JournalThread1");
            Thread thread2 = new Thread(runnable, "JournalThread2");
            
            // �X���b�h���J�n����
            thread1.start();
            thread2.start();
            
            // �X���b�h�̏I����ҋ@����
            try{
                thread1.join();
                thread2.join();
            }catch(InterruptedException e){
            }
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
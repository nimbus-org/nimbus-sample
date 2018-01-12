
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * �T���v���U���s�N���X�B
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
                long start = 0;
                System.out.println("getMessage���\�b�h�Ăяo���~�P�O");
                for(int i = 0; i < 10; i++){
                    start = System.currentTimeMillis();
                    service1.getMessage();
                    System.out.println("getMessage���\�b�h��������" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                System.out.println("displayMessage���\�b�h�Ăяo���~�T");
                for(int i = 0; i < 5; i++){
                    start = System.currentTimeMillis();
                    service1.displayMessage();
                    System.out.println("displayMessage���\�b�h��������" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                System.out.println("displayMessage2���\�b�h�Ăяo���~�T");
                for(int i = 0; i < 5; i++){
                    start = System.currentTimeMillis();
                    service1.displayMessage2(100 * (i + 1));
                    System.out.println("displayMessage2���\�b�h��������" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
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
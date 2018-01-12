
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.aop.interceptor.AsynchronousTimeoutException;

import sample.service.Messenger;

/**
 * �T���v���T���s�N���X�B
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
                // �񓯊��������s�����߁A���ۂ�displayMessage()���\�b�h��
                // �Ăяo�����O�ɉ������Ԃ��Ă���
                long start = System.currentTimeMillis();
                System.out.println("displayMessage���\�b�h�Ăяo���~�R �J�n");
                service1.displayMessage();
                service1.displayMessage();
                service1.displayMessage();
                System.out.println("displayMessage���\�b�h�Ăяo���~�R �I�� : " + (System.currentTimeMillis() - start) + "[ms]");
                
                // �񓯊��������I���̂�҂����킹��
                Thread.sleep(2000);
                
                // �A�X�y�N�g���|�����Ă��郁�\�b�h���Ăяo��
                // �񓯊������Ƀ^�C���A�E�g�ݒ���s���Ă��邽�߁A
                // displayMessage2()���\�b�h�̏������Ԃ��A�^�C���A�E�g�ݒ�l
                //�i1�b�j���������Ɨ�O����������
                // �A���A�^�C���A�E�g���Ă��A�񓯊��������̂̓L�����Z������Ȃ�
                System.out.println("displayMessage2���\�b�h�i��������500[ms]�j�Ăяo���J�n");
                start = System.currentTimeMillis();
                service1.displayMessage2(500);
                System.out.println("displayMessage2���\�b�h�Ăяo���I�� : " + (System.currentTimeMillis() - start) + "[ms]");
                
                start = System.currentTimeMillis();
                try{
                    System.out.println("displayMessage2���\�b�h�i��������2000[ms]�j�Ăяo���J�n");
                    service1.displayMessage2(2000);
                    System.out.println("displayMessage2���\�b�h�Ăяo���I�� : " + (System.currentTimeMillis() - start) + "[ms]");
                }catch(AsynchronousTimeoutException e){
                    System.out.println("displayMessage2���\�b�h�^�C���A�E�g���� : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                
                // �񓯊��������I���̂�҂����킹��
                Thread.sleep(2000);
                
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
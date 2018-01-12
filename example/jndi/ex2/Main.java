
import java.io.IOException;
import java.io.InputStreamReader;

import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jndi.JndiFinder;

import sample.ejb.MessengerHome;
import sample.ejb.Messenger;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                .getServiceObject("JndiFinder");
            
            // 1��ڂ̌Ăяo��
            callMessenger(finder);
            
            // 2��ڂ̌Ăяo��
            callMessenger(finder);
            
            System.out.println("JBoss���V���b�g�_�E�����āAEnter�L�[�������ĉ������B");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // JNDI�T�[�o�_�E�����̌Ăяo��
            callMessenger(finder);
            
            System.out.println("JBoss���N�����āAEnter�L�[�������ĉ������B");
            try{
                new InputStreamReader(System.in).read();
                Thread.sleep(1500);
            }catch(IOException e){
            }catch(InterruptedException e){
            }
            
            // JNDI�T�[�o�ċN����̌Ăяo��
            callMessenger(finder);
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static void callMessenger(JndiFinder finder){
        
        MessengerHome home = null;
        try{
            // Messenger�Z�b�V����Bean��Home�C���^�t�F�[�X��lookup����
            long start = System.currentTimeMillis();
            home = (MessengerHome)finder.lookup("Messenger");
            System.out.println("JndiFinder�����lookup�������� : " + (System.currentTimeMillis() - start) + " [ms]");
            System.out.println("JndiFinder����lookup�����I�u�W�F�N�g : " + home);
        }catch(NamingException e){
            System.out.println("lookup�Ɏ��s���܂����F" + e.getMessage());;
            return;
        }
        
        try{
            // Messenger�Z�b�V����Bean��create����
            Messenger messenger = home.create();
            
            // Messenger�Z�b�V����Bean���Ăяo��
            System.out.println(messenger.getMessage());
            
        }catch(RemoteException e){
            e.printStackTrace();
        }catch(CreateException e){
            e.printStackTrace();
        }
    }
}
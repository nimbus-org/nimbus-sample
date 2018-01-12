
import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jndi.JndiFinder;

import sample.ejb.MessengerHome;
import sample.ejb.Messenger;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                .getServiceObject("JndiFinder");
            
            MessengerHome home = null;
            try{
                // Messenger�Z�b�V����Bean��Home�C���^�t�F�[�X��lookup����
                home = (MessengerHome)finder.lookup("Messenger");
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // Messenger�Z�b�V����Bean��create����
                Messenger messenger = home.create();
                
                // Messenger�Z�b�V����Bean���Ăяo��
                System.out.println(messenger.getMessage());
                
            }catch(RemoteException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(CreateException e){
                e.printStackTrace();
                System.exit(-1);
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
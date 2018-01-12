
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.ejb.EJBFactory;

import sample.ejb.MessengerHome;
import sample.ejb.MessengerHome2;
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
            EJBFactory factory = (EJBFactory)ServiceManagerFactory
                .getServiceObject("EJBFactory");
            
            Messenger messenger = null;
            try{
                // Messenger�Z�b�V����Bean���擾����
                // �����Ȃ���create���\�b�h��������EJB�����[�g�Q�Ƃ��擾����
                messenger = (Messenger)factory.get(
                    "Messenger",
                    MessengerHome.class
                );
                
                // Messenger�Z�b�V����Bean���Ăяo��
                System.out.println(messenger.getMessage());
                
                // Messenger�Z�b�V����Bean���擾����
                // ���������create���\�b�h��������EJB�����[�g�Q�Ƃ��擾����
                messenger = (Messenger)factory.get(
                    "Messenger2",
                    MessengerHome2.class,
                    new Class[]{String.class},
                    new Object[]{"hoge"}
                );
                
                // Messenger�Z�b�V����Bean���Ăяo��
                System.out.println(messenger.getMessage());
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(CreateException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(NoSuchMethodException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(IllegalAccessException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(InvocationTargetException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(RemoteException e){
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
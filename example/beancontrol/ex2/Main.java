
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            BeanFlowInvokerFactory factory
                 = (BeanFlowInvokerFactory)ServiceManagerFactory
                    .getServiceObject("BeanFlowInvokerFactory");
            BeanFlowInvoker invoker = null;
            try{
                // ���[�U�ꗗ�쐬�t���[���擾
                invoker = factory.createFlow("Public-CreateUserMap");
                
                // ���[�U�ꗗ�쐬�t���[�����s
                invoker.invokeFlow(null);
                
                // ���[�U�擾�t���[���擾
                invoker = factory.createFlow("Public-GetUser");
                
                // ���[�U�擾�t���[�����s
                Map user5 = (Map)invoker.invokeFlow("user5");
                Map user6 = (Map)invoker.invokeFlow("user6");
                System.out.println("���O,�N��,����");
                System.out.println(user5.get("name")
                    + "," + user5.get("age")
                    + "," + user5.get("sex"));
                System.out.println(user6.get("name")
                    + "," + user6.get("age")
                    + "," + user6.get("sex"));
                
            }catch(Exception e){
                e.printStackTrace();
                e.getCause().printStackTrace();
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
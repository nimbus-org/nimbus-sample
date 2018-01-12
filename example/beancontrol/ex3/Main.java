
import java.util.List;
import java.util.ArrayList;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * �T���v���R���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml") && ServiceManagerFactory.checkLoadManagerCompleted()){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            BeanFlowInvokerFactory factory
                 = (BeanFlowInvokerFactory)ServiceManagerFactory
                    .getServiceObject("BeanFlowInvokerFactory");
            BeanFlowInvoker invoker = null;
            try{
                // �񓯊��ŕ���Ɏ��s���āA�S�Ẳ�����҂t���[���擾����
                invoker = factory.createFlow("Test1");
                
                // ���̓I�u�W�F�N�g����������
                List input = new ArrayList();
                for(int i = 0; i < 10; i++){
                    input.add(new Integer(i));
                }
                
                // �t���[�����s
                Object output = invoker.invokeFlow(input);
                
                System.out.println("���X�|���X���Ԃ��Ă��܂����Boutput=" + output);
                
                // �񓯊��ŕ���Ɏ��s���āA�����̓R�[���o�b�N�t���[�ŏ�������t���[���擾����
                invoker = factory.createFlow("Test2");
                
                // �t���[�����s
                invoker.invokeFlow(input);
                
                // �R�[���o�b�N�t���[���Ăяo�����܂œK���ɑҋ@����
                Thread.sleep(6000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
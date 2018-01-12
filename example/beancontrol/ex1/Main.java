
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * �T���v���P���s�N���X�B
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
                // �e�[�u���쐬�t���[���擾
                invoker = factory.createFlow("CreateTable");
                
                // �e�[�u���쐬�t���[�����s
                System.out.println("�e�[�u���쐬");
                invoker.invokeFlow(null);
                
                // ���R�[�h�쐬�t���[���擾
                invoker = factory.createFlow("Insert");
                
                // ���͂̃��R�[�h�𐶐�
                System.out.println("���R�[�h�쐬");
                System.out.println("���O,�N��,����");
                List input = new ArrayList();
                for(int i = 0; i < 11; i++){
                    Map record = new HashMap();
                    record.put("name", "user" + i);
                    record.put("age", new Integer(i + 10));
                    record.put("sex", i % 2 == 0 ? "0" : "1");
                    input.add(record);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // ���R�[�h�쐬�t���[�����s
                invoker.invokeFlow(input);
                
                // ���R�[�h�����t���[���擾
                invoker = factory.createFlow("Search");
                
                // ���R�[�h�����t���[�����s
                // �S��������
                // �A���A�t���[�ɂāA5���܂ł����������ʂ�Ԃ��Ȃ�
                List output = (List)invoker.invokeFlow(null);
                System.out.println("�S�����i�ő�T���j");
                System.out.println("���O,�N��,����");
                for(int i = 0, max = output.size(); i < max; i++){
                    Map record = (Map)output.get(i);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // ���R�[�h�����t���[�����s
                // �����ŁA���[�U�������������Ƃ��ēn��
                // �������ʊY������
                System.out.println("���� : user10");
                Map record = (Map)invoker.invokeFlow("user10");
                System.out.println(record.get("name")
                    + "," + record.get("age")
                    + "," + record.get("sex"));
                
                // ���R�[�h�����t���[�����s
                // �����ŁA���[�U�������������Ƃ��ēn��
                // �������ʊY���Ȃ�
                System.out.println("���� : user100");
                record = (Map)invoker.invokeFlow("user100");
                System.out.println(record);
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                // �e�[�u���폜�t���[���擾
                invoker = factory.createFlow("DropTable");
                try{
                    // �e�[�u���폜�t���[�����s
                    System.out.println("�e�[�u���폜");
                    invoker.invokeFlow(null);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.util.converter.Converter;

import sample.*;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Converter converter1 = (Converter)ServiceManagerFactory.getServiceObject("BeanFlowConverter1");
            
            Bean1 bean1 = new Bean1();
            bean1.setA(100);
            bean1.setB("hoge");
            Bean2 bean2 = (Bean2)converter1.convert(bean1);
            System.out.println("//// Convert1 ////");
            System.out.println(bean2.getC());
            System.out.println(bean2.getD());
            
            // �T�[�r�X���擾����
            final Converter converter2 = (Converter)ServiceManagerFactory.getServiceObject("BeanFlowConverter2");
            
            bean1.setA(200);
            bean1.setB("fuga");
            bean2 = (Bean2)converter2.convert(bean1);
            System.out.println("//// Convert2 ////");
            System.out.println(bean2.getC());
            System.out.println(bean2.getD());
            
            bean1 = (Bean1)converter2.convert(bean2);
            System.out.println("//// Convert3 ////");
            System.out.println(bean1.getA());
            System.out.println(bean1.getB());
            
            // �T�[�r�X���擾����
            final Converter converter3 = (Converter)ServiceManagerFactory.getServiceObject("BeanFlowConverter3");
            
            bean1.setA(100);
            bean1.setB("hoge");
            bean2 = (Bean2)converter3.convert(bean1);
            System.out.println("//// Convert1 ////");
            System.out.println(bean2.getC());
            System.out.println(bean2.getD());
            
            bean1.setA(-100);
            bean2 = (Bean2)converter3.convert(bean1);
            System.out.println("//// Convert2 ////");
            System.out.println(bean2.getC());
            System.out.println(bean2.getD());
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
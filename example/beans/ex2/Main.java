
import java.util.*;

import jp.ossc.nimbus.beans.*;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        SampleBean bean = new SampleBean();
        bean.setSampleBean(new SampleBean());
        Map map = new HashMap();
        List list = new ArrayList();
        
        ///// �P���v���p�e�B�ւ̃A�N�Z�X /////
        System.out.println("//////// �P���v���p�e�B�ւ̃A�N�Z�X ///////////");
        
        // "String"�Ƃ������O�̃v���p�e�B�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property stringProperty = PropertyFactory.createProperty("String");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#setString(\"hoge\")");
        stringProperty.setProperty(bean, "hoge");
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getString() : " + stringProperty.getProperty(bean));
        
        // "Length"�Ƃ������O�̃v���p�e�B�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property lengthProperty = PropertyFactory.createProperty("Length");
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#length() : " + lengthProperty.getProperty(bean));
        
        // "Append"�Ƃ������O�̃v���p�e�B�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property appendProperty = PropertyFactory.createProperty("Append");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#append(\"fuga\")");
        appendProperty.setProperty(bean, "fuga");
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getString() : " + stringProperty.getProperty(bean));
        
        // "Object"�Ƃ������O�̃v���p�e�B�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property objectProperty = PropertyFactory.createProperty("Object");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("java.util.Map#put(\"Object\", new Integer(100))");
        objectProperty.setProperty(map, new Integer(100));
        
        // �v���p�e�B�l���擾����
        System.out.println("java.util.Map#get(\"Object\") : " + objectProperty.getProperty(map));
        
        
        
        ///// �C���f�b�N�X�v���p�e�B�ւ̃A�N�Z�X /////
        System.out.println();
        System.out.println("//////// �C���f�b�N�X�v���p�e�B�̃A�N�Z�X ///////////");
        
        // "LongValue"�Ƃ������O�̃C���f�b�N�X�v���p�e�B��3�Ԗڂ̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property longValueProperty = PropertyFactory.createProperty("LongValue[2]");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#setLongValue(2, 200L)");
        longValueProperty.setProperty(bean, new Long(200));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getLongValue(2) : " + longValueProperty.getProperty(bean));
        
        // "LongValues"�Ƃ������O�̃C���f�b�N�X�v���p�e�B��3�Ԗڂ̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property longValuesProperty = PropertyFactory.createProperty("LongValues[2]");
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getLongValues()[2] : " + longValuesProperty.getProperty(bean));
        
        // "LongValueList"�Ƃ������O�̃C���f�b�N�X�v���p�e�B��4�Ԗڂ̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property longValueListProperty = PropertyFactory.createProperty("LongValueList[3]");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#getLongValueList().set(3, 300L)");
        longValueListProperty.setProperty(bean, new Long(300));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getLongValueList().get(3) : " + longValueListProperty.getProperty(bean));
        
        // ���O�Ȃ��̃C���f�b�N�X�v���p�e�B��3�Ԗڂ̗v�f�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property listProperty = PropertyFactory.createProperty("[2]");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("java.util.List#set(2, new Long(100))");
        listProperty.setProperty(list, new Long(100));
        
        // �v���p�e�B�l���擾����
        System.out.println("java.util.List#get(2) : " + listProperty.getProperty(list));
        
        
        
        ///// �}�b�v�v���p�e�B�ւ̃A�N�Z�X /////
        System.out.println();
        System.out.println("//////// �}�b�v�v���p�e�B�̃A�N�Z�X ///////////");
        
        // "Double"�Ƃ������O�̃}�b�v�v���p�e�B��"a"�̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property doubleProperty = PropertyFactory.createProperty("Double(a)");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#setDouble(\"a\", 1.5d)");
        doubleProperty.setProperty(bean, new Double(1.5));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getDouble(\"a\") : " + doubleProperty.getProperty(bean));
        
        // "DoubleMap"�Ƃ������O�̃}�b�v�v���p�e�B��"b"�̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property doubleMapProperty = PropertyFactory.createProperty("DoubleMap(b)");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#getDoubleMap().put(\"b\", new Double(12.3d))");
        doubleMapProperty.setProperty(bean, new Double(12.3));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getDoubleMap().get(\"b\") : " + doubleMapProperty.getProperty(bean));
        
        // ���O�Ȃ��̃}�b�v�v���p�e�B��"key"�̗v�f�ɃA�N�Z�X����
        // Property�I�u�W�F�N�g���쐬����
        Property keyProperty = PropertyFactory.createProperty("(key)");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("java.util.Map#put(\"key\", \"HOGE\")");
        keyProperty.setProperty(map, "HOGE");
        
        // �v���p�e�B�l���擾����
        System.out.println("java.util.Map#get(\"key\") : " + keyProperty.getProperty(map));
        
        
        
        ///// �A���v���p�e�B�ւ̃A�N�Z�X /////
        System.out.println();
        System.out.println("//////// �A���v���p�e�B�̃A�N�Z�X ///////////");
        
        // "SampleBean"�Ƃ������O�̃v���p�e�B��
        // "String"�Ƃ������O�̃v���p�e�B��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property nestProperty1 = PropertyFactory.createProperty("SampleBean.String");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#getSampleBean().setString(\"fuga\")");
        nestProperty1.setProperty(bean, "fuga");
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getSampleBean().getString() : " + nestProperty1.getProperty(bean));
        
        // "SampleBean"�Ƃ������O�̃v���p�e�B��
        // "LongValue"�Ƃ������O�̃C���f�b�N�X�v���p�e�B��1�Ԗڂ̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property nestProperty2 = PropertyFactory.createProperty("SampleBean.LongValue[0]");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#getSampleBean().setLongValue(0, 150L)");
        nestProperty2.setProperty(bean, new Long(150));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getSampleBean().getLongValue(0) : " + nestProperty2.getProperty(bean));
        
        // "SampleBean"�Ƃ������O�̃v���p�e�B��
        // "Double"�Ƃ������O�̃}�b�v�v���p�e�B��"A"�̗v�f��
        // �A�N�Z�X����Property�I�u�W�F�N�g���쐬����
        Property nestProperty3 = PropertyFactory.createProperty("SampleBean.Double(A)");
        
        // �v���p�e�B�l��ݒ肷��
        System.out.println("SampleBean#getSampleBean().setDouble(\"A\", 456.78d)");
        nestProperty3.setProperty(bean, new Double(456.78));
        
        // �v���p�e�B�l���擾����
        System.out.println("SampleBean#getSampleBean().getDouble(\"A\") : " + nestProperty3.getProperty(bean));
    }
    
    public static class SampleBean{
        
        private String stringValue;
        
        // set����n�܂�ʏ��setter�A�N�Z�T
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public void setString(String val){
            stringValue = val;
        }
        
        // get����n�܂�ʏ��getter�A�N�Z�T
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public String getString(){
            return stringValue;
        }
        
        // get����n�܂�Ȃ�getter
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public int length(){
            return stringValue == null ? 0 : stringValue.length();
        }
        
        // set����n�܂�Ȃ�setter
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public void append(String val){
            if(stringValue == null){
                stringValue = val;
            }else{
                stringValue += val;
            }
        }
        
        private List longValues = new ArrayList();
        
        // set����n�܂�A��1������int�^�A��2�������C�ӂ̌^�ƂȂ�setter
        // �C���f�b�N�X�v���p�e�B�ŃA�N�Z�X�\
        public void setLongValue(int index, long val){
            for(int i = longValues.size(); i <= index; i++){
                longValues.add(null);
            }
            longValues.set(index, new Long(val));
        }
        
        // get����n�܂�A������int�^�ƂȂ�getter
        // �C���f�b�N�X�v���p�e�B�ŃA�N�Z�X�\
        public long getLongValue(int index){
            if(longValues.size() <= index){
                return -1L;
            }
            final Long val = (Long)longValues.get(index);
            return val == null ? -1L : val.longValue();
        }
        
        // get����n�܂�A�z��^��Ԃ�getter
        // �P���v���p�e�B�ŃA�N�Z�X�\
        //
        // �߂�l�̔z��v�f�ւ̃A�N�Z�X�́A
        // �C���f�b�N�X�v���p�e�B�ŃA�N�Z�X�\
        public long[] getLongValues(){
            long[] result = new long[longValues.size()];
            for(int i = 0; i < longValues.size(); i++){
                final Long val = (Long)longValues.get(i);
                if(val != null){
                    result[i] = val.longValue();
                }
            }
            return result;
        }
        
        // get����n�܂�Ajava.util.List�^��Ԃ�getter
        // �P���v���p�e�B�ŃA�N�Z�X�\
        //
        // �߂�l��java.util.List�̗v�f�ւ̃A�N�Z�X�́A
        // �C���f�b�N�X�v���p�e�B�ŃA�N�Z�X�\
        public List getLongValueList(){
            return longValues;
        }
        
        private Map doubleMap = new HashMap();
        
        // set����n�܂�A��1������String�^�A��2�������C�ӂ̌^�ƂȂ�setter
        // �}�b�v�v���p�e�B�ŃA�N�Z�X�\
        public void setDouble(String key, double val){
            doubleMap.put(key, new Double(val));
        }
        
        // get����n�܂�A������String�^�ƂȂ�getter
        // �}�b�v�v���p�e�B�ŃA�N�Z�X�\
        public double getDouble(String key){
            final Double val = (Double)doubleMap.get(key);
            return val == null ? Double.NaN : val.doubleValue();
        }
        
        // get����n�܂�Ajava.util.Map�^��Ԃ�getter
        // �P���v���p�e�B�ŃA�N�Z�X�\
        //
        // �߂�l��java.util.Map�̗v�f�ւ̃A�N�Z�X�́A
        // �}�b�v�v���p�e�B�ŃA�N�Z�X�\
        public Map getDoubleMap(){
            return doubleMap;
        }
        
        private SampleBean bean;
        
        // set����n�܂�ʏ��setter�A�N�Z�T
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public void setSampleBean(SampleBean bean){
            this.bean = bean;
        }
        
        // get����n�܂�ʏ��getter�A�N�Z�T
        // �P���v���p�e�B�ŃA�N�Z�X�\
        public SampleBean getSampleBean(){
            return bean;
        }
    }
}
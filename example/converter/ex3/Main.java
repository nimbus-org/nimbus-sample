
import java.util.List;
import java.util.ArrayList;

import jp.ossc.nimbus.util.converter.BeanJSONConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // Bean⇔JSONストリーム変換コンバータを生成
        BeanJSONConverter jsonConverter = new BeanJSONConverter();
        jsonConverter.setOutputNullProperty(false);
        
        // 文字列⇔ストリーム変換コンバータを生成
        StringStreamConverter streamConverter = new StringStreamConverter();
        
        // 入力となるBeanを生成
        SampleBean bean = new SampleBean();
        bean.setStringValue("test");
        bean.setIntValue(100);
        bean.setBooleanValue(true);
        bean.setFloatArray(new float[]{1.1f, 2.2f, 3.3f});
        List list = new ArrayList();
        list.add("hoge");
        list.add("fuga");
        list.add("piyo");
        bean.setList(list);
        Child child = new Child();
        child.setStringValue("test");
        bean.setChild(child);
        
        // BeanからJSONに変換する
        String json = (String)streamConverter.convertToObject(jsonConverter.convertToStream(bean));
        System.out.println(bean + " → " + json);
        
        // JSONからBeanに変換する
        bean = (SampleBean)jsonConverter.convertToObject(streamConverter.convertToStream(json), SampleBean.class);
        System.out.println(json + " → " + bean);
    }
    
    public static class SampleBean{
        private String stringValue;
        private int intValue;
        private boolean booleanValue;
        private float[] floatArray;
        private List list;
        private Child child;
        
        public String getStringValue(){
            return stringValue;
        }
        public void setStringValue(String str){
            stringValue = str;
        }
        
        public int getIntValue(){
            return intValue;
        }
        public void setIntValue(int val){
            intValue = val;
        }
        
        public boolean isBooleanValue(){
            return booleanValue;
        }
        public void setBooleanValue(boolean val){
            booleanValue = val;
        }
        
        public float[] getFloatArray(){
            return floatArray;
        }
        public void setFloatArray(float[] vals){
            floatArray = vals;
        }
        
        public List getList(){
            return list;
        }
        public void setList(List vals){
            list = vals;
        }
        
        public Child getChild(){
            return child;
        }
        public void setChild(Child val){
            child = val;
        }
        
        public String toString(){
            StringBuffer buf = new StringBuffer(super.toString());
            buf.append('{');
            buf.append("stringValue=").append(stringValue);
            buf.append(", intValue=").append(intValue);
            buf.append(", booleanValue=").append(booleanValue);
            buf.append(", floatArray=");
            if(floatArray == null){
                buf.append("null");
            }else{
                buf.append('[');
                for(int i = 0; i < floatArray.length; i++){
                    buf.append(floatArray[i]);
                    if(i != floatArray.length - 1){
                        buf.append(',');
                    }
                }
                buf.append(']');
            }
            buf.append(", list=").append(list);
            buf.append(", child=").append(child);
            buf.append('}');
            return buf.toString();
        }
    }
    
    public static class Child extends SampleBean{
    }
}
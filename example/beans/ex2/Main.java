
import java.util.*;

import jp.ossc.nimbus.beans.*;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        SampleBean bean = new SampleBean();
        bean.setSampleBean(new SampleBean());
        Map map = new HashMap();
        List list = new ArrayList();
        
        ///// 単純プロパティへのアクセス /////
        System.out.println("//////// 単純プロパティへのアクセス ///////////");
        
        // "String"という名前のプロパティにアクセスする
        // Propertyオブジェクトを作成する
        Property stringProperty = PropertyFactory.createProperty("String");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#setString(\"hoge\")");
        stringProperty.setProperty(bean, "hoge");
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getString() : " + stringProperty.getProperty(bean));
        
        // "Length"という名前のプロパティにアクセスする
        // Propertyオブジェクトを作成する
        Property lengthProperty = PropertyFactory.createProperty("Length");
        
        // プロパティ値を取得する
        System.out.println("SampleBean#length() : " + lengthProperty.getProperty(bean));
        
        // "Append"という名前のプロパティにアクセスする
        // Propertyオブジェクトを作成する
        Property appendProperty = PropertyFactory.createProperty("Append");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#append(\"fuga\")");
        appendProperty.setProperty(bean, "fuga");
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getString() : " + stringProperty.getProperty(bean));
        
        // "Object"という名前のプロパティにアクセスする
        // Propertyオブジェクトを作成する
        Property objectProperty = PropertyFactory.createProperty("Object");
        
        // プロパティ値を設定する
        System.out.println("java.util.Map#put(\"Object\", new Integer(100))");
        objectProperty.setProperty(map, new Integer(100));
        
        // プロパティ値を取得する
        System.out.println("java.util.Map#get(\"Object\") : " + objectProperty.getProperty(map));
        
        
        
        ///// インデックスプロパティへのアクセス /////
        System.out.println();
        System.out.println("//////// インデックスプロパティのアクセス ///////////");
        
        // "LongValue"という名前のインデックスプロパティの3番目の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property longValueProperty = PropertyFactory.createProperty("LongValue[2]");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#setLongValue(2, 200L)");
        longValueProperty.setProperty(bean, new Long(200));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getLongValue(2) : " + longValueProperty.getProperty(bean));
        
        // "LongValues"という名前のインデックスプロパティの3番目の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property longValuesProperty = PropertyFactory.createProperty("LongValues[2]");
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getLongValues()[2] : " + longValuesProperty.getProperty(bean));
        
        // "LongValueList"という名前のインデックスプロパティの4番目の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property longValueListProperty = PropertyFactory.createProperty("LongValueList[3]");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#getLongValueList().set(3, 300L)");
        longValueListProperty.setProperty(bean, new Long(300));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getLongValueList().get(3) : " + longValueListProperty.getProperty(bean));
        
        // 名前なしのインデックスプロパティの3番目の要素にアクセスする
        // Propertyオブジェクトを作成する
        Property listProperty = PropertyFactory.createProperty("[2]");
        
        // プロパティ値を設定する
        System.out.println("java.util.List#set(2, new Long(100))");
        listProperty.setProperty(list, new Long(100));
        
        // プロパティ値を取得する
        System.out.println("java.util.List#get(2) : " + listProperty.getProperty(list));
        
        
        
        ///// マッププロパティへのアクセス /////
        System.out.println();
        System.out.println("//////// マッププロパティのアクセス ///////////");
        
        // "Double"という名前のマッププロパティの"a"の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property doubleProperty = PropertyFactory.createProperty("Double(a)");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#setDouble(\"a\", 1.5d)");
        doubleProperty.setProperty(bean, new Double(1.5));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getDouble(\"a\") : " + doubleProperty.getProperty(bean));
        
        // "DoubleMap"という名前のマッププロパティの"b"の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property doubleMapProperty = PropertyFactory.createProperty("DoubleMap(b)");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#getDoubleMap().put(\"b\", new Double(12.3d))");
        doubleMapProperty.setProperty(bean, new Double(12.3));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getDoubleMap().get(\"b\") : " + doubleMapProperty.getProperty(bean));
        
        // 名前なしのマッププロパティの"key"の要素にアクセスする
        // Propertyオブジェクトを作成する
        Property keyProperty = PropertyFactory.createProperty("(key)");
        
        // プロパティ値を設定する
        System.out.println("java.util.Map#put(\"key\", \"HOGE\")");
        keyProperty.setProperty(map, "HOGE");
        
        // プロパティ値を取得する
        System.out.println("java.util.Map#get(\"key\") : " + keyProperty.getProperty(map));
        
        
        
        ///// 連結プロパティへのアクセス /////
        System.out.println();
        System.out.println("//////// 連結プロパティのアクセス ///////////");
        
        // "SampleBean"という名前のプロパティの
        // "String"という名前のプロパティに
        // アクセスするPropertyオブジェクトを作成する
        Property nestProperty1 = PropertyFactory.createProperty("SampleBean.String");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#getSampleBean().setString(\"fuga\")");
        nestProperty1.setProperty(bean, "fuga");
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getSampleBean().getString() : " + nestProperty1.getProperty(bean));
        
        // "SampleBean"という名前のプロパティの
        // "LongValue"という名前のインデックスプロパティの1番目の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property nestProperty2 = PropertyFactory.createProperty("SampleBean.LongValue[0]");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#getSampleBean().setLongValue(0, 150L)");
        nestProperty2.setProperty(bean, new Long(150));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getSampleBean().getLongValue(0) : " + nestProperty2.getProperty(bean));
        
        // "SampleBean"という名前のプロパティの
        // "Double"という名前のマッププロパティの"A"の要素に
        // アクセスするPropertyオブジェクトを作成する
        Property nestProperty3 = PropertyFactory.createProperty("SampleBean.Double(A)");
        
        // プロパティ値を設定する
        System.out.println("SampleBean#getSampleBean().setDouble(\"A\", 456.78d)");
        nestProperty3.setProperty(bean, new Double(456.78));
        
        // プロパティ値を取得する
        System.out.println("SampleBean#getSampleBean().getDouble(\"A\") : " + nestProperty3.getProperty(bean));
    }
    
    public static class SampleBean{
        
        private String stringValue;
        
        // setから始まる通常のsetterアクセサ
        // 単純プロパティでアクセス可能
        public void setString(String val){
            stringValue = val;
        }
        
        // getから始まる通常のgetterアクセサ
        // 単純プロパティでアクセス可能
        public String getString(){
            return stringValue;
        }
        
        // getから始まらないgetter
        // 単純プロパティでアクセス可能
        public int length(){
            return stringValue == null ? 0 : stringValue.length();
        }
        
        // setから始まらないsetter
        // 単純プロパティでアクセス可能
        public void append(String val){
            if(stringValue == null){
                stringValue = val;
            }else{
                stringValue += val;
            }
        }
        
        private List longValues = new ArrayList();
        
        // setから始まり、第1引数がint型、第2引数が任意の型となるsetter
        // インデックスプロパティでアクセス可能
        public void setLongValue(int index, long val){
            for(int i = longValues.size(); i <= index; i++){
                longValues.add(null);
            }
            longValues.set(index, new Long(val));
        }
        
        // getから始まり、引数がint型となるgetter
        // インデックスプロパティでアクセス可能
        public long getLongValue(int index){
            if(longValues.size() <= index){
                return -1L;
            }
            final Long val = (Long)longValues.get(index);
            return val == null ? -1L : val.longValue();
        }
        
        // getから始まり、配列型を返すgetter
        // 単純プロパティでアクセス可能
        //
        // 戻り値の配列要素へのアクセスは、
        // インデックスプロパティでアクセス可能
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
        
        // getから始まり、java.util.List型を返すgetter
        // 単純プロパティでアクセス可能
        //
        // 戻り値のjava.util.Listの要素へのアクセスは、
        // インデックスプロパティでアクセス可能
        public List getLongValueList(){
            return longValues;
        }
        
        private Map doubleMap = new HashMap();
        
        // setから始まり、第1引数がString型、第2引数が任意の型となるsetter
        // マッププロパティでアクセス可能
        public void setDouble(String key, double val){
            doubleMap.put(key, new Double(val));
        }
        
        // getから始まり、引数がString型となるgetter
        // マッププロパティでアクセス可能
        public double getDouble(String key){
            final Double val = (Double)doubleMap.get(key);
            return val == null ? Double.NaN : val.doubleValue();
        }
        
        // getから始まり、java.util.Map型を返すgetter
        // 単純プロパティでアクセス可能
        //
        // 戻り値のjava.util.Mapの要素へのアクセスは、
        // マッププロパティでアクセス可能
        public Map getDoubleMap(){
            return doubleMap;
        }
        
        private SampleBean bean;
        
        // setから始まる通常のsetterアクセサ
        // 単純プロパティでアクセス可能
        public void setSampleBean(SampleBean bean){
            this.bean = bean;
        }
        
        // getから始まる通常のgetterアクセサ
        // 単純プロパティでアクセス可能
        public SampleBean getSampleBean(){
            return bean;
        }
    }
}
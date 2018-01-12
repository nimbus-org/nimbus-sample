
import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.beans.dataset.Header;
import jp.ossc.nimbus.beans.dataset.Record;
import jp.ossc.nimbus.util.converter.DataSetJSONConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // DataSet⇔JSONストリーム変換コンバータを生成
        DataSetJSONConverter jsonConverter = new DataSetJSONConverter();
        jsonConverter.setOutputNullProperty(false);
        
        // 文字列⇔ストリーム変換コンバータを生成
        StringStreamConverter streamConverter = new StringStreamConverter();
        
        // 入力となるDataSetを生成
        DataSet ds = new DataSet("SampleDataSet");
        ds.setHeaderSchema(
            "SampleHeader", 
            ":prop1,java.lang.String\n"
                + ":prop2,int\n"
                + ":prop3,boolean\n"
                + ":prop4,float[]\n"
                + ":prop5,java.util.Date,jp.ossc.nimbus.util.converter.DateFormatConverter{ConvertType=2;Format=yyyyMMdd},jp.ossc.nimbus.util.converter.DateFormatConverter{ConvertType=1;Format=yyyyMMdd}\n"
                + "RECORD:prop6,SampleNestedRecord"
        );
        ds.setNestedRecordSchema(
            "SampleNestedRecord",
            ":prop1,java.lang.String\n"
                + ":prop2,int"
        );
        
        Header header = ds.getHeader("SampleHeader");
        header.setProperty("prop1", "test");
        header.setProperty("prop2", 100);
        header.setProperty("prop3", true);
        header.setProperty("prop4", new float[]{1.1f, 2.2f, 3.3f});
        header.setProperty("prop5", new java.util.Date());
        Record nestedRecord = ds.createNestedRecord("SampleNestedRecord");
        nestedRecord.setProperty("prop2", 100);
        header.setProperty("prop6", nestedRecord);
        
        // DataSetからJSONに変換する
        String json = (String)streamConverter.convertToObject(jsonConverter.convertToStream(ds));
        System.out.println(toString(ds) + " → " + json);
        
        // JSONからDataSetに変換する
        ds = (DataSet)jsonConverter.convertToObject(streamConverter.convertToStream(json));
        System.out.println(json + " → " + toString(ds));
    }
    
    private static final String toString(DataSet ds){
        StringBuffer buf = new StringBuffer(ds.toString());
        buf.deleteCharAt(buf.length() - 1);
        buf.append(",headers=").append(ds.getHeaderMap());
        buf.append(",lists=").append(ds.getRecordListMap());
        buf.append('}');
        return buf.toString();
    }
}
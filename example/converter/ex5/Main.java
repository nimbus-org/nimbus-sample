
import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.beans.dataset.Header;
import jp.ossc.nimbus.beans.dataset.Record;
import jp.ossc.nimbus.util.converter.DataSetXMLConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * �T���v���T���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // DataSet��XML�X�g���[���ϊ��R���o�[�^�𐶐�
        DataSetXMLConverter xmlConverter = new DataSetXMLConverter();
        
        // ������̃X�g���[���ϊ��R���o�[�^�𐶐�
        StringStreamConverter streamConverter = new StringStreamConverter();
        
        // ���͂ƂȂ�DataSet�𐶐�
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
        
        // DataSet����XML�ɕϊ�����
        String xml = (String)streamConverter.convertToObject(xmlConverter.convertToStream(ds));
        System.out.println(toString(ds) + " �� " + xml);
        
        // XML����DataSet�ɕϊ�����
        ds = (DataSet)xmlConverter.convertToObject(streamConverter.convertToStream(xml));
        System.out.println(xml + " �� " + toString(ds));
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
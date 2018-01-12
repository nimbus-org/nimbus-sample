
import java.util.Iterator;
import java.io.FileInputStream;

import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.beans.dataset.RecordList;
import jp.ossc.nimbus.util.converter.DataSetXpathConverter;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // XMLストリーム→DataSet変換コンバータを生成
        DataSetXpathConverter xpathConverter = new DataSetXpathConverter();
        
        // XMLをXPATHで紐付けたDataSetを定義する
        DataSet ds = new DataSet("Project");
        ds.setHeaderSchema(
            "Summary", 
            "XPATH:name,java.lang.String,,,,/project/name/text()\n"
             + "XPATH:url,java.lang.String,,,,/project/url/text()"
        );
        ds.setRecordListSchema(
            "Functions", 
            "XPATH:name,java.lang.String,,,,/project/functions/function/name/text()\n"
             + "XPATH:package,java.lang.String,,,,/project/functions/function/package/text()\n"
             + "XPATH:description,java.lang.String,,,,/project/functions/function/description/text()"
        );
        
        // XMLからDataSetに変換する
        ds = (DataSet)xpathConverter.convertToObject(new FileInputStream("sample.xml"), ds);
        System.out.println(toString(ds));
    }
    
    private static final String toString(DataSet ds){
        StringBuffer buf = new StringBuffer(ds.toString());
        buf.deleteCharAt(buf.length() - 1);
        buf.append(",headers=").append(ds.getHeaderMap());
        buf.append(",lists={");
        Iterator lists = ds.getRecordListMap().values().iterator();
        while(lists.hasNext()){
            RecordList list = (RecordList)lists.next();
            buf.append(list.getName()).append("=");
            buf.append("[");
            for(int i = 0, imax = list.size(); i < imax; i++){
                buf.append(list.get(i));
                if(i != imax - 1){
                    buf.append(", ");
                }
            }
            buf.append("]");
            if(lists.hasNext()){
                buf.append(", ");
            }
        }
        buf.append("}}");
        return buf.toString();
    }
}
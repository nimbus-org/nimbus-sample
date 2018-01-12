
import java.util.Iterator;
import java.io.FileInputStream;

import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.beans.dataset.RecordList;
import jp.ossc.nimbus.util.converter.DataSetHtmlConverter;

/**
 * �T���v���W���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // HTML�X�g���[����DataSet�ϊ��R���o�[�^�𐶐�
        DataSetHtmlConverter htmlConverter = new DataSetHtmlConverter();
        htmlConverter.setCharacterEncodingToObject("MS932");
        
        // HTML��XPATH�ŕR�t����DataSet���`����
        DataSet ds = new DataSet("Project");
        ds.setHeaderSchema(
            "Summary", 
            "XPATH:name,java.lang.String,,,,/HTML/BODY/H1/text()\n"
             + "XPATH:url,java.lang.String,,,,/HTML/BODY/FOOTER/A/@href"
        );
        ds.setRecordListSchema(
            "Functions", 
            "XPATH:name,java.lang.String,,,,/HTML/BODY/TABLE/TBODY/TR/TD[1]/text()\n"
             + "XPATH:package,java.lang.String,,,,/HTML/BODY/TABLE/TBODY/TR/TD[2]/text()\n"
             + "XPATH:description,java.lang.String,,,,/HTML/BODY/TABLE/TBODY/TR/TD[3]/text()"
        );
        
        // HTML����DataSet�ɕϊ�����
        ds = (DataSet)htmlConverter.convertToObject(new FileInputStream("sample.html"), ds);
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
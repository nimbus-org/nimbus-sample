
import jp.ossc.nimbus.beans.dataset.Record;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.math.BigDecimal;

import jp.ossc.nimbus.io.*;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        final PrintWriter writer = new PrintWriter(
            new OutputStreamWriter(new FileOutputStream("sample.txt"))
        );
        
        Record record = new Record(
            ":element1,java.lang.String,,jp.ossc.nimbus.util.converter.PaddingStringConverter{PaddingLength=20}\n"
                + ":element2,int,,jp.ossc.nimbus.util.converter.DecimalFormatConverter{Format='0'000000000\\;-000000000}\n"
                + ":element3,double,,jp.ossc.nimbus.util.converter.DecimalFormatConverter{Format='0'0000000000000000.00\\;-0000000000000000.00}\n"
        );
        
        // FLV要素単位での書き込み
        record.setProperty("element1", "user1");
        record.setProperty("element2", 100);
        record.setProperty("element3", 100.123d);
        writer.print(record.getFormatProperty("element1"));
        writer.print(record.getFormatProperty("element2"));
        writer.print(record.getFormatProperty("element3"));
        writer.println();
        
        record.setProperty("element1", "user2");
        record.setProperty("element2", -200);
        record.setProperty("element3", -200.456d);
        writer.print(record.getFormatProperty("element1"));
        writer.print(record.getFormatProperty("element2"));
        writer.print(record.getFormatProperty("element3"));
        writer.println();
        
        writer.close();
        
        final FLVRecordReader reader = new FLVRecordReader(
            new InputStreamReader(new FileInputStream("sample.txt")),
            new int[]{20, 10, 20}
        );
        
        record = new Record(
            ":element1,java.lang.String,jp.ossc.nimbus.util.converter.PaddingStringConverter{ConvertType=2;PaddingLength=20}\n"
                + ":element2,int,,jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=2;Format='0'000000000\\;-000000000}+jp.ossc.nimbus.util.converter.NumberCastConverter{ReturnType=int}\n"
                + ":element3,double,,jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=2;Format='0'0000000000000000.00\\;-0000000000000000.00}\n"
        );
        
        
        // 行単位での読み込み
        while((record = reader.readRecord(record)) != null){
            System.out.println(record);
        }
        
        reader.close();
    }
}
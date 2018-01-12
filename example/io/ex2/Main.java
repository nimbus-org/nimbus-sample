
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.math.BigDecimal;

import jp.ossc.nimbus.io.*;
import jp.ossc.nimbus.beans.dataset.*;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        final CSVRecordWriter writer = new CSVRecordWriter(
            new OutputStreamWriter(new FileOutputStream("sample.csv"))
        );
        
        Record record = new Record(":element1,java.lang.String\n:element2,int\n:element3,double");
        
        // ���R�[�h�P�ʂł̏�������
        record.setProperty("element1", "hoge1");
        record.setProperty("element2", 1);
        record.setProperty("element3", 10.0d);
        writer.writeRecord(record);
        
        record.setProperty("element1", "hoge2");
        record.setProperty("element2", 2);
        record.setProperty("element3", 20.0d);
        writer.writeRecord(record);
        
        writer.close();
        
        final CSVRecordReader reader = new CSVRecordReader(
            new InputStreamReader(new FileInputStream("sample.csv"))
        );
        
        // �s�P�ʂł̓ǂݍ���
        while((record = reader.readRecord(record)) != null){
            System.out.println(record);
        }
        
        reader.close();
    }
}
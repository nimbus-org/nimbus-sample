
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.math.BigDecimal;

import jp.ossc.nimbus.io.*;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        final CSVWriter writer = new CSVWriter(
            new OutputStreamWriter(new FileOutputStream("sample.csv"))
        );
        
        // CSV�v�f�P�ʂł̏�������
        writer.writeElement("element1");
        writer.writeElement("element2");
        writer.writeElement("element3");
        writer.newLine();
        
        // �e�^���̏�������
        writer.writeElement((byte)1);
        writer.writeElement((short)2);
        writer.writeElement('3');
        writer.writeElement(4);
        writer.writeElement(5l);
        writer.writeElement(6.0f);
        writer.writeElement(7.0);
        writer.writeElement(true);
        writer.writeElement(new BigDecimal("9.0"));
        writer.newLine();
        
        // 1�s�P�ʂł̏�������
        writer.writeCSV(new String[]{"element1", "element2", "element3"});
        writer.writeCSV(new String[]{"element1", "element2", "element3"});
        
        writer.close();
        
        final CSVReader reader = new CSVReader(
            new InputStreamReader(new FileInputStream("sample.csv"))
        );

        // �s�P�ʂł̓ǂݍ���
        final String[] csv = reader.readCSVLine();
        for(int i = 0; i < csv.length; i++){
            System.out.print(csv[i]);
            if(i != csv.length - 1){
                System.out.print(',');
            }
        }
        System.out.println();
        
        // Iterator API�ł̓ǂݍ���
        final CSVReader.CSVIterator csvIterator = reader.iterator();
        
        CSVReader.CSVElements elements = csvIterator.nextElements();
        System.out.print(elements.getByte(0));
        System.out.print(',');
        System.out.print(elements.getShort(1));
        System.out.print(',');
        System.out.print(elements.getChar(2));
        System.out.print(',');
        System.out.print(elements.getInt(3));
        System.out.print(',');
        System.out.print(elements.getLong(4));
        System.out.print(',');
        System.out.print(elements.getFloat(5));
        System.out.print(',');
        System.out.print(elements.getDouble(6));
        System.out.print(',');
        System.out.print(elements.getBoolean(7));
        System.out.print(',');
        System.out.print(elements.getBigDecimal(8));
        System.out.println();
        
        while(csvIterator.hasNext()){
            final Iterator elementIterator
                 = csvIterator.nextElements().iterator();
            while(elementIterator.hasNext()){
                System.out.print(elementIterator.next());
                if(elementIterator.hasNext()){
                    System.out.print(',');
                }
            }
            if(csvIterator.hasNext()){
                System.out.println();
            }
        }
        
        reader.close();
    }
}
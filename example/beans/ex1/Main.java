
import java.beans.PropertyEditor;
import java.util.Date;
import java.util.Properties;
import java.io.StringWriter;
import java.io.PrintWriter;

import jp.ossc.nimbus.beans.*;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        /////// boolean配列型のPropertyEditor //////
        System.out.println("/////// boolean配列型のPropertyEditor //////");
        
        // boolean配列を編集するPropertyEditorを取得する
        PropertyEditor editor
             = NimbusPropertyEditorManager.findEditor(boolean[].class);
        
        // boolean配列の文字列表現をPropertyEditorに設定する
        String text = "true,false,true";
        System.out.println("boolean text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditorで、boolean配列に変換する
        final boolean[] booleans = (boolean[])editor.getValue();
        System.out.println("↓Stringからboolean[]に変換");
        for(int i = 0; i < booleans.length; i++){
            System.out.println("boolean[" + i + "]=" + booleans[i]);
        }
        
        // boolean配列をPropertyEditorに設定する
        editor.setValue(booleans);
        
        // PropertyEditorで、boolean配列の文字列表現に変換する
        System.out.println("↓boolean[]からStringに変換");
        System.out.println("boolean text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// byte配列型のPropertyEditor //////
        System.out.println();
        System.out.println("/////// byte配列型のPropertyEditor //////");
        
        // byte配列を編集するPropertyEditorを取得する
        editor = NimbusPropertyEditorManager.findEditor(byte[].class);
        
        // byte配列の文字列表現をPropertyEditorに設定する
        text = "1,0b10,0o010,0x10";
        System.out.println("byte text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditorで、byte配列に変換する
        final byte[] bytes = (byte[])editor.getValue();
        System.out.println("↓Stringからbyte[]に変換");
        for(int i = 0; i < bytes.length; i++){
            System.out.println("byte[" + i + "]=" + bytes[i]);
        }
        
        // byte配列をPropertyEditorに設定する
        editor.setValue(bytes);
        
        // PropertyEditorで、byte配列の文字列表現に変換する
        System.out.println("↓byte[]からStringに変換");
        System.out.println("byte text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// Class型のPropertyEditor //////
        System.out.println();
        System.out.println("/////// Class型のPropertyEditor //////");
        
        // Class型を編集するPropertyEditorを取得する
        editor = NimbusPropertyEditorManager.findEditor(Class.class);
        
        // Class型の文字列表現をPropertyEditorに設定する
        text = "java.lang.String";
        System.out.println("Class text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditorで、Class型に変換する
        final Class clazz = (Class)editor.getValue();
        System.out.println("↓StringからClassに変換");
        System.out.println("Class=" + clazz);
        
        // Class型をPropertyEditorに設定する
        editor.setValue(clazz);
        
        // PropertyEditorで、Class型の文字列表現に変換する
        System.out.println("↓Class型からStringに変換");
        System.out.println("Class text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// java.util.Date型のPropertyEditor //////
        System.out.println();
        System.out.println("/////// java.util.Date型のPropertyEditor //////");
        
        // java.util.Date型を編集するPropertyEditorを取得する
        editor = NimbusPropertyEditorManager.findEditor(Date.class);
        
        // java.util.Date型の文字列表現をPropertyEditorに設定する
        text = "2007/11/08 12:34:56";
        System.out.println("Date text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditorで、java.util.Date型に変換する
        final Date date = (Date)editor.getValue();
        System.out.println("↓Stringからjava.util.Dateに変換");
        System.out.println("Date=" + date);
        
        // Class型をPropertyEditorに設定する
        editor.setValue(date);
        
        // PropertyEditorで、java.util.Date型の文字列表現に変換する
        System.out.println("↓java.util.Date型からStringに変換");
        System.out.println("Date text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// java.util.Properties型のPropertyEditor //////
        System.out.println();
        System.out.println("/////// java.util.Properties型のPropertyEditor //////");
        
        // java.util.Properties型を編集するPropertyEditorを取得する
        editor = NimbusPropertyEditorManager.findEditor(Properties.class);
        
        // java.util.Properties型の文字列表現をPropertyEditorに設定する
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        pw.println("A=1");
        pw.println("                 B=2");
        pw.print("                 C=あいうえお");
        text = sw.toString();
        System.out.println("Properties text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditorで、java.util.Properties型に変換する
        final Properties prop = (Properties)editor.getValue();
        System.out.println("↓Stringからjava.util.Propertiesに変換");
        System.out.println("Properties=" + prop);
        
        // Class型をPropertyEditorに設定する
        editor.setValue(prop);
        
        // PropertyEditorで、java.util.Properties型の文字列表現に変換する
        System.out.println("↓java.util.Properties型からStringに変換");
        System.out.println("Properties text=\"" + editor.getAsText() + "\"");
    }
}
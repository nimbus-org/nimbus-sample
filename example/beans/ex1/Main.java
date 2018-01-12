
import java.beans.PropertyEditor;
import java.util.Date;
import java.util.Properties;
import java.io.StringWriter;
import java.io.PrintWriter;

import jp.ossc.nimbus.beans.*;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        /////// boolean�z��^��PropertyEditor //////
        System.out.println("/////// boolean�z��^��PropertyEditor //////");
        
        // boolean�z���ҏW����PropertyEditor���擾����
        PropertyEditor editor
             = NimbusPropertyEditorManager.findEditor(boolean[].class);
        
        // boolean�z��̕�����\����PropertyEditor�ɐݒ肷��
        String text = "true,false,true";
        System.out.println("boolean text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditor�ŁAboolean�z��ɕϊ�����
        final boolean[] booleans = (boolean[])editor.getValue();
        System.out.println("��String����boolean[]�ɕϊ�");
        for(int i = 0; i < booleans.length; i++){
            System.out.println("boolean[" + i + "]=" + booleans[i]);
        }
        
        // boolean�z���PropertyEditor�ɐݒ肷��
        editor.setValue(booleans);
        
        // PropertyEditor�ŁAboolean�z��̕�����\���ɕϊ�����
        System.out.println("��boolean[]����String�ɕϊ�");
        System.out.println("boolean text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// byte�z��^��PropertyEditor //////
        System.out.println();
        System.out.println("/////// byte�z��^��PropertyEditor //////");
        
        // byte�z���ҏW����PropertyEditor���擾����
        editor = NimbusPropertyEditorManager.findEditor(byte[].class);
        
        // byte�z��̕�����\����PropertyEditor�ɐݒ肷��
        text = "1,0b10,0o010,0x10";
        System.out.println("byte text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditor�ŁAbyte�z��ɕϊ�����
        final byte[] bytes = (byte[])editor.getValue();
        System.out.println("��String����byte[]�ɕϊ�");
        for(int i = 0; i < bytes.length; i++){
            System.out.println("byte[" + i + "]=" + bytes[i]);
        }
        
        // byte�z���PropertyEditor�ɐݒ肷��
        editor.setValue(bytes);
        
        // PropertyEditor�ŁAbyte�z��̕�����\���ɕϊ�����
        System.out.println("��byte[]����String�ɕϊ�");
        System.out.println("byte text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// Class�^��PropertyEditor //////
        System.out.println();
        System.out.println("/////// Class�^��PropertyEditor //////");
        
        // Class�^��ҏW����PropertyEditor���擾����
        editor = NimbusPropertyEditorManager.findEditor(Class.class);
        
        // Class�^�̕�����\����PropertyEditor�ɐݒ肷��
        text = "java.lang.String";
        System.out.println("Class text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditor�ŁAClass�^�ɕϊ�����
        final Class clazz = (Class)editor.getValue();
        System.out.println("��String����Class�ɕϊ�");
        System.out.println("Class=" + clazz);
        
        // Class�^��PropertyEditor�ɐݒ肷��
        editor.setValue(clazz);
        
        // PropertyEditor�ŁAClass�^�̕�����\���ɕϊ�����
        System.out.println("��Class�^����String�ɕϊ�");
        System.out.println("Class text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// java.util.Date�^��PropertyEditor //////
        System.out.println();
        System.out.println("/////// java.util.Date�^��PropertyEditor //////");
        
        // java.util.Date�^��ҏW����PropertyEditor���擾����
        editor = NimbusPropertyEditorManager.findEditor(Date.class);
        
        // java.util.Date�^�̕�����\����PropertyEditor�ɐݒ肷��
        text = "2007/11/08 12:34:56";
        System.out.println("Date text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditor�ŁAjava.util.Date�^�ɕϊ�����
        final Date date = (Date)editor.getValue();
        System.out.println("��String����java.util.Date�ɕϊ�");
        System.out.println("Date=" + date);
        
        // Class�^��PropertyEditor�ɐݒ肷��
        editor.setValue(date);
        
        // PropertyEditor�ŁAjava.util.Date�^�̕�����\���ɕϊ�����
        System.out.println("��java.util.Date�^����String�ɕϊ�");
        System.out.println("Date text=\"" + editor.getAsText() + "\"");
        
        
        
        /////// java.util.Properties�^��PropertyEditor //////
        System.out.println();
        System.out.println("/////// java.util.Properties�^��PropertyEditor //////");
        
        // java.util.Properties�^��ҏW����PropertyEditor���擾����
        editor = NimbusPropertyEditorManager.findEditor(Properties.class);
        
        // java.util.Properties�^�̕�����\����PropertyEditor�ɐݒ肷��
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        pw.println("A=1");
        pw.println("                 B=2");
        pw.print("                 C=����������");
        text = sw.toString();
        System.out.println("Properties text=\"" + text + "\"");
        editor.setAsText(text);
        
        // PropertyEditor�ŁAjava.util.Properties�^�ɕϊ�����
        final Properties prop = (Properties)editor.getValue();
        System.out.println("��String����java.util.Properties�ɕϊ�");
        System.out.println("Properties=" + prop);
        
        // Class�^��PropertyEditor�ɐݒ肷��
        editor.setValue(prop);
        
        // PropertyEditor�ŁAjava.util.Properties�^�̕�����\���ɕϊ�����
        System.out.println("��java.util.Properties�^����String�ɕϊ�");
        System.out.println("Properties text=\"" + editor.getAsText() + "\"");
    }
}
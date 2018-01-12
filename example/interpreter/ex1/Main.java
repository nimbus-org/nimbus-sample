
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.StringWriter;
import java.io.PrintWriter;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.interpreter.Interpreter;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            Interpreter interpreter = (Interpreter)ServiceManagerFactory
                .getServiceObject("Interpreter");
            
            // �C���^�[�v���^�Ŏ��s����T���v���R�[�h��ǂݍ���
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            String line = null;
            while((line = br.readLine()) != null){
                pw.println(line);
            }
            fr.close();
            pw.flush();
            
            // �C���^�[�v���^�Ɏ��s�����āA���ʂ�W���o�͂ɏo�͂���
            System.out.println(interpreter.evaluate(sw.toString()));
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
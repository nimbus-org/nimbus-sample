
import java.io.*;
import java.net.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.util.converter.DataSetJSONConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�o�Ɛڑ�
        Socket socket = new Socket("localhost", 10000);
        
        // �v���𑗐M����o�̓X�g���[�����擾
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        
        // �A�N�V�������o��
        pw.println("Hello");
        
        // ���M����DataSet�𐶐�
        DataSet ds = new DataSet("HelloRequest");
        ds.setHeaderSchema(
            ":name,java.lang.String\n"
             + ":message,java.lang.String"
        );
        ds.getHeader().setProperty("name", "Hoge");
        ds.getHeader().setProperty("message", "Hello!!");
        
        // DataSet��JSON�ϊ����s��Converter�𐶐�
        DataSetJSONConverter dsConverter = new DataSetJSONConverter();
        dsConverter.setOutputSchema(false);
        StringStreamConverter strConverter = new StringStreamConverter();
        
        // DataSet��JSON�ɕϊ����ďo��
        pw.print((String)strConverter.convertToObject(dsConverter.convertToStream(ds)));
        pw.flush();
        
        // ��������M������̓X�g���[�����擾
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        // �����X�e�[�^�X��ǂݍ���
        int status = dis.readInt();
        System.out.println("response staus=" + status);
        
        // �����f�[�^����ǂݍ���
        int length = dis.readInt();
        System.out.println("response length=" + length);
        
        // ���퉞���̏ꍇ
        if(status == 200){
            // �����f�[�^��ǂݍ���
            byte[] data = new byte[length];
            dis.read(data);
            
            // ��M����DataSet�𐶐�
            DataSet resDs = new DataSet("HelloResponse");
            resDs.setHeaderSchema(
                ":message,java.lang.String"
            );
            
            // �����f�[�^��JSON��DataSet�ɕϊ�����
            resDs = (DataSet)dsConverter.convertToObject(new ByteArrayInputStream(data), resDs);
            
            System.out.println(ds.getHeader().getProperty("message"));
        }
        // �ُ퉞���̏ꍇ
        else{
            System.out.println("Error occurred.");
        }
        
        // �T�[�o�Ɛؒf
        socket.close();
    }
    
}
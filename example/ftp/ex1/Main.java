
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.ftp.FTPClientFactory;
import jp.ossc.nimbus.service.ftp.FTPClient;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final FTPClientFactory factory = (FTPClientFactory)ServiceManagerFactory.getServiceObject("FTPClientFactory");
            
            // �N���C�A���g�𐶐�����
            final FTPClient client = factory.createFTPClient();
            try{
                // �e�L�X�g�t�@�C�������[�J���ɍ쐬����
                FileOutputStream fos = new FileOutputStream("put_test.txt");
                fos.write("test".getBytes());
                fos.close();
                
                // FTP�T�[�o��̃t�@�C���̈ꗗ���擾����
                System.out.println("�T�[�o�̃t�@�C���ꗗ");
                String[] fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
                
                // FTP�T�[�o�Ƀt�@�C����]������
                waitInput("�T�[�o�Ƀt�@�C����]�����܂�");
                client.put("put_test.txt", "test.txt");
                System.out.println("�T�[�o�Ƀt�@�C����]�����܂���");
                
                // FTP�T�[�o��̃t�@�C���̈ꗗ���擾����
                System.out.println("�T�[�o�̃t�@�C���ꗗ");
                fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
                
                // FTP�T�[�o����t�@�C�����擾����
                waitInput("�T�[�o����t�@�C�����擾���܂�");
                client.get("test.txt", "get_test.txt");
                System.out.println("�T�[�o����t�@�C�����擾���܂���");
                
                // FTP�T�[�o��̃t�@�C�����폜����
                waitInput("�T�[�o����t�@�C�����폜���܂�");
                client.delete("test.txt");
                System.out.println("�T�[�o����t�@�C�����폜���܂���");
                
                // FTP�T�[�o��̃t�@�C���̈ꗗ���擾����
                System.out.println("�T�[�o�̃t�@�C���ꗗ");
                fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
            }finally{
                // �N���C�A���g���I������
                client.close();
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static final void waitInput(String message) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println(message + " (y/n)");
            final String line = br.readLine();
            if("y".equalsIgnoreCase(line)){
                break;
            }else if("n".equalsIgnoreCase(line)){
                System.exit(0);
            }
        }while(true);
    }
}
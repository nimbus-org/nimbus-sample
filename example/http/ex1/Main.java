
import java.io.IOException;
import java.io.FileOutputStream;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.http.HttpClientFactory;
import jp.ossc.nimbus.service.http.HttpClient;
import jp.ossc.nimbus.service.http.HttpRequest;
import jp.ossc.nimbus.service.http.HttpResponse;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final HttpClientFactory factory = (HttpClientFactory)ServiceManagerFactory.getServiceObject("HttpClientFactory");
            
            // �N���C�A���g�𐶐�����
            final HttpClient client = factory.createHttpClient();
            
            // �v���W�F�N�g�g�b�v�y�[�W�ւ̃��N�G�X�g�𐶐�����
            final HttpRequest projectTopPageRequest
                 = factory.createRequest("ProjectTopPage");
            
            // ���N�G�X�g��HTTP���M���āA���X�|���X���擾����
            final HttpResponse projectTopPageResponse
                 = client.executeRequest(projectTopPageRequest);
            
            // ���X�|���X��HTTP�X�e�[�^�X���m�F����
            if(projectTopPageResponse.getStatusCode() == 200){
                System.out.println(
                    "Normal status from " + projectTopPageRequest.getURL()
                     + " : " + projectTopPageResponse.getStatusCode()
                );
                
                // ���X�|���X��HTML��������擾���āA�t�@�C���ɏo�͂���
                final String html = (String)projectTopPageResponse.getObject();
                printFile("ProjectTopPage.html", html);
            }else{
                System.out.println(
                    "Error status from " + projectTopPageRequest.getURL()
                     + " : " + projectTopPageResponse.getStatusCode()
                );
            }
            
            // �v���W�F�N�g�z�[���y�[�W�ւ̃��N�G�X�g�𐶐�����
            final HttpRequest projectHomePageRequest
                 = factory.createRequest("ProjectHomePage");
            
            // ���N�G�X�g��HTTP���M���āA���X�|���X���擾����
            final HttpResponse projectHomePageResponse
                 = client.executeRequest(projectHomePageRequest);
            
            // ���X�|���X��HTTP�X�e�[�^�X���m�F����
            if(projectHomePageResponse.getStatusCode() == 200){
                System.out.println(
                    "Normal status from " + projectHomePageRequest.getURL()
                     + " : " + projectHomePageResponse.getStatusCode()
                );
                
                // ���X�|���X��HTML��������擾���āA�t�@�C���ɏo�͂���
                final String html = (String)projectHomePageResponse.getObject();
                printFile("ProjectHomePage.html", html);
            }else{
                System.out.println(
                    "Error status from " + projectHomePageRequest.getURL()
                     + " : " + projectHomePageResponse.getStatusCode()
                );
            }
            
            // �N���C�A���g���I������
            client.close();
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static void printFile(String name, String html) throws IOException{
        final FileOutputStream fos = new FileOutputStream(name);
        final byte[] bytes = html.getBytes();
        fos.write(bytes, 0, bytes.length);
        fos.close();
    }
    
}
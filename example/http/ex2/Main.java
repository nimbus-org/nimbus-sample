
import jp.ossc.nimbus.core.*;
import jp.ossc.nimbus.beans.dataset.*;
import jp.ossc.nimbus.service.http.*;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-server.xml")
                && ServiceManagerFactory.loadManager("service-client.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final HttpClientFactory factory = (HttpClientFactory)ServiceManagerFactory.getServiceObject("HttpClientFactory");
            
            // �N���C�A���g�𐶐�����
            HttpClient client = factory.createHttpClient();
            
            // ���N�G�X�g�𐶐�
            HttpRequest request = factory.createRequest("login");
            
            // ���N�G�X�g�p�����[�^��ݒ�
            request.setParameter("name", "hoge");
            request.setParameter("password", "fuga");
            
            // ���N�G�X�g�𑗐M���āA���X�|���X���擾����
            HttpResponse response = client.executeRequest(request);
            
            // ���X�|���X��HTTP�X�e�[�^�X���`�F�b�N����
            if(response.getStatusCode() == 200){
                
                // ���X�|���X��XML��DataSet�Ƃ��Ď擾����
                DataSet responseDs = (DataSet)response.getObject();
                Header authInfo = responseDs.getHeader("AuthInfo");
                System.out.println(authInfo.toString());
            }else{
                System.out.println("error status : " + response.getStatusCode());
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.crypt.Crypt;

/**
 * �T���v���P���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            final Crypt crypt = (Crypt)ServiceManagerFactory
                .getServiceObject("Crypt");
            
            String str = "����ɂ���";
            System.out.println("�Í����O�̕����� : " + str);
            
            // �n�b�V������
            String hash = crypt.doHash(str);
            System.out.println("�n�b�V����̕����� : " + hash);
            
            // �Í�������
            String encode = crypt.doEncode(str);
            System.out.println("�Í�����̕����� : " + encode);
            
            // ����������
            String decode = crypt.doDecode(encode);
            System.out.println("��������̕����� : " + decode);
            
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
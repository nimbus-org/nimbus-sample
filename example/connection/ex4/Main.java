
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;

/**
 * �T���v���S���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            
            Connection con = null;
            Statement stmt = null;
            try{
                con = factory.getConnection();
                stmt = con.createStatement();
                System.out.println("����");
                ResultSet rs = stmt.executeQuery("select * from myuser");
                System.out.println("���O,�N��,����");
                while(rs.next()){
                    System.out.println(rs.getString("name")
                        + "," + rs.getString("age")
                        + "," + rs.getString("sex"));
                }
            }catch(ConnectionFactoryException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(SQLException e){
                e.printStackTrace();
                System.exit(-1);
            }finally{
                if(con != null){
                    try{
                        con.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
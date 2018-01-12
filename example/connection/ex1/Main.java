
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;

/**
 * �T���v���P���s�N���X�B
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
                System.out.println("�e�[�u���쐬");
                stmt.executeQuery("create table myuser(name varchar(100), age integer, sex char(1))");
                System.out.println("���R�[�h�}��");
                stmt.executeQuery("insert into myuser(name, age, sex) values('hoge', '20', '0')");
                stmt.executeQuery("insert into myuser(name, age, sex) values('fuga', '25', '1')");
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
                if(stmt != null){
                    try{
                        System.out.println("�e�[�u���폜");
                        stmt.executeQuery("drop table myuser");
                    }catch(SQLException e){
                    }
                    try{
                        stmt.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
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
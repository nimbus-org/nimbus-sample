
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.TransactionSynchronizerService;

/**
 * �T���v���V���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �f�[�^�x�[�X1��ConnectionFactory�T�[�r�X���擾����
            ConnectionFactory factory1 = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory1");
            
            // �f�[�^�x�[�X1�ɁA�g�����U�N�V�����L�^�p�̃e�[�u�����쐬����
            Connection con = null;
            Statement stmt = null;
            try{
                con = factory1.getConnection();
                stmt = con.createStatement();
                stmt.executeQuery("create table TRANSACTION_LOG(SEQNO varchar(10), QUERY longvarchar, QUERY_TYPE smallint, UPDATE_TIME timestamp, UPDATE_USER varchar(10))");
                stmt.executeQuery("create table TRANSACTION_PARAMS_LOG(SEQNO varchar(10), PARAM_INDEX smallint, PARAM_NAME varchar(128), PARAM_TYPE smallint, PARAM_LENGTH smallint, PARAM binary(2000))");
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
            
            // �g�����U�N�V�����L�^�p��ConnectionFactory�T�[�r�X���擾����
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("TransactionLoggingConnectionFactory");
            
            // �f�[�^�x�[�X1�ɁA�g�����U�N�V�����L�^�p��Connection���g���ăg�����U�N�V�����𔭍s����
            try{
                con = factory.getConnection();
                stmt = con.createStatement();
                
                System.out.println("*************** �f�[�^�x�[�X1 ***************");
                System.out.println("�e�[�u���쐬");
                stmt.executeQuery("create table myuser(name varchar(100), age integer, sex char(1))");
                
                System.out.println("���R�[�h�}��");
                java.sql.PreparedStatement ps = con.prepareStatement("insert into myuser(name, age, sex) values(?,?,?)");
                ps.setString(1, "hoge");
                ps.setInt(2, 20);
                ps.setString(3, "0");
                ps.executeUpdate();
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
                if(con != null){
                    try{
                        con.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
            
            // �g�����U�N�V���������T�[�r�X���擾����
            TransactionSynchronizerService transactionSynchronizer = (TransactionSynchronizerService)ServiceManagerFactory
                .getServiceObject("TransactionSynchronizer");
            
            // �g�����U�N�V�����𓯊�����
            System.out.println("�����J�n");
            try{
                int transactionCount = transactionSynchronizer.synchronize();
                System.out.println("�����I�� ���������g�����U�N�V�������F" + transactionCount);
            }catch(Exception e){
                System.out.println("�������s!!");
                e.printStackTrace();
                System.exit(-1);
            }
            
            // �f�[�^�x�[�X2��ConnectionFactory�T�[�r�X���擾����
            ConnectionFactory factory2 = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory2");
            try{
                con = factory2.getConnection();
                stmt = con.createStatement();
                
                System.out.println("*************** �f�[�^�x�[�X2 ***************");
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
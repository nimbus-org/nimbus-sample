
import java.util.*;
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.util.validator.*;

/**
 * �T���v���Q���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // �T�[�r�X���擾����
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            Validator validator = (Validator)ServiceManagerFactory
                .getServiceObject("Validator");
            
            Connection con = null;
            Statement stmt = null;
            try{
                // �O����
                con = factory.getConnection();
                stmt = con.createStatement();
                stmt.executeQuery("create table EMPLOYEE_MST(PART_CD char(3), SECTION_CD char(2), NO char(5), NAME varchar(100))");
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('001', '01', '00001', 'hoge1')");
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('001', '01', '00002', 'hoge2')");
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('001', '02', '00001', 'hoge3')");
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('002', '01', '00001', 'hoge4')");
                
                final Map employee = new HashMap();
                
                employee.put("PartCode", "001");
                employee.put("SectionCode", "01");
                employee.put("No", "00002");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                employee.put("PartCode", "002");
                employee.put("SectionCode", "01");
                employee.put("No", "00001");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                employee.put("PartCode", "999");
                employee.put("SectionCode", "01");
                employee.put("No", "00001");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('999', '01', '00001', 'hogeX')");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
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
                        stmt.executeQuery("drop table EMPLOYEE_MST");
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
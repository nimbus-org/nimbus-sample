
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.codemaster.CodeMasterFinder;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.util.validator.*;

import sample.*;

/**
 * �T���v���R���s�N���X�B
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
            CodeMasterFinder finder = (CodeMasterFinder)ServiceManagerFactory
                .getServiceObject("CodeMasterFinder");
            
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
                System.out.println("EMPLOYEE_MST�e�[�u�����쐬");
                
                // �R�[�h�}�X�^�̓ǂݍ���
                finder.updateCodeMaster("EMPLOYEE_MST");
                Thread.sleep(500);
                System.out.println("�R�[�h�}�X�^ EMPLOYEE_MST���X�V");
                
                final Employee employee = new Employee();
                
                employee.setPartCode("001");
                employee.setSectionCode("01");
                employee.setNo("00002");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                employee.setPartCode("002");
                employee.setSectionCode("01");
                employee.setNo("00001");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                employee.setPartCode("999");
                employee.setSectionCode("01");
                employee.setNo("00001");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('999', '01', '00001', 'hogeX')");
                System.out.println("EMPLOYEE_MST�e�[�u���Ƀ��R�[�h�ǉ�");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                // �R�[�h�}�X�^�̓ǂݍ���
                finder.updateCodeMaster("EMPLOYEE_MST");
                Thread.sleep(500);
                System.out.println("�R�[�h�}�X�^ EMPLOYEE_MST���X�V");
                System.out.println(" ���ؑΏ�=" + employee);
                System.out.println(" ���،���=" + validator.validate(employee));
                System.out.println();
                
                Family family = new Family("fuga");
                System.out.println(" ���ؑΏ�=" + family);
                System.out.println(" ���،���=" + validator.validate(family));
                System.out.println();
                
                employee.addFamily(family);
                System.out.println(" ���ؑΏ�=" + family);
                System.out.println(" ���،���=" + validator.validate(family));
                System.out.println();
                
            }catch(ConnectionFactoryException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(SQLException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(Exception e){
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
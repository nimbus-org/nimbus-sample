
import java.util.*;
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.util.validator.*;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            Validator validator = (Validator)ServiceManagerFactory
                .getServiceObject("Validator");
            
            Connection con = null;
            Statement stmt = null;
            try{
                // 前準備
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
                System.out.println(" 検証対象=" + employee);
                System.out.println(" 検証結果=" + validator.validate(employee));
                System.out.println();
                
                employee.put("PartCode", "002");
                employee.put("SectionCode", "01");
                employee.put("No", "00001");
                System.out.println(" 検証対象=" + employee);
                System.out.println(" 検証結果=" + validator.validate(employee));
                System.out.println();
                
                employee.put("PartCode", "999");
                employee.put("SectionCode", "01");
                employee.put("No", "00001");
                System.out.println(" 検証対象=" + employee);
                System.out.println(" 検証結果=" + validator.validate(employee));
                System.out.println();
                
                stmt.executeQuery("insert into EMPLOYEE_MST(PART_CD, SECTION_CD, NO, NAME) values('999', '01', '00001', 'hogeX')");
                System.out.println(" 検証対象=" + employee);
                System.out.println(" 検証結果=" + validator.validate(employee));
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
                        System.out.println("テーブル削除");
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
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
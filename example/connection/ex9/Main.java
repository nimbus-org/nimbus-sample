
import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.TransactionSynchronizerService;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // データベース1のConnectionFactoryサービスを取得する
            ConnectionFactory factory1 = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory1");
            
            // データベース1に、トランザクション記録用のテーブルを作成する
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
            
            // トランザクション記録用のConnectionFactoryサービスを取得する
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("TransactionLoggingConnectionFactory");
            
            // データベース1に、トランザクション記録用のConnectionを使ってトランザクションを発行する
            try{
                con = factory.getConnection();
                stmt = con.createStatement();
                
                System.out.println("*************** データベース1 ***************");
                System.out.println("テーブル作成");
                stmt.executeQuery("create table myuser(name varchar(100), age integer, sex char(1))");
                
                System.out.println("レコード挿入");
                java.sql.PreparedStatement ps = con.prepareStatement("insert into myuser(name, age, sex) values(?,?,?)");
                ps.setString(1, "hoge");
                ps.setInt(2, 20);
                ps.setString(3, "0");
                ps.executeUpdate();
                stmt.executeQuery("insert into myuser(name, age, sex) values('fuga', '25', '1')");
                
                System.out.println("検索");
                ResultSet rs = stmt.executeQuery("select * from myuser");
                System.out.println("名前,年齢,性別");
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
            
            // トランザクション同期サービスを取得する
            TransactionSynchronizerService transactionSynchronizer = (TransactionSynchronizerService)ServiceManagerFactory
                .getServiceObject("TransactionSynchronizer");
            
            // トランザクションを同期する
            System.out.println("同期開始");
            try{
                int transactionCount = transactionSynchronizer.synchronize();
                System.out.println("同期終了 同期したトランザクション数：" + transactionCount);
            }catch(Exception e){
                System.out.println("同期失敗!!");
                e.printStackTrace();
                System.exit(-1);
            }
            
            // データベース2のConnectionFactoryサービスを取得する
            ConnectionFactory factory2 = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory2");
            try{
                con = factory2.getConnection();
                stmt = con.createStatement();
                
                System.out.println("*************** データベース2 ***************");
                System.out.println("検索");
                ResultSet rs = stmt.executeQuery("select * from myuser");
                System.out.println("名前,年齢,性別");
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
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import java.sql.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.QuerySearchManager;
import jp.ossc.nimbus.service.connection.PersistentException;

/**
 * サンプル１０実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            
            QuerySearchManager querySearchManager = (QuerySearchManager)ServiceManagerFactory
                .getServiceObject("QuerySearchManager");
            
            Connection con = null;
            Statement stmt = null;
            try{
                con = factory.getConnection();
                stmt = con.createStatement();
                System.out.println("テーブル作成");
                stmt.executeQuery("create table myuser(name varchar(100), age integer, sex char(1))");
                System.out.println("レコード挿入");
                stmt.executeQuery("insert into myuser(name, age, sex) values('hoge', '20', '0')");
                stmt.executeQuery("insert into myuser(name, age, sex) values('fuga', '25', '1')");
                
                System.out.println("検索１回目");
                long start = System.currentTimeMillis();
                Object user = querySearchManager.search("hoge");
                System.out.println("検索処理時間: " + (System.currentTimeMillis() - start) + " [ms]");
                System.out.println(user);
                
                System.out.println("検索２回目");
                start = System.currentTimeMillis();
                user = querySearchManager.search("hoge");
                System.out.println("検索処理時間: " + (System.currentTimeMillis() - start) + " [ms]");
                System.out.println(user);
            }catch(ConnectionFactoryException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(PersistentException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(SQLException e){
                e.printStackTrace();
                System.exit(-1);
            }finally{
                if(stmt != null){
                    try{
                        System.out.println("テーブル削除");
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
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
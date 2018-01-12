
import java.io.*;
import java.sql.*;
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.io.CSVReader;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.PersistentManager;
import jp.ossc.nimbus.service.connection.PersistentException;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // ConnectionFactoryサービスを取得する
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            
            // PersistentManagerサービスを取得する
            PersistentManager pm = (PersistentManager)ServiceManagerFactory
                .getServiceObject("PersistentManager");
            
            Connection con = null;
            FileInputStream fis = null;
            try{
                // 入力となるユーザリストCSVファイルをオープンする
                fis = new FileInputStream("userlist.csv");
                
                // ストリームをCSVReaderでラップする
                CSVReader reader = new CSVReader(new InputStreamReader(fis));
                reader.setCommentPrefix("#");
                
                // Connectionの取得
                con = factory.getConnection();
                
                // データベースへのバッチ書込みを行うBatchExecutorを生成する
                PersistentManager.BatchExecutor executor = pm.createBatchExecutor(con, "insert into MYUSER(name, age, sex) values(?, ?, ?)", null);
                // 5件ずつバッチ実行するように設定
                executor.setAutoBatchPersistCount(5);
                
                // CSVファイルを１行ずつ読み込みながらデータベースにバッチ実行でINSERTする
                List csv = new ArrayList();
                int updateCount = 0;
                int total = 0;
                System.out.println("データベースへの書き込み開始");
                while((csv = reader.readCSVLineList(csv)) != null){
                    updateCount = executor.addBatch(csv);
                    if(updateCount > 0){
                        System.out.println("MYUSERテーブルに " + updateCount + "件 INSERTしました。");
                    }
                    total+=updateCount;
                }
                updateCount = executor.persist();
                if(updateCount > 0){
                    System.out.println("MYUSERテーブルに " + updateCount + "件 INSERTしました。");
                }
                total+=updateCount;
                System.out.println("MYUSERテーブルに合計 " + total + "件 INSERTしました。");
                executor.close();
                fis.close();
                fis = null;
                
                // データベースからのカーソル読み出しを行うCursorを生成する
                PersistentManager.Cursor cursor = pm.createCursor(con, "select name, age, sex from MYUSER", null, null, null);
                
                // データベースからSELECTしたレコードを１行ずつカーソル移動しながら出力する
                User user = new User();
                System.out.println("データベースからの読み込み開始");
                while(cursor.next()){
                    cursor.load(user);
                    System.out.println("    " + user);
                }
                cursor.close();
            }catch(IOException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(ConnectionFactoryException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(PersistentException e){
                e.printStackTrace();
                System.exit(-1);
            }finally{
                if(fis != null){
                    try{
                        fis.close();
                    }catch(IOException e){
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
    
    public static class User{
        private String name;
        private int age;
        private String sex;
        
        public User(){}
        
        public User(String name, int age, String sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setAge(int age){
            this.age = age;
        }
        public int getAge(){
            return age;
        }
        public void setSex(String sex){
            this.sex = sex;
        }
        public String getSex(){
            return sex;
        }
        public String toString(){
            return '{' + name + ", " + age + ", " + sex + '}';
        }
    }
}

import java.sql.*;
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.PersistentManager;
import jp.ossc.nimbus.service.connection.PersistentException;

/**
 * サンプル６実行クラス。
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
            try{
                // Connectionの取得
                con = factory.getConnection();
                
                // Userオブジェクトを永続化する
                int updateCount = pm.persistQuery(
                    con,
                    "insert into MYUSER(name, age, sex) values(?<-{Name}, ?<-{Age}, ?<-{Sex})",
                    new User("Yamada tarou", 20, "0")
                );
                System.out.println("INSERT 件数=" + updateCount);
                
                // Userオブジェクトをロードする
                User user = (User)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    new User()
                );
                System.out.println("ロードしたUser=" + user);
                
                // Userオブジェクトの配列を永続化する
                updateCount = pm.persistQuery(
                    con,
                    "insert into MYUSER(name, age, sex) values(?<-{Name}, ?<-{Age}, ?<-{Sex})",
                    new User[]{
                        new User("Yamada hanako", 40, "1"),
                        new User("Tanaka kenji", 25, "0")
                    }
                );
                System.out.println("INSERT 件数=" + updateCount);
                
                // Userオブジェクトのリストをロードする
                List userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    User.class
                );
                System.out.println("ロードしたUserのリスト：");
                for(int i = 0, imax = userList.size(); i < imax; i++){
                    System.out.println("    " + userList.get(i));
                }
                
                // Userオブジェクトをロードする
                userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER where sex=?",
                    "0",
                    User.class
                );
                System.out.println("条件\"sexが0\"でロードしたUserのリスト：");
                for(int i = 0, imax = userList.size(); i < imax; i++){
                    System.out.println("    " + userList.get(i));
                }
                
                // Userオブジェクトを削除する
                updateCount = pm.persistQuery(
                    con,
                    "delete from MYUSER where name=?<-{Name}",
                    userList
                );
                System.out.println("DELETE 件数=" + updateCount);
                
                // Userオブジェクトのリストをロードする
                userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    User.class
                );
                System.out.println("削除後のロードしたUserのリスト：");
                for(int i = 0, imax = userList.size(); i < imax; i++){
                    System.out.println("    " + userList.get(i));
                }
            }catch(ConnectionFactoryException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(PersistentException e){
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
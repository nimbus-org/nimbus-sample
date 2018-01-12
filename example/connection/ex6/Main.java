
import java.sql.*;
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactory;
import jp.ossc.nimbus.service.connection.ConnectionFactoryException;
import jp.ossc.nimbus.service.connection.PersistentManager;
import jp.ossc.nimbus.service.connection.PersistentException;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            // ConnectionFactory�T�[�r�X���擾����
            ConnectionFactory factory = (ConnectionFactory)ServiceManagerFactory
                .getServiceObject("ConnectionFactory");
            
            // PersistentManager�T�[�r�X���擾����
            PersistentManager pm = (PersistentManager)ServiceManagerFactory
                .getServiceObject("PersistentManager");
            
            Connection con = null;
            try{
                // Connection�̎擾
                con = factory.getConnection();
                
                // User�I�u�W�F�N�g���i��������
                int updateCount = pm.persistQuery(
                    con,
                    "insert into MYUSER(name, age, sex) values(?<-{Name}, ?<-{Age}, ?<-{Sex})",
                    new User("Yamada tarou", 20, "0")
                );
                System.out.println("INSERT ����=" + updateCount);
                
                // User�I�u�W�F�N�g�����[�h����
                User user = (User)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    new User()
                );
                System.out.println("���[�h����User=" + user);
                
                // User�I�u�W�F�N�g�̔z����i��������
                updateCount = pm.persistQuery(
                    con,
                    "insert into MYUSER(name, age, sex) values(?<-{Name}, ?<-{Age}, ?<-{Sex})",
                    new User[]{
                        new User("Yamada hanako", 40, "1"),
                        new User("Tanaka kenji", 25, "0")
                    }
                );
                System.out.println("INSERT ����=" + updateCount);
                
                // User�I�u�W�F�N�g�̃��X�g�����[�h����
                List userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    User.class
                );
                System.out.println("���[�h����User�̃��X�g�F");
                for(int i = 0, imax = userList.size(); i < imax; i++){
                    System.out.println("    " + userList.get(i));
                }
                
                // User�I�u�W�F�N�g�����[�h����
                userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER where sex=?",
                    "0",
                    User.class
                );
                System.out.println("����\"sex��0\"�Ń��[�h����User�̃��X�g�F");
                for(int i = 0, imax = userList.size(); i < imax; i++){
                    System.out.println("    " + userList.get(i));
                }
                
                // User�I�u�W�F�N�g���폜����
                updateCount = pm.persistQuery(
                    con,
                    "delete from MYUSER where name=?<-{Name}",
                    userList
                );
                System.out.println("DELETE ����=" + updateCount);
                
                // User�I�u�W�F�N�g�̃��X�g�����[�h����
                userList = (List)pm.loadQuery(
                    con,
                    "select name->{Name}, age->{Age}, sex->{Sex} from MYUSER",
                    null,
                    User.class
                );
                System.out.println("�폜��̃��[�h����User�̃��X�g�F");
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
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
        }
        
        // �T�[�r�X��`�t�@�C�����A�����[�h����
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
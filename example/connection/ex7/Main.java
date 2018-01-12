
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
 * �T���v���V���s�N���X�B
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
            FileInputStream fis = null;
            try{
                // ���͂ƂȂ郆�[�U���X�gCSV�t�@�C�����I�[�v������
                fis = new FileInputStream("userlist.csv");
                
                // �X�g���[����CSVReader�Ń��b�v����
                CSVReader reader = new CSVReader(new InputStreamReader(fis));
                reader.setCommentPrefix("#");
                
                // Connection�̎擾
                con = factory.getConnection();
                
                // �f�[�^�x�[�X�ւ̃o�b�`�����݂��s��BatchExecutor�𐶐�����
                PersistentManager.BatchExecutor executor = pm.createBatchExecutor(con, "insert into MYUSER(name, age, sex) values(?, ?, ?)", null);
                // 5�����o�b�`���s����悤�ɐݒ�
                executor.setAutoBatchPersistCount(5);
                
                // CSV�t�@�C�����P�s���ǂݍ��݂Ȃ���f�[�^�x�[�X�Ƀo�b�`���s��INSERT����
                List csv = new ArrayList();
                int updateCount = 0;
                int total = 0;
                System.out.println("�f�[�^�x�[�X�ւ̏������݊J�n");
                while((csv = reader.readCSVLineList(csv)) != null){
                    updateCount = executor.addBatch(csv);
                    if(updateCount > 0){
                        System.out.println("MYUSER�e�[�u���� " + updateCount + "�� INSERT���܂����B");
                    }
                    total+=updateCount;
                }
                updateCount = executor.persist();
                if(updateCount > 0){
                    System.out.println("MYUSER�e�[�u���� " + updateCount + "�� INSERT���܂����B");
                }
                total+=updateCount;
                System.out.println("MYUSER�e�[�u���ɍ��v " + total + "�� INSERT���܂����B");
                executor.close();
                fis.close();
                fis = null;
                
                // �f�[�^�x�[�X����̃J�[�\���ǂݏo�����s��Cursor�𐶐�����
                PersistentManager.Cursor cursor = pm.createCursor(con, "select name, age, sex from MYUSER", null, null, null);
                
                // �f�[�^�x�[�X����SELECT�������R�[�h���P�s���J�[�\���ړ����Ȃ���o�͂���
                User user = new User();
                System.out.println("�f�[�^�x�[�X����̓ǂݍ��݊J�n");
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
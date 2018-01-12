
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.ejb.EJBFactory;

import sample.ejb.MessengerHome;
import sample.ejb.MessengerHome2;
import sample.ejb.Messenger;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            EJBFactory factory = (EJBFactory)ServiceManagerFactory
                .getServiceObject("EJBFactory");
            
            Messenger messenger = null;
            try{
                // MessengerセッションBeanを取得する
                // 引数なしのcreateメソッドを持ったEJBリモート参照を取得する
                messenger = (Messenger)factory.get(
                    "Messenger",
                    MessengerHome.class
                );
                
                // MessengerセッションBeanを呼び出す
                System.out.println(messenger.getMessage());
                
                // MessengerセッションBeanを取得する
                // 引数ありのcreateメソッドを持ったEJBリモート参照を取得する
                messenger = (Messenger)factory.get(
                    "Messenger2",
                    MessengerHome2.class,
                    new Class[]{String.class},
                    new Object[]{"hoge"}
                );
                
                // MessengerセッションBeanを呼び出す
                System.out.println(messenger.getMessage());
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(CreateException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(NoSuchMethodException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(IllegalAccessException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(InvocationTargetException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(RemoteException e){
                e.printStackTrace();
                System.exit(-1);
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
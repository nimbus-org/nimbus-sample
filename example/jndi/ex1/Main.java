
import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jndi.JndiFinder;

import sample.ejb.MessengerHome;
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
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                .getServiceObject("JndiFinder");
            
            MessengerHome home = null;
            try{
                // MessengerセッションBeanのHomeインタフェースをlookupする
                home = (MessengerHome)finder.lookup("Messenger");
            }catch(NamingException e){
                e.printStackTrace();
                System.exit(-1);
            }
            
            try{
                // MessengerセッションBeanをcreateする
                Messenger messenger = home.create();
                
                // MessengerセッションBeanを呼び出す
                System.out.println(messenger.getMessage());
                
            }catch(RemoteException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(CreateException e){
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
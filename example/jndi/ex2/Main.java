
import java.io.IOException;
import java.io.InputStreamReader;

import java.rmi.RemoteException;
import javax.naming.NamingException;

import javax.ejb.CreateException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.jndi.JndiFinder;

import sample.ejb.MessengerHome;
import sample.ejb.Messenger;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            JndiFinder finder = (JndiFinder)ServiceManagerFactory
                .getServiceObject("JndiFinder");
            
            // 1回目の呼び出し
            callMessenger(finder);
            
            // 2回目の呼び出し
            callMessenger(finder);
            
            System.out.println("JBossをシャットダウンして、Enterキーを押して下さい。");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // JNDIサーバダウン中の呼び出し
            callMessenger(finder);
            
            System.out.println("JBossを起動して、Enterキーを押して下さい。");
            try{
                new InputStreamReader(System.in).read();
                Thread.sleep(1500);
            }catch(IOException e){
            }catch(InterruptedException e){
            }
            
            // JNDIサーバ再起動後の呼び出し
            callMessenger(finder);
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static void callMessenger(JndiFinder finder){
        
        MessengerHome home = null;
        try{
            // MessengerセッションBeanのHomeインタフェースをlookupする
            long start = System.currentTimeMillis();
            home = (MessengerHome)finder.lookup("Messenger");
            System.out.println("JndiFinderからのlookup処理時間 : " + (System.currentTimeMillis() - start) + " [ms]");
            System.out.println("JndiFinderからlookupしたオブジェクト : " + home);
        }catch(NamingException e){
            System.out.println("lookupに失敗しました：" + e.getMessage());;
            return;
        }
        
        try{
            // MessengerセッションBeanをcreateする
            Messenger messenger = home.create();
            
            // MessengerセッションBeanを呼び出す
            System.out.println(messenger.getMessage());
            
        }catch(RemoteException e){
            e.printStackTrace();
        }catch(CreateException e){
            e.printStackTrace();
        }
    }
}
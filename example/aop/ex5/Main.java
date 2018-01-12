
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.aop.interceptor.AsynchronousTimeoutException;

import sample.service.Messenger;

/**
 * サンプル５実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // アスペクトが掛かっているメソッドを呼び出す
                // 非同期処理を行うため、実際にdisplayMessage()メソッドが
                // 呼び出される前に応答が返ってくる
                long start = System.currentTimeMillis();
                System.out.println("displayMessageメソッド呼び出し×３ 開始");
                service1.displayMessage();
                service1.displayMessage();
                service1.displayMessage();
                System.out.println("displayMessageメソッド呼び出し×３ 終了 : " + (System.currentTimeMillis() - start) + "[ms]");
                
                // 非同期処理が終わるのを待ち合わせる
                Thread.sleep(2000);
                
                // アスペクトが掛かっているメソッドを呼び出す
                // 非同期処理にタイムアウト設定を行っているため、
                // displayMessage2()メソッドの処理時間が、タイムアウト設定値
                //（1秒）よりも長いと例外が発生する
                // 但し、タイムアウトしても、非同期処理自体はキャンセルされない
                System.out.println("displayMessage2メソッド（処理時間500[ms]）呼び出し開始");
                start = System.currentTimeMillis();
                service1.displayMessage2(500);
                System.out.println("displayMessage2メソッド呼び出し終了 : " + (System.currentTimeMillis() - start) + "[ms]");
                
                start = System.currentTimeMillis();
                try{
                    System.out.println("displayMessage2メソッド（処理時間2000[ms]）呼び出し開始");
                    service1.displayMessage2(2000);
                    System.out.println("displayMessage2メソッド呼び出し終了 : " + (System.currentTimeMillis() - start) + "[ms]");
                }catch(AsynchronousTimeoutException e){
                    System.out.println("displayMessage2メソッドタイムアウト発生 : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                
                // 非同期処理が終わるのを待ち合わせる
                Thread.sleep(2000);
                
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("アスペクト定義の読み込みに失敗しました。");
        }
        
        // アスペクト定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("aspect-definition.xml");
    }
    
}
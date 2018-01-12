
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル６実行クラス。
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
                long start = 0;
                System.out.println("getMessageメソッド呼び出し×１０");
                for(int i = 0; i < 10; i++){
                    start = System.currentTimeMillis();
                    service1.getMessage();
                    System.out.println("getMessageメソッド処理時間" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                System.out.println("displayMessageメソッド呼び出し×５");
                for(int i = 0; i < 5; i++){
                    start = System.currentTimeMillis();
                    service1.displayMessage();
                    System.out.println("displayMessageメソッド処理時間" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                System.out.println("displayMessage2メソッド呼び出し×５");
                for(int i = 0; i < 5; i++){
                    start = System.currentTimeMillis();
                    service1.displayMessage2(100 * (i + 1));
                    System.out.println("displayMessage2メソッド処理時間" + (i + 1) + " : " + (System.currentTimeMillis() - start) + "[ms]");
                }
                
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
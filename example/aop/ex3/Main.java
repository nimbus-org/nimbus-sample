
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル３実行クラス。
 * アスペクト定義をロードするため、動的アスペクトが掛かる。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // アスペクトが掛かっているメソッドを呼び出す
                System.out.println("POJOService.getMessage2() : " + service1.getMessage2());
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
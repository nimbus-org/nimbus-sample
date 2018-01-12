
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("client-service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Messenger messenger = (Messenger)ServiceManagerFactory
                .getServiceObject("Messenger");
            
            System.out.println(messenger.getMessage());
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("client-service-definition.xml");
    }
    
}
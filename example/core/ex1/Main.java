
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("Nimbusマネージャから取得したサービス：" + service1);
            
            // サービスを取得する
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Group1", "Service1");
            
            System.out.println("Group1マネージャから取得したサービス：" + service1);
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
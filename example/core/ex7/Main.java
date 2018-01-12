
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.core.ServiceNotFoundException;

import sample.service.SimpleService;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            try{
                SimpleService service1 = (SimpleService)ServiceManagerFactory
                    .getServiceObject("Service1");
                System.out.println(service1.toString());
            }catch(ServiceNotFoundException e){
                System.out.println("Service1が存在しませんでした。");
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
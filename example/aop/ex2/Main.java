
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * サンプル２実行クラス。
 * アスペクト定義はロードしないため、動的アスペクトは掛からない。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            // アスペクトが掛かっていないメソッドを呼び出す
            System.out.println("POJOService.getMessage() : " + service1.getMessage());
            
            // アスペクトが掛かっているメソッドを呼び出す
            long start = System.currentTimeMillis();
            System.out.println("POJOService.getMessage2() : " + service1.getMessage2() + ", 処理時間[ms] : " + (System.currentTimeMillis() - start));
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
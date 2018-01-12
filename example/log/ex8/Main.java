
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;
import jp.ossc.nimbus.service.log.Logger;

/**
 * サンプル８実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // Loggerサービスを取得する
            Logger log = (Logger)ServiceManagerFactory
                .getServiceObject("Log");
            
            // 各ログレベルのログを出力する
            log.write("APL_001");
            log.write("APL_002", "Mr. Hoge");
            log.write("APL_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            log.write("APL_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            log.write("APL_005", "Mr. Hoge", new Exception("テスト"));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
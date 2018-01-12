
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import jp.ossc.nimbus.core.ServiceManagerFactory;

/**
 * サンプル６実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // Jakarta Commons Logging のLogを取得する
            Log log = LogFactory.getLog(Main.class);
            
            // Jakarta Commons Logging の各レベルのログを出力する
            log.trace("Hi.");
            log.debug("Hello.");
            log.info("Good morning.");
            log.warn("Good afternoon.");
            log.error("Good evening.");
            log.fatal("Good night.", new Exception("テスト"));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
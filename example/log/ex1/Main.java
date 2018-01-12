
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.log.Logger;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Logger log = (Logger)ServiceManagerFactory
                .getServiceObject("Log");
            
            // メッセージを直接指定して、デバッグログを出力する
            log.debug("Hi.");
            
            // メッセージIDを指定して、各レベルのログを出力する
            
            // SYSTEM_DEBUGレベルのログを出力する
            log.write("APL_001");
            
            // SYSTEM_INFOレベルのログを出力する
            // また、埋め込みメッセージを指定する
            log.write("APL_002", "Mr. Hoge");
            
            // SYSTEM_WARNレベルのログを出力する
            // また、複数の埋め込みメッセージを指定する
            log.write("APL_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            
            // SYSTEM_ERRORレベルのログを出力する
            // また、複数の埋め込みメッセージを指定する
            // 但し、1番目の埋め込みメッセージはシークレット埋め込みメッセージ
            log.write("APL_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"});
            
            // SYSTEM_FATALレベルのログを出力する
            // また、埋め込みメッセージと、例外を指定する
            log.write("APL_005", "Mr. Hoge", new Exception("テスト"));
            
            // SYSTEM_FATALレベルのログを出力する
            // また、埋め込みメッセージと、例外を指定する
            // 指定した例外は、メッセージ定義によって出力しないようになっている
            log.write("APL_006", "Mr. Hoge", new Exception("テスト"));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
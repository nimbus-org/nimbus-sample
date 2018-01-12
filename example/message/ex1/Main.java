
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.message.MessageRecordFactory;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            MessageRecordFactory messageFactory
                 = (MessageRecordFactory)ServiceManagerFactory
                    .getServiceObject("MessageRecordFactory");
            
            // メッセージIDを指定して、メッセージを取得する
            System.out.println(messageFactory.findMessage("MSG_001"));
            
            // 埋め込みメッセージを指定する
            System.out.println(messageFactory.findEmbedMessage("MSG_002", "Mr. Hoge"));
            
            // 複数の埋め込みメッセージを指定する
            System.out.println(messageFactory.findEmbedMessage("MSG_003", new Object[]{"Mr. Hoge", "Mrs. Fuga"}));
            
            // 複数の埋め込みメッセージを指定する
            // 但し、1番目の埋め込みメッセージはシークレット埋め込みメッセージ
            System.out.println(messageFactory.findEmbedMessage("MSG_004", new Object[]{"Mr. Hoge", "Mrs. Fuga"}));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
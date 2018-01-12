
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Context context = (Context)ServiceManagerFactory
                .getServiceObject("Context");
            
            // サービス定義で設定済みのコンテキスト情報を取得する
            System.out.println("A = " + context.get("A"));
            System.out.println("B = " + context.get("B"));
            System.out.println("C = " + context.get("C"));
            
            // コンテキスト情報を追加する
            context.put("D", "fuga");
            
            // 追加したコンテキスト情報を取得する
            System.out.println("D = " + context.get("D"));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
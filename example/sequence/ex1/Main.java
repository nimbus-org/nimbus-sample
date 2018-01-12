
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.sequence.Sequence;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Sequence sequence = (Sequence)ServiceManagerFactory
                .getServiceObject("Sequence");
            
            // 通番を出力する
            for(int i = 0; i < 100; i++){
                System.out.println("通番[" + i + "] : " + sequence.increment());
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
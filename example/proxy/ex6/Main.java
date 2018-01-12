
import jp.ossc.nimbus.core.ServiceManagerFactory;

import java.util.Map;

/**
 * サンプル６実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Map map = (Map)ServiceManagerFactory
                .getServiceObject("Map");
            while(true){
                try{
                    System.out.println(map.get("Message"));
                }catch(Exception e){
                    System.out.println("呼び出しに失敗しました。" + e);
                }
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    break;
                }
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
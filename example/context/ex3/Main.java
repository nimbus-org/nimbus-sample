
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;
import jp.ossc.nimbus.service.context.ServerInfo;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final ServerInfo context = (ServerInfo)ServiceManagerFactory
                .getServiceObject("Context");
            
            // サーバ情報を取得する
            System.out.println(ServerInfo.OS_NAME_KEY + " = " + context.get(ServerInfo.OS_NAME_KEY));
            System.out.println(ServerInfo.HOST_NAME_KEY + " = " + context.get(ServerInfo.HOST_NAME_KEY));
            System.out.println(ServerInfo.TOTAL_MEMORY_KEY + " = " + context.getTotalMemory());
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
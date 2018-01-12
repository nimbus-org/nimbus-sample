
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.core.DefaultServiceLoaderConfig;

import sample.service.POJOService;

/**
 * サンプル６実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // ServiceLoaderConfigを生成する
        // サービス定義ファイルのロード時に、ServiceLoaderConfigを
        // 渡す事で、サービス定義内のプロパティ参照で参照できる
        DefaultServiceLoaderConfig config = new DefaultServiceLoaderConfig();
        config.setProperty(
            "loder.Message",
            "ServiceLoaderConfigのプロパティです。"
        );
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml", config, false, false)){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            // JavaVMのシステムプロパティを参照したサービス
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager1", "Service1");
            System.out.println("JavaVMのシステムプロパティを参照したサービス : " + service1);
            
            // server-propertyを参照したサービス
            POJOService service2 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager1", "Service2");
            System.out.println("server-propertyを参照したサービス : " + service2);
            
            // manager-propertyを参照したサービス
            POJOService service3 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager2", "Service1");
            System.out.println("manager-propertyを参照したサービス : " + service3);
            
            // ServiceLoaderConfigを参照したサービス
            POJOService service4 = (POJOService)ServiceManagerFactory
                .getServiceObject("Manager2", "Service2");
            System.out.println("ServiceLoaderConfigを参照したサービス : " + service4);
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("取得したサービス：" + service1);
            
            System.out.println("field要素で設定した属性 isPrint の値：" + service1.isPrint);
            
            System.out.println("attribute要素で設定した属性 IntValue の値：" + service1.getIntValue());
            
            System.out.println("attribute要素で設定した属性 Calendar の値：" + service1.getCalendar().getTime());
            
            System.out.println("attribute要素で設定した属性 ImageWriter の値：" + service1.getImageWriter());
            
            service1.printMap();
            
            service1.printIndex();
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
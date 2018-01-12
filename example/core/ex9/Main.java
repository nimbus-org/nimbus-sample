
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.core.ServiceNotFoundException;

import sample.service.SampleService;

/**
 * サンプル９実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // テンプレートサービスを取得する
            try{
                SampleService template = (SampleService)ServiceManagerFactory
                    .getServiceObject("TemplateService");
            }catch(ServiceNotFoundException e){
                System.out.println("テンプレートは取得できません");
            }
            
            // サービス1を取得する
            SampleService service1 = (SampleService)ServiceManagerFactory
                .getServiceObject("Service1");
            System.out.println("取得したサービス：" + service1);
            service1.printMessage();
            
            // サービス2を取得する
            SampleService service2 = (SampleService)ServiceManagerFactory
                .getServiceObject("Service2");
            System.out.println("取得したサービス：" + service2);
            service2.printMessage();
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
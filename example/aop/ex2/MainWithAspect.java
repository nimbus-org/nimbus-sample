
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;
import sample.service.Messenger;

/**
 * サンプル２実行クラス。
 * アスペクト定義をロードするため、動的アスペクトが掛かる。
 */
public class MainWithAspect{
    
    public static final void main(String[] args){
        
        // アスペクト定義ファイルをロードする
        // アスペクト対象のクラスをロードするサービス定義よりも
        // 先にロードしなければならない。
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                // 注意：
                // MainWithAspectクラスのクラスローダは、システムクラスローダ
                // であるのに対して、
                // POJOServiceのクラスローダは、Nimbusクラスローダである。
                // POJOServiceクラスは、Nimbusクラスローダによって
                // アスペクトされ、動的にクラスを変更されているので、
                // システムクラスローダが知っているPOJOServiceクラスとは
                // 異なるクラスである。
                // そのため、POJOServiceにキャストしようとすると、
                // ClassCastExceptionが発生してしまう。
                // 但し、同一のクラスローダ内でのキャストなら問題ない。
                try{
                    POJOService service1 = (POJOService)ServiceManagerFactory
                        .getServiceObject("Service1");
                }catch(ClassCastException e){
                    System.out.println("POJOService にはキャストできない。" + e);
                }
                
                // アスペクトしていないPOJOServiceクラスが実装している
                // Messengerインタフェースとして取得する
                Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // アスペクトが掛かっていないメソッドを呼び出す
                System.out.println("POJOService.getMessage() : " + service1.getMessage());
                
                // アスペクトが掛かっているメソッドを呼び出す
                long start = System.currentTimeMillis();
                System.out.println("POJOService.getMessage2() : " + service1.getMessage2() + ", 処理時間[ms] : " + (System.currentTimeMillis() - start));
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("アスペクト定義の読み込みに失敗しました。");
        }
        
        // アスペクト定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("aspect-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.POJOService;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // 通常のサービスを取得する
            POJOService service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("通常のサービス取得1回目：" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service1");
            
            System.out.println("通常のサービス取得2回目：" + service1);
            
            // instance属性をfactoryに設定したサービスを取得する
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service2");
            
            System.out.println("ファクトリサービス取得1回目：" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service2");
            
            System.out.println("ファクトリサービス取得2回目：" + service1);
            
            // instance属性をthreadlocalに設定したサービスを取得する
            Thread thread1 = new Thread(
                new Runnable(){
                    public void run(){
                        
                        POJOService service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        String threadName = Thread.currentThread().getName();
                        System.out.println("ThreadLocalファクトリサービスをスレッド" + threadName + "で取得1回目：" + service);
                        
                        service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        System.out.println("ThreadLocalファクトリサービスをスレッド" + threadName + "で取得2回目：" + service);
                    }
                }
            );
            
            Thread thread2 = new Thread(
                new Runnable(){
                    public void run(){
                        
                        POJOService service = (POJOService)ServiceManagerFactory
                            .getServiceObject("Service3");
                        
                        String threadName = Thread.currentThread().getName();
                        System.out.println("ThreadLocalファクトリサービスをスレッド" + threadName + "で取得：" + service);
                    }
                }
            );
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            
            // instance属性をfactory
            // management属性をtrueに設定したサービスを取得する
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service4");
            
            System.out.println("ファクトリからサービス取得：" + service1);
            
            service1 = (POJOService)ServiceManagerFactory
                .getServiceObject("Service4$0");
            
            System.out.println("ファクトリから生成され登録されたサービス取得：" + service1);
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
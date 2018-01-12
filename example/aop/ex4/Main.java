
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                // アスペクトが掛かっているメソッドを呼び出す
                // 100スレッドで、同時にメソッドを呼び出す
                Thread[] threads = new Thread[100];
                for(int i = 0; i < threads.length; i++){
                    threads[i] = new Thread(
                        new Runnable(){
                            public void run(){
                                System.out.println(Thread.currentThread().getName() + " : POJOService.getMessage2() : " + service1.getMessage2());
                            }
                        },
                        "Thread" + (i + 1)
                    );
                }
                for(int i = 0; i < threads.length; i++){
                    threads[i].start();
                }
                for(int i = 0; i < threads.length; i++){
                    threads[i].join();
                }
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
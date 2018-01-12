
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル７実行クラス。
 */
public class Main2{
    
    public static final void main(String[] args) throws Exception{
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition2.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                final Messenger service1 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service1");
                final Messenger service2 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service2");
                final Messenger service3 = (Messenger)ServiceManagerFactory
                    .getServiceObject("Service3");
                
                // アスペクトが掛かっているメソッドを呼び出す
                // (1)POJOService1.getMessage()の処理時間は1秒
                // (2)POJOService2.getMessage2()の処理時間は0.5秒
                // (3)POJOService1.getMessage2()の処理時間は0.5秒
                // であるため、(2)(3)、(1)の順に終わるはずであるが、
                // アスペクトでクラス同期が掛かっているため、
                // 同じクラスへの呼び出しである(1)と(3)は、
                // (1)が終わるまで、(3)が待たされる。
                // また、(2)は、クラスが異なるため、同期されない。
                // 従って、(2)、(1)、(3)の順に終わる。
                Thread thread1 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(1)POJOService1.getMessage() : " + service1.getMessage());
                        }
                    }
                );
                Thread thread2 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(2)POJOService2.getMessage2() : " + service2.getMessage2());
                        }
                    }
                );
                Thread thread3 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(3)POJOService1.getMessage2() : " + service3.getMessage2());
                        }
                    }
                );
                thread1.start();
                thread2.start();
                thread3.start();
                
                thread1.join();
                thread2.join();
                thread3.join();
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("アスペクト定義の読み込みに失敗しました。");
        }
        
        // アスペクト定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("aspect-definition2.xml");
    }
    
}
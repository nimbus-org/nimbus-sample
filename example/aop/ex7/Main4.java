
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Messenger;

/**
 * サンプル７実行クラス。
 */
public class Main4{
    
    public static final void main(String[] args) throws Exception{
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition4.xml")){
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
                // (1)POJOService1(Service1).getMessage3(1000)の処理時間は1秒
                // (2)POJOService2(Service2).getMessage3(500)の処理時間は0.5秒
                // (3)POJOService1(Service3).getMessage2()の処理時間は0.5秒
                // (4)POJOService1(Service1).getMessage2()の処理時間は0.5秒
                // (5)POJOService1(Service1).getMessage3(500)の処理時間は0.5秒
                // であるため、(2)(3)(4)(5)、(1)の順に終わるはずであるが、
                // アスペクトでインスタンス同期が掛かっているため、
                // 同じインスタンスへの呼び出しである(1)と(4)と(5)は、
                // (1)が終わるまで、(4)(5)が待たされる。
                // また、(2)は、クラスが異なるため、同期されない。
                // また、(3)は、インスタンスが異なるため、同期されない。
                // 従って、(2)(3)、(1)、(4)(5)の順に終わる。
                Thread thread1 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(1)POJOService1(Service1).getMessage3(1000) : " + service1.getMessage3(1000));
                        }
                    }
                );
                Thread thread2 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(2)POJOService2(Service2).getMessage3(500) : " + service2.getMessage3(500));
                        }
                    }
                );
                Thread thread3 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(3)POJOService1(Service3).getMessage2() : " + service3.getMessage2());
                        }
                    }
                );
                Thread thread4 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(4)POJOService1(Service1).getMessage2() : " + service1.getMessage2());
                        }
                    }
                );
                Thread thread5 = new Thread(
                    new Runnable(){
                        public void run(){
                            System.out.println("(5)POJOService1(Service1).getMessage3(500) : " + service1.getMessage3(500));
                        }
                    }
                );
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                thread5.start();
                
                thread1.join();
                thread2.join();
                thread3.join();
                thread4.join();
                thread5.join();
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("アスペクト定義の読み込みに失敗しました。");
        }
        
        // アスペクト定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("aspect-definition4.xml");
    }
    
}
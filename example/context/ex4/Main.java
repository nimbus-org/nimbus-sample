
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.Context;
import jp.ossc.nimbus.service.context.ServerInfo;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Context context = (Context)ServiceManagerFactory
                .getServiceObject("Context");
            final Context threadContext = (Context)ServiceManagerFactory
                .getServiceObject("ThreadContext");
            
            Runnable runnable = new Runnable(){
                public void run(){
                    
                    // スレッド名を取得する
                    String name = Thread.currentThread().getName();
                    
                    // コンテキスト情報を追加する
                    // グルーピングしているContextサービスには、
                    // コンテキスト情報を追加する事はできない。
                    // グルーピングされているContextサービスに直に追加する
                    threadContext.put("D", name);
                    
                    // サービス定義で設定済みのコンテキスト情報を取得する
                    System.out.println(name + " : A = " + context.get("A"));
                    System.out.println(name + " : B = " + context.get("B"));
                    System.out.println(name + " : C = " + context.get("C"));
                    
                    // 追加したコンテキスト情報を取得する
                    System.out.println(name + " : D = " + context.get("D"));
                    
                    // サーバ情報を取得する
                    System.out.println(name + " : " + ServerInfo.HOST_NAME_KEY + " = " + context.get(ServerInfo.HOST_NAME_KEY));
                }
            };
            
            // スレッドを開始する
            Thread thread1 = new Thread(runnable, "Thread1");
            Thread thread2 = new Thread(runnable, "Thread2");
            Thread thread3 = new Thread(runnable, "Thread3");
            thread1.start();
            thread2.start();
            thread3.start();
            try{
                thread1.join();
                thread2.join();
                thread3.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
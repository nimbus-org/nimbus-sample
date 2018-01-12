
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.semaphore.Semaphore;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Semaphore semaphore = (Semaphore)ServiceManagerFactory
                .getServiceObject("Semaphore");
            
            // リソースの残りを確認する
            System.out.println("残りリソース数 : " + semaphore.getResourceRemain());
            
            // セマフォ獲得
            for(int i = 1; i <= 3; i++){
                System.out.print("セマフォ獲得[" + i + "]...");
                long start = System.currentTimeMillis();
                if(semaphore.getResource(500l)){
                    long end = System.currentTimeMillis();
                    System.out.println("成功 " + (end - start) + "[ms]");
                    System.out.println("残りリソース数 : " + semaphore.getResourceRemain());
                }else{
                    long end = System.currentTimeMillis();
                    System.out.println("失敗 " + (end - start) + "[ms]");
                }
            }
            
            System.out.println();
            
            // セマフォ開放
            for(int i = 1; i <= 2; i++){
                System.out.print("セマフォ開放[" + i + "] ");
                semaphore.freeResource();
                System.out.println("残りリソース数 : " + semaphore.getResourceRemain());
            }
            
            System.out.println();
            
            // セマフォ獲得スレッドを作成する
            Runnable getterRunnable = new Runnable(){
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " : セマフォ獲得...");
                    if(semaphore.getResource()){
                        System.out.println(Thread.currentThread().getName() + " : 成功");
                    }else{
                        System.out.println(Thread.currentThread().getName() + " : 失敗");
                    }
                }
            };
            
            // セマフォ獲得
            for(int i = 1; i <= 4; i++){
                Thread thread = new Thread(getterRunnable);
                thread.start();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            
            // セマフォ獲得待ちを確認する
            System.out.println("セマフォ獲得待ち数 : " + semaphore.getWaitingCount());
            
            // セマフォ獲得待ち数を指定して、セマフォ獲得
            // 待ち数が指定した数以上の場合、獲得に失敗する
            System.out.print("セマフォ獲得待ち数2を指定してセマフォ獲得...");
            if(semaphore.getResource(2)){
                System.out.println("成功");
            }else{
                System.out.println("失敗");
            }
            
            // セマフォ獲得待ちを再開する
            System.out.println("セマフォ待ちうけ停止");
            semaphore.release();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
            System.out.println("セマフォ待ちうけ開始");
            semaphore.accept();
            
            // セマフォ獲得後強制開放時間を指定して、セマフォ獲得
            // セマフォ獲得後時間が指定した時間を超えると、強制的に開放される
            System.out.print("セマフォ獲得後強制開放時間に1秒を指定してセマフォ獲得...");
            Thread thread = new Thread(getterRunnable);
            thread.start();
            if(semaphore.getResource(-1, -1, 1000)){
                System.out.println("成功");
            }else{
                System.out.println("失敗");
            }
            
            try{
                Thread.sleep(500);
                System.out.println("0.5秒後 残りリソース数 : " + semaphore.getResourceRemain());
                Thread.sleep(500);
                System.out.println("1.0秒後 残りリソース数 : " + semaphore.getResourceRemain());
            }catch(InterruptedException e){
            }
            
            System.out.println();
            
            // セマフォ獲得待ちを開放する
            System.out.println("セマフォ獲得待ち開放");
            semaphore.release();
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
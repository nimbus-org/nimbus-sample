
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Queue queue = (Queue)ServiceManagerFactory
                .getServiceObject("Queue");
            
            // Queueに詰める要素を用意する
            final List list = new ArrayList();
            for(int i = 1; i <= 10; i++){
                list.add(new Integer(i));
            }
            
            // Queueから引き抜くスレッドを作成する
            // 引き抜けるまで待ち続けるスレッド
            Thread getter = new Thread(new Runnable(){
                public void run(){
                    while(list.size() != 0){
                        StringBuffer buf = new StringBuffer();
                        buf.append(Thread.currentThread().getName());
                        long start = System.currentTimeMillis();
                        Object obj = queue.get();
                        long end = System.currentTimeMillis();
                        buf.append(" : 取得結果=" + obj);
                        buf.append(" : 取得待ち時間=" + (end - start));
                        System.out.println(buf);
                    }
                }
            }, "getter");
            // 引き抜けるまで1.7秒間待って、引き抜けなかったらあきらめるスレッド
            Thread getterWithTimeout = new Thread(new Runnable(){
                public void run(){
                    while(list.size() != 0){
                        StringBuffer buf = new StringBuffer();
                        buf.append(Thread.currentThread().getName());
                        long start = System.currentTimeMillis();
                        Object obj = queue.get(1700);
                        long end = System.currentTimeMillis();
                        if(obj == null){
                            buf.append(" : タイムアウト=" + (end - start));
                        }else{
                            buf.append(" : 取得結果=" + obj);
                            buf.append(" : 取得待ち時間=" + (end - start));
                        }
                        System.out.println(buf);
                    }
                }
            }, "getterWithTimeout");
            
            // Queueから引き抜くスレッドを開始する
            getter.start();
            getterWithTimeout.start();
            
            // 1秒毎にQueueに詰める
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
            final Iterator itr = list.iterator();
            while(itr.hasNext()){
                queue.push(itr.next());
                itr.remove();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                }
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        System.out.println("キューを開放する");
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
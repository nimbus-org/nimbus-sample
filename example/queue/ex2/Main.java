
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Queue queue = (Queue)ServiceManagerFactory
                .getServiceObject("Queue");
            
            // 1秒毎にQueueに詰める
            final List list = new ArrayList();
            for(int i = 1; i <= 10; i++){
                queue.push(new Integer(i));
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                }
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
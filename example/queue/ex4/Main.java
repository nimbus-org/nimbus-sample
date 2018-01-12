
import java.util.Date;
import java.text.SimpleDateFormat;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Queue queue = (Queue)ServiceManagerFactory
                .getServiceObject("Queue");
            
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            if("get".equals(args[0])){
                Object element = null;
                while((element = queue.get(1000)) != null){
                    System.out.println("get : " + element);
                }
            }else{
                for(int i = 0; i < 3; i++){
                    if(i != 0){
                        Thread.sleep(1000);
                    }
                    String time = format.format(new Date());
                    System.out.println("push : " + time);
                    queue.push(time);
                }
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.queue.Queue;

/**
 * サンプル５実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Queue queue = (Queue)ServiceManagerFactory.getServiceObject("Queue");
            
            if("GET".equals(args[0])){
                long processTime = Long.parseLong(args[1]);
                Object dequed = null;
                while(true){
                    dequed = queue.get(1000);
                    if(dequed != null){
                        System.out.println("GET : " + dequed);
                        Thread.sleep(processTime);
                    }
                }
            }else{
                int count = Integer.parseInt(args[1]);
                long start = System.currentTimeMillis();
                for(int i = 0; i < count; i++){
                    Object input = String.valueOf(i + 1);
                    System.out.println("PUT : " + input);
                    queue.push(input);
                }
                int depth = 0;
                int preDepth = queue.size();
                while((depth = queue.size()) != 0){
                    if(preDepth != depth){
                        System.out.println("DEPTH : " + depth);
                    }
                    preDepth = depth;
                }
                System.out.println((double)count / ((double)(System.currentTimeMillis() - start) / 1000.0d) + "[TPS]");
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
        System.exit(0);
    }
    
}
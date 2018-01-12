
import java.util.List;
import java.util.ArrayList;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml") && ServiceManagerFactory.checkLoadManagerCompleted()){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            BeanFlowInvokerFactory factory
                 = (BeanFlowInvokerFactory)ServiceManagerFactory
                    .getServiceObject("BeanFlowInvokerFactory");
            BeanFlowInvoker invoker = null;
            try{
                invoker = factory.createFlow("Test");
                
                // 入力オブジェクトを準備する
                List input = new ArrayList();
                for(int i = 0; i < 10; i++){
                    input.add(new Integer(i));
                }
                
                // フローを実行
                Object output = invoker.invokeFlow(input);
                
                System.out.println("レスポンスが返ってきました。output=" + output);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
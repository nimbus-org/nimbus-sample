
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            BeanFlowInvokerFactory factory
                 = (BeanFlowInvokerFactory)ServiceManagerFactory
                    .getServiceObject("BeanFlowInvokerFactory");
            BeanFlowInvoker invoker = null;
            try{
                // ユーザ一覧作成フローを取得
                invoker = factory.createFlow("Public-CreateUserMap");
                
                // ユーザ一覧作成フローを実行
                invoker.invokeFlow(null);
                
                // ユーザ取得フローを取得
                invoker = factory.createFlow("Public-GetUser");
                
                // ユーザ取得フローを実行
                Map user5 = (Map)invoker.invokeFlow("user5");
                Map user6 = (Map)invoker.invokeFlow("user6");
                System.out.println("名前,年齢,性別");
                System.out.println(user5.get("name")
                    + "," + user5.get("age")
                    + "," + user5.get("sex"));
                System.out.println(user6.get("name")
                    + "," + user6.get("age")
                    + "," + user6.get("sex"));
                
            }catch(Exception e){
                e.printStackTrace();
                e.getCause().printStackTrace();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}

import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvokerFactory;
import jp.ossc.nimbus.service.beancontrol.interfaces.BeanFlowInvoker;

/**
 * サンプル１実行クラス。
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
                // テーブル作成フローを取得
                invoker = factory.createFlow("CreateTable");
                
                // テーブル作成フローを実行
                System.out.println("テーブル作成");
                invoker.invokeFlow(null);
                
                // レコード作成フローを取得
                invoker = factory.createFlow("Insert");
                
                // 入力のレコードを生成
                System.out.println("レコード作成");
                System.out.println("名前,年齢,性別");
                List input = new ArrayList();
                for(int i = 0; i < 11; i++){
                    Map record = new HashMap();
                    record.put("name", "user" + i);
                    record.put("age", new Integer(i + 10));
                    record.put("sex", i % 2 == 0 ? "0" : "1");
                    input.add(record);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // レコード作成フローを実行
                invoker.invokeFlow(input);
                
                // レコード検索フローを取得
                invoker = factory.createFlow("Search");
                
                // レコード検索フローを実行
                // 全検索する
                // 但し、フローにて、5件までしか検索結果を返さない
                List output = (List)invoker.invokeFlow(null);
                System.out.println("全検索（最大５件）");
                System.out.println("名前,年齢,性別");
                for(int i = 0, max = output.size(); i < max; i++){
                    Map record = (Map)output.get(i);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // レコード検索フローを実行
                // 引数で、ユーザ名を検索条件として渡す
                // 検索結果該当あり
                System.out.println("検索 : user10");
                Map record = (Map)invoker.invokeFlow("user10");
                System.out.println(record.get("name")
                    + "," + record.get("age")
                    + "," + record.get("sex"));
                
                // レコード検索フローを実行
                // 引数で、ユーザ名を検索条件として渡す
                // 検索結果該当なし
                System.out.println("検索 : user100");
                record = (Map)invoker.invokeFlow("user100");
                System.out.println(record);
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                // テーブル削除フローを取得
                invoker = factory.createFlow("DropTable");
                try{
                    // テーブル削除フローを実行
                    System.out.println("テーブル削除");
                    invoker.invokeFlow(null);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
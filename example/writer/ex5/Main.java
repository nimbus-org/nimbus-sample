
import java.util.Date;
import java.util.HashMap;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.Category;
import jp.ossc.nimbus.service.writer.MessageWriteException;

/**
 * サンプル５実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Category category = (Category)ServiceManagerFactory
                .getServiceObject("Category");
            
            // 出力情報を生成する
            HashMap map = new HashMap();
            map.put("DATE", new Date());
            map.put("MESSAGE", "テストのメッセージです。");
            
            // フォーマットして出力する
            try{
                category.write(map);
            }catch(MessageWriteException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
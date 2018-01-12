
import jp.ossc.nimbus.core.ServiceManagerFactory;

import sample.service.Caller;

/**
 * サンプル１０実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // アスペクト定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("aspect-definition.xml")){
            System.out.println("アスペクト定義の読み込みに成功しました。");
            
            // サービス定義ファイルをロードする
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("サービス定義の読み込みに成功しました。");
                
                // サービスを取得する
                final Caller service1 = (Caller)ServiceManagerFactory
                    .getServiceObject("Service1");
                
                try{
                    service1.call1();
                }catch(Exception e){
                    System.out.println("例外が発生しました。" + e);
                }
                try{
                    service1.call2();
                }catch(Exception e){
                    System.out.println("例外が発生しました。" + e);
                }
                try{
                    service1.call3();
                }catch(Exception e){
                    System.out.println("例外が発生しました。" + e);
                }
            }else{
                System.out.println("サービス定義の読み込みに失敗しました。");
            }
            
            // サービス定義ファイルをアンロードする
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            System.out.println("アスペクト定義の読み込みに失敗しました。");
        }
        
        // アスペクト定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("aspect-definition.xml");
    }
    
}
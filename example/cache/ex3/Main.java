
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.cache.Cache;
import jp.ossc.nimbus.service.cache.CachedReference;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Cache cache = (Cache)ServiceManagerFactory
                .getServiceObject("Cache");
            
            // キャッシュして、キャッシュ参照をもらう
            System.out.println("キャッシュ追加");
            CachedReference ref1 = cache.add("aaa");
            CachedReference ref2 = cache.add("bbb");
            
            // キャッシュのサイズを確認する
            System.out.println("キャッシュサイズ : " + cache.size());
            
            // キャッシュ参照から値を取り出す
            System.out.println("参照1の値 : " + ref1.get());
            System.out.println("参照2の値 : " + ref2.get());
            
            // キャッシュして、キャッシュ参照をもらう
            System.out.println("キャッシュ追加");
            CachedReference ref3 = cache.add("ccc");
            
            // キャッシュのサイズを確認する
            System.out.println("キャッシュサイズ : " + cache.size());
            
            // キャッシュ参照から値を取り出す
            System.out.println("参照1の値 : " + ref1.get());
            System.out.println("参照2の値 : " + ref2.get());
            System.out.println("参照3の値 : " + ref3.get());
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
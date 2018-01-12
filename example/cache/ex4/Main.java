
import java.util.*;
import java.io.*;

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
            
            Runtime runtime = Runtime.getRuntime();
            
            // キャッシュして、キャッシュ参照をもらう
            System.out.println("キャッシュ追加");
            List refs = new ArrayList();
            for(int i = 0; i < 3100; i++){
                refs.add(cache.add(new byte[10240]));
                
                // メモリの使用量を計算する
                long used = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("ヒープメモリ使用量 : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            }
            
            System.out.println("実行ディレクトリに、キャッシュされたファイルが作成されている事を確認して、Enterキーを押して下さい。");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // メモリの使用量を計算する
            long used = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("ヒープメモリ使用量 : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            
            // GCします
            System.out.println("GCします");
            runtime.gc();
            
            // メモリの使用量を計算する
            used = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("ヒープメモリ使用量 : " + used + "(" + ((double)((double)used / (double)runtime.maxMemory()) * 100) + "%)");
            
            System.out.println("メモリの使用量が減っている事を確認して、Enterキーを押して下さい。");
            try{
                new InputStreamReader(System.in).read();
            }catch(IOException e){
            }
            
            // 一番古いキャッシュを取得する
            // 古いキャッシュは、あふれ制御によってソフト参照になり
            // ファイルに永続化されている。
            // さらに、GCによってソフト参照は、ガベージされているので
            // 永続化されたファイルから復元される
            CachedReference ref = (CachedReference)refs.get(0);
            System.out.println("一番古いキャッシュ : " + ref.get());
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
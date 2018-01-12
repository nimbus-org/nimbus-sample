
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.crypt.Crypt;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Crypt crypt = (Crypt)ServiceManagerFactory
                .getServiceObject("Crypt");
            
            String str = "こんにちは";
            System.out.println("暗号化前の文字列 : " + str);
            
            // ハッシュする
            String hash = crypt.doHash(str);
            System.out.println("ハッシュ後の文字列 : " + hash);
            
            // 暗号化する
            String encode = crypt.doEncode(str);
            System.out.println("暗号化後の文字列 : " + encode);
            
            // 復号化する
            String decode = crypt.doDecode(encode);
            System.out.println("復号化後の文字列 : " + decode);
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
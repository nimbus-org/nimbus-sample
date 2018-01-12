
import jp.ossc.nimbus.core.*;
import jp.ossc.nimbus.beans.dataset.*;
import jp.ossc.nimbus.service.http.*;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-server.xml")
                && ServiceManagerFactory.loadManager("service-client.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final HttpClientFactory factory = (HttpClientFactory)ServiceManagerFactory.getServiceObject("HttpClientFactory");
            
            // クライアントを生成する
            HttpClient client = factory.createHttpClient();
            
            // リクエストを生成
            HttpRequest request = factory.createRequest("login");
            
            // リクエストパラメータを設定
            request.setParameter("name", "hoge");
            request.setParameter("password", "fuga");
            
            // リクエストを送信して、レスポンスを取得する
            HttpResponse response = client.executeRequest(request);
            
            // レスポンスのHTTPステータスをチェックする
            if(response.getStatusCode() == 200){
                
                // レスポンスのXMLをDataSetとして取得する
                DataSet responseDs = (DataSet)response.getObject();
                Header authInfo = responseDs.getHeader("AuthInfo");
                System.out.println(authInfo.toString());
            }else{
                System.out.println("error status : " + response.getStatusCode());
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
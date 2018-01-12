
import java.io.IOException;
import java.io.FileOutputStream;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.http.HttpClientFactory;
import jp.ossc.nimbus.service.http.HttpClient;
import jp.ossc.nimbus.service.http.HttpRequest;
import jp.ossc.nimbus.service.http.HttpResponse;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final HttpClientFactory factory = (HttpClientFactory)ServiceManagerFactory.getServiceObject("HttpClientFactory");
            
            // クライアントを生成する
            final HttpClient client = factory.createHttpClient();
            
            // プロジェクトトップページへのリクエストを生成する
            final HttpRequest projectTopPageRequest
                 = factory.createRequest("ProjectTopPage");
            
            // リクエストをHTTP送信して、レスポンスを取得する
            final HttpResponse projectTopPageResponse
                 = client.executeRequest(projectTopPageRequest);
            
            // レスポンスのHTTPステータスを確認する
            if(projectTopPageResponse.getStatusCode() == 200){
                System.out.println(
                    "Normal status from " + projectTopPageRequest.getURL()
                     + " : " + projectTopPageResponse.getStatusCode()
                );
                
                // レスポンスのHTML文字列を取得して、ファイルに出力する
                final String html = (String)projectTopPageResponse.getObject();
                printFile("ProjectTopPage.html", html);
            }else{
                System.out.println(
                    "Error status from " + projectTopPageRequest.getURL()
                     + " : " + projectTopPageResponse.getStatusCode()
                );
            }
            
            // プロジェクトホームページへのリクエストを生成する
            final HttpRequest projectHomePageRequest
                 = factory.createRequest("ProjectHomePage");
            
            // リクエストをHTTP送信して、レスポンスを取得する
            final HttpResponse projectHomePageResponse
                 = client.executeRequest(projectHomePageRequest);
            
            // レスポンスのHTTPステータスを確認する
            if(projectHomePageResponse.getStatusCode() == 200){
                System.out.println(
                    "Normal status from " + projectHomePageRequest.getURL()
                     + " : " + projectHomePageResponse.getStatusCode()
                );
                
                // レスポンスのHTML文字列を取得して、ファイルに出力する
                final String html = (String)projectHomePageResponse.getObject();
                printFile("ProjectHomePage.html", html);
            }else{
                System.out.println(
                    "Error status from " + projectHomePageRequest.getURL()
                     + " : " + projectHomePageResponse.getStatusCode()
                );
            }
            
            // クライアントを終了する
            client.close();
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static void printFile(String name, String html) throws IOException{
        final FileOutputStream fos = new FileOutputStream(name);
        final byte[] bytes = html.getBytes();
        fos.write(bytes, 0, bytes.length);
        fos.close();
    }
    
}
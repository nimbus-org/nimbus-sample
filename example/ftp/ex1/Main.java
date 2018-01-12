
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.ftp.FTPClientFactory;
import jp.ossc.nimbus.service.ftp.FTPClient;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws IOException{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final FTPClientFactory factory = (FTPClientFactory)ServiceManagerFactory.getServiceObject("FTPClientFactory");
            
            // クライアントを生成する
            final FTPClient client = factory.createFTPClient();
            try{
                // テキストファイルをローカルに作成する
                FileOutputStream fos = new FileOutputStream("put_test.txt");
                fos.write("test".getBytes());
                fos.close();
                
                // FTPサーバ上のファイルの一覧を取得する
                System.out.println("サーバのファイル一覧");
                String[] fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
                
                // FTPサーバにファイルを転送する
                waitInput("サーバにファイルを転送します");
                client.put("put_test.txt", "test.txt");
                System.out.println("サーバにファイルを転送しました");
                
                // FTPサーバ上のファイルの一覧を取得する
                System.out.println("サーバのファイル一覧");
                fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
                
                // FTPサーバからファイルを取得する
                waitInput("サーバからファイルを取得します");
                client.get("test.txt", "get_test.txt");
                System.out.println("サーバからファイルを取得しました");
                
                // FTPサーバ上のファイルを削除する
                waitInput("サーバからファイルを削除します");
                client.delete("test.txt");
                System.out.println("サーバからファイルを削除しました");
                
                // FTPサーバ上のファイルの一覧を取得する
                System.out.println("サーバのファイル一覧");
                fileNames = client.ls();
                for(int i = 0 ; i < fileNames.length; i++){
                    System.out.println(fileNames[i]);
                }
                System.out.println();
            }finally{
                // クライアントを終了する
                client.close();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
    private static final void waitInput(String message) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println(message + " (y/n)");
            final String line = br.readLine();
            if("y".equalsIgnoreCase(line)){
                break;
            }else if("n".equalsIgnoreCase(line)){
                System.exit(0);
            }
        }while(true);
    }
}
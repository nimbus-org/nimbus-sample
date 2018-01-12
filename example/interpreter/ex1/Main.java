
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.StringWriter;
import java.io.PrintWriter;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.interpreter.Interpreter;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Interpreter interpreter = (Interpreter)ServiceManagerFactory
                .getServiceObject("Interpreter");
            
            // インタープリタで実行するサンプルコードを読み込む
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            String line = null;
            while((line = br.readLine()) != null){
                pw.println(line);
            }
            fr.close();
            pw.flush();
            
            // インタープリタに実行させて、結果を標準出力に出力する
            System.out.println(interpreter.evaluate(sw.toString()));
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
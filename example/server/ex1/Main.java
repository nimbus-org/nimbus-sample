
import java.io.*;
import java.net.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.beans.dataset.DataSet;
import jp.ossc.nimbus.util.converter.DataSetJSONConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サーバと接続
        Socket socket = new Socket("localhost", 10000);
        
        // 要求を送信する出力ストリームを取得
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        
        // アクションを出力
        pw.println("Hello");
        
        // 送信するDataSetを生成
        DataSet ds = new DataSet("HelloRequest");
        ds.setHeaderSchema(
            ":name,java.lang.String\n"
             + ":message,java.lang.String"
        );
        ds.getHeader().setProperty("name", "Hoge");
        ds.getHeader().setProperty("message", "Hello!!");
        
        // DataSet⇔JSON変換を行うConverterを生成
        DataSetJSONConverter dsConverter = new DataSetJSONConverter();
        dsConverter.setOutputSchema(false);
        StringStreamConverter strConverter = new StringStreamConverter();
        
        // DataSetをJSONに変換して出力
        pw.print((String)strConverter.convertToObject(dsConverter.convertToStream(ds)));
        pw.flush();
        
        // 応答を受信する入力ストリームを取得
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        // 応答ステータスを読み込む
        int status = dis.readInt();
        System.out.println("response staus=" + status);
        
        // 応答データ長を読み込む
        int length = dis.readInt();
        System.out.println("response length=" + length);
        
        // 正常応答の場合
        if(status == 200){
            // 応答データを読み込む
            byte[] data = new byte[length];
            dis.read(data);
            
            // 受信するDataSetを生成
            DataSet resDs = new DataSet("HelloResponse");
            resDs.setHeaderSchema(
                ":message,java.lang.String"
            );
            
            // 応答データのJSONをDataSetに変換する
            resDs = (DataSet)dsConverter.convertToObject(new ByteArrayInputStream(data), resDs);
            
            System.out.println(ds.getHeader().getProperty("message"));
        }
        // 異常応答の場合
        else{
            System.out.println("Error occurred.");
        }
        
        // サーバと切断
        socket.close();
    }
    
}
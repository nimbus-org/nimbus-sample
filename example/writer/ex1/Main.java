
import java.util.Date;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.writer.MessageWriter;
import jp.ossc.nimbus.service.writer.WritableRecord;
import jp.ossc.nimbus.service.writer.SimpleElement;
import jp.ossc.nimbus.service.writer.DateElement;
import jp.ossc.nimbus.service.writer.MessageWriteException;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            MessageWriter writer = (MessageWriter)ServiceManagerFactory
                .getServiceObject("Writer");
            
            // 出力情報を生成する
            WritableRecord record = new WritableRecord();
            record.addElement(new DateElement(new Date()));
            record.addElement(new SimpleElement(":"));
            record.addElement(new SimpleElement("テストのメッセージです。"));
            
            // 出力する
            try{
                writer.write(record);
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
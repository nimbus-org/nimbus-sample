
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler.Scheduler;
import jp.ossc.nimbus.service.scheduler.Schedule;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Scheduler scheduler = (Scheduler)ServiceManagerFactory
                .getServiceObject("Scheduler");
            
            // スケジューラの起動キーとして、日付オブジェクトを生成する
            Object key = null;
            if(args.length == 1){
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                try{
                    key = format.parse(args[0]);
                }catch(ParseException e){
                    e.printStackTrace();
                    System.exit(-1);
                }
            }else{
                key = new Date();
            }
            
            // スケジュールを取得する
            System.out.println("実行するスケジュール一覧");
            Schedule[] schdules = scheduler.getSchedules(key);
            for(int i = 0; i < schdules.length; i++){
                System.out.println(schdules[i].getName());
            }
            
            // スケジューラを起動する
            System.out.println("スケジュール開始");
            scheduler.startSchedule(key);
            
            // スケジュールが全て終了するまで待機する
            scheduler.waitUntilScheduleClose();
            System.out.println("スケジュール終了");
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
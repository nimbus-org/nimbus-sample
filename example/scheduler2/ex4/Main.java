
import java.io.File;
import java.util.List;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler2.Schedule;
import jp.ossc.nimbus.service.scheduler2.ScheduleManager;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        new File("local/site1").mkdirs();
        new File("local/site2").mkdirs();
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            ScheduleManager scheduleManager = (ScheduleManager)ServiceManagerFactory
                .getServiceObject("ScheduleManager");
            
            // スケジュールが全て終了するまで待機する
            List schedules = null;
            do{
                schedules = scheduleManager.findSchedules(
                    new int[]{
                        Schedule.STATE_INITIAL,
                        Schedule.STATE_ENTRY,
                        Schedule.STATE_RUN,
                        Schedule.STATE_RETRY
                    }
                );
                Thread.sleep(1000);
            }while(schedules.size() != 0);
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
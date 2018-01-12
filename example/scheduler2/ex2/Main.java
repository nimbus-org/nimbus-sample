
import java.util.List;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler2.Schedule;
import jp.ossc.nimbus.service.scheduler2.ScheduleManager;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml") && ServiceManagerFactory.checkLoadManagerCompleted()){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            ScheduleManager scheduleManager = (ScheduleManager)ServiceManagerFactory
                .getServiceObject("ScheduleManager");
            
            // スケジュールが全て終了するまで待機する
            int allCount = scheduleManager.findAllSchedules().size();
            List schedules = null;
            do{
                schedules = scheduleManager.findSchedules(
                    new int[]{
                        Schedule.STATE_END,
                        Schedule.STATE_FAILED
                    }
                );
                Thread.sleep(5000);
            }while(schedules.size() != allCount);
            System.out.println(allCount + "件のスケジュールが終了しました。");
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
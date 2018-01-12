
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.scheduler.Scheduler;
import jp.ossc.nimbus.service.scheduler.TimerSchedule;

/**
 * サンプル４実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            Scheduler scheduler = (Scheduler)ServiceManagerFactory
                .getServiceObject("Scheduler");
            
            // スケジュールが全て終了するまで最大20秒間待機する
            scheduler.waitUntilScheduleClose(20000);
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
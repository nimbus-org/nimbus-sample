
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.system.OperationSystem;
import jp.ossc.nimbus.service.system.CpuTimes;
import jp.ossc.nimbus.service.system.MemoryInfo;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            OperationSystem os = (OperationSystem)ServiceManagerFactory
                    .getServiceObject("OperationSystem");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            DecimalFormat numFormat = new DecimalFormat("0.0");
            System.out.println("time,user,system,idle,physical,swap");
            StringBuffer buf = new StringBuffer();
            for(int i = 0; i < 10; i++){
                Thread.sleep(1000);
                
                // CPU使用量の情報を取得する
                CpuTimes cpu = os.getCpuTimesDelta();
                
                // 物理メモリ使用量の情報を取得する
                MemoryInfo physicalMemory = os.getPhysicalMemoryInfo();
                
                // 仮想メモリ使用量の情報を取得する
                MemoryInfo swapMemory = os.getSwapMemoryInfo();
                
                buf.setLength(0);
                buf.append(dateFormat.format(new Date()));
                buf.append(',');
                buf.append(numFormat.format(cpu.getUserRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format(cpu.getSystemRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format(cpu.getIdleRate() * 100.0));
                buf.append(',');
                buf.append(numFormat.format((double)physicalMemory.getUsedBytes() / (double)physicalMemory.getTotalBytes() * 100.0));
                buf.append(',');
                buf.append(numFormat.format((double)swapMemory.getUsedBytes() / (double)swapMemory.getTotalBytes() * 100.0));
                
                System.out.println(buf.toString());
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
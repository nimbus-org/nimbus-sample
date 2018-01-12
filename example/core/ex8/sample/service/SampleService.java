package sample.service;

import jp.ossc.nimbus.core.ServiceBase;

/**
 * サンプルサービス。<p>
 */
public class SampleService extends ServiceBase implements Runnable{
    
    private boolean isRunning;
    private Thread thread;
    
    public void startService() throws Exception{
       isRunning = true;
       thread = new Thread(this);
       thread.start();
    }
    
    public void stopService() throws Exception{
       isRunning = false;
       thread.join();
    }
    
    public void run(){
        while(isRunning){
            getLogger().write("INFO", "動いてます。");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                break;
            }
        }
    }
}
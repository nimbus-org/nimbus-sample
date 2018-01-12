package sample.handler;

import jp.ossc.nimbus.service.queue.QueueHandler;

/**
 * サンプルQueueHandlerクラス。
 */
public class SampleQueueHandler implements QueueHandler{
    
    public void handleDequeuedObject(Object obj) throws Throwable{
        if(obj == null){
            return;
        }
        System.out.println(Thread.currentThread().getName() + " : " + obj);
        try{
            Thread.sleep(1200);
        }catch(InterruptedException e){
        }
    }
    
    public boolean handleError(Object obj, Throwable th) throws Throwable{
        return true;
    }
    
    public void handleRetryOver(Object obj, Throwable th) throws Throwable{
    }
}
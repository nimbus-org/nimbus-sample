package sample.service;

import jp.ossc.nimbus.core.ServiceBase;

/**
 * サンプルサービス。<p>
 */
public class SampleService extends ServiceBase{
    
    private String message;
    
    public SampleService(){
    }
    
    public SampleService(String msg){
        message = msg;
    }
    
    public void setMessage(String val){
        message = val;
    }
    
    public void printMessage(){
        System.out.println("メッセージ：" + message);
    }
}
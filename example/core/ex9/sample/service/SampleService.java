package sample.service;

import jp.ossc.nimbus.core.ServiceBase;

/**
 * �T���v���T�[�r�X�B<p>
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
        System.out.println("���b�Z�[�W�F" + message);
    }
}
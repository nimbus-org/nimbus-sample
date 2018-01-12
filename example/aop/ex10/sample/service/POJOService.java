package sample.service;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * サンプルサービス。<p>
 */
public class POJOService implements Caller{
    
    public String call1() throws Exception{
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : call1()");
        return "normal";
    }
    
    public String call2() throws Exception{
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : call2()");
        throw new Exception("Not retry");
    }
    
    public String call3() throws Exception{
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " : call3()");
        throw new Exception("Retry");
    }
}
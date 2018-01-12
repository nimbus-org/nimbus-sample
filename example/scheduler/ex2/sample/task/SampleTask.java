package sample.task;

import java.util.Date;
import java.text.SimpleDateFormat;

import jp.ossc.nimbus.service.scheduler.ScheduleTask;

/**
 * サンプルタスク。<p>
 */
public class SampleTask implements ScheduleTask{
    
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void run() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()) + " : " + name);
    }
}
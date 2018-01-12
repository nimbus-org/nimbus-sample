package sample.service;

import java.util.*;
import javax.imageio.ImageWriter;

/**
 * POJOサービス。<p>
 */
public class POJOService{
    
    private String message;
    
    private int intValue;
    
    public boolean isPrint;
    
    public Map map;
    
    private List list = new ArrayList();
    
    private Calendar calendar;
    
    private ImageWriter imageWriter;
    
    public POJOService(){
    }
    
    public POJOService(String msg){
        message = msg;
    }
    
    public void setIntValue(int val){
        intValue = val;
    }
    
    public int getIntValue(){
        return intValue;
    }
    
    public void setMapValue(String key, String val){
        map.put(key, val);
    }
    
    public void setIndexValue(int index, Object val){
        if(index >= list.size()){
            for(int i = 0, max = index - list.size() + 1; i < max; i++){
                list.add(null);
            }
        }
        list.set(index, val);
    }
    
    public Object getIndexValue(int index){
        return list.get(index);
    }
    
    public void setCalendar(Calendar cal){
        calendar = cal;
    }
    
    public Calendar getCalendar(){
        return calendar;
    }
    
    public void setImageWriter(ImageWriter iw){
        imageWriter = iw;
    }
    
    public ImageWriter getImageWriter(){
        return imageWriter;
    }
    
    public void printMessage(){
        if(isPrint){
            System.out.println("メッセージ：" + message);
        }
    }
    
    public void printMap(){
        if(isPrint){
            System.out.println("マップ：" + map);
        }
    }
    
    public void printMap(Map map){
        if(isPrint){
            System.out.println("マップ：" + map);
        }
    }
    
    public void printIndex(){
        if(isPrint){
            System.out.println("リスト：" + list);
        }
    }
    
    public void printArray(Object[] array){
        if(isPrint){
            for(int i = 0; i < array.length; i++){
                System.out.println("配列[" + i + "]：" + array[i]);
            }
        }
    }
}
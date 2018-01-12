package sample;

import java.util.*;

public class Employee{
    private String partCode;
    private String sectionCode;
    private String no;
    private String name;
    private List family = new ArrayList();
    
    public String getPartCode(){
        return partCode;
    }
    public void setPartCode(String code){
        partCode = code;
    }
    
    public String getSectionCode(){
        return sectionCode;
    }
    public void setSectionCode(String code){
        sectionCode =code;
    }
    
    public String getNo(){
        return no;
    }
    public void setNo(String no){
        this.no = no;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public void addFamily(Family family){
        this.family.add(family);
        family.setEmployee(this);
    }
    
    public List getFamily(){
        return family;
    }
    
    public String toString(){
        final StringBuffer buf = new StringBuffer(super.toString());
        buf.append('{');
        buf.append(partCode).append(',');
        buf.append(sectionCode).append(',');
        buf.append(no).append(',');
        buf.append(name);
        buf.append('}');
        return buf.toString();
    }
}

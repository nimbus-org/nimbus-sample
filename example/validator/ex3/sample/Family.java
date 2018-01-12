package sample;

public class Family{
    private Employee employee;
    private String name;
    
    public Family(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    
    public Employee getEmployee(){
        return employee;
    }
    
    public String toString(){
        final StringBuffer buf = new StringBuffer(super.toString());
        buf.append('{');
        buf.append(name).append(',');
        buf.append(employee);
        buf.append('}');
        return buf.toString();
    }
}

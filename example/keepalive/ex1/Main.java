import jp.ossc.nimbus.core.*;
import jp.ossc.nimbus.service.keepalive.*;
import jp.ossc.nimbus.service.context.*;

public class Main{
    public static void main(String[] args) throws Exception{
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            ClusterService cluster = (ClusterService)ServiceManagerFactory.getServiceObject("Cluster");
            
            while(true){
                Thread.sleep(5000);
            }
        }
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
}
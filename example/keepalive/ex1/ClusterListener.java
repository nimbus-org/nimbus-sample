
import java.util.*;

public class ClusterListener implements jp.ossc.nimbus.service.keepalive.ClusterListener{
    
    public void memberInit(Object myId, List members){
        System.out.println("自分のID " + myId);
        System.out.println("クラスタ参加時のメンバ " + members);
    }
    public void memberChange(List oldMembers, List newMembers){
        System.out.println("クラスタメンバ変更 " + oldMembers + " > " + newMembers);
    }
    public void changeMain() throws Exception{
        System.out.println("クラスタの主系になりました。");
    }
    public void changeSub(){
        System.out.println("クラスタの副系になりました。!");
    }
}
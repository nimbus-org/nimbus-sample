
import java.util.*;

public class ClusterListener implements jp.ossc.nimbus.service.keepalive.ClusterListener{
    
    public void memberInit(Object myId, List members){
        System.out.println("������ID " + myId);
        System.out.println("�N���X�^�Q�����̃����o " + members);
    }
    public void memberChange(List oldMembers, List newMembers){
        System.out.println("�N���X�^�����o�ύX " + oldMembers + " > " + newMembers);
    }
    public void changeMain() throws Exception{
        System.out.println("�N���X�^�̎�n�ɂȂ�܂����B");
    }
    public void changeSub(){
        System.out.println("�N���X�^�̕��n�ɂȂ�܂����B!");
    }
}
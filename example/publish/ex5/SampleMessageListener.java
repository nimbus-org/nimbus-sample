
import jp.ossc.nimbus.service.publish.Message;
import jp.ossc.nimbus.service.publish.MessageListener;
import jp.ossc.nimbus.service.publish.MessageException;

/**
 * �T���v��MessageListener�N���X�B
 */
public class SampleMessageListener implements MessageListener{
    public void onMessage(Message message){
        try{
            System.out.println(message.getObject());
        }catch(MessageException e){
            e.printStackTrace();
        }
    }
}
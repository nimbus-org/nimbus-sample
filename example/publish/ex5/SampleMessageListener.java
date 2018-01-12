
import jp.ossc.nimbus.service.publish.Message;
import jp.ossc.nimbus.service.publish.MessageListener;
import jp.ossc.nimbus.service.publish.MessageException;

/**
 * サンプルMessageListenerクラス。
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
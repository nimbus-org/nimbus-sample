package jp.ossc.nimbus.service.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

import jp.ossc.nimbus.core.Service;

public class SampleMessageHandlerFactoryService extends AbstractMessageHandlerFactoryService
        implements SampleMessageHandlerFactoryServiceMBean {

    protected Set sessionSet;

    public void createService() throws Exception {
        sessionSet = new HashSet();
    }

    protected Service createServiceInstance() throws Exception {
        return new SampleMessageHandlerService();
    }

    public void sendMessage(String message) {
        Iterator itr = sessionSet.iterator();
        while(itr.hasNext()) {
            Session session = (Session)itr.next();
            if(session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class SampleMessageHandlerService extends AbstractMessageHandlerService {

        @Override
        protected void onOpenProcess(Session session, EndpointConfig config) {
            if(!sessionSet.contains(session)) {
                sessionSet.add(session);
            }
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            String message = "open session id=" + prop.getId() + " sessionId=" + session.getId();
            // メンバーが増えたことを全員に通知
            sendMessage(message);
        }

        @Override
        protected void onCloseProcess(Session session, CloseReason closeReason) {
            if(sessionSet.contains(session)) {
                sessionSet.remove(session);
            }
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            String message = "close session id=" + prop.getId() + " sessionId=" + session.getId();
            // メンバーが減ったことを全員に通知
            sendMessage(message);
        }

        @Override
        protected void onErrorProcess(Session session, Throwable thr) {
            thr.printStackTrace();
        }

        @Override
        protected void onMessageProcess(String message) {
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            message = "message recieve from session id=" + prop.getId() + " sessionId=" + session.getId() + " message is \"" + message + "\"";
            // 受信したメッセージを全員に通知
            sendMessage(message);
        }

    }
}

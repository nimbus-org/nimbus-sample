package jp.ossc.nimbus.service.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

import jp.ossc.nimbus.core.Service;
import jp.ossc.nimbus.util.converter.BeanJSONConverter;
import jp.ossc.nimbus.util.converter.StringStreamConverter;

public class SampleMessageHandlerFactoryService extends AbstractMessageHandlerFactoryService
        implements SampleMessageHandlerFactoryServiceMBean {

    protected Set sessionSet;
    protected BeanJSONConverter beanJsonConverter;
    protected StringStreamConverter stringStreamConverter;

    public void createService() throws Exception {
        sessionSet = new HashSet();
        beanJsonConverter = new BeanJSONConverter();
        stringStreamConverter = new StringStreamConverter();
    }

    protected Service createServiceInstance() throws Exception {
        return new SampleMessageHandlerService();
    }

    public void sendMessage(String message, String taegetUserId) {
        Iterator itr = sessionSet.iterator();
        while(itr.hasNext()) {
            Session session = (Session)itr.next();
            if(session.isOpen() && (taegetUserId == null || session.getId().equals(taegetUserId))) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private String getSessionUsers(){
        List list = new ArrayList();
        Iterator itr = sessionSet.iterator();
        while(itr.hasNext()){
            Session session = (Session)itr.next();
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            Map map = new HashMap();
            map.put("userId", prop.getId());
            map.put("sessionId", session.getId());
            list.add(map);
        }
        Map map = new HashMap();
        map.put("allsessions", list);
        return (String)stringStreamConverter.convertToObject(beanJsonConverter.convertToStream(map));
    }

    public class SampleMessageHandlerService extends AbstractMessageHandlerService {

        @Override
        protected void onOpenProcess(Session session, EndpointConfig config) {
            if(!sessionSet.contains(session)) {
                sessionSet.add(session);
            }
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            String message = "open session id=" + prop.getId() + " sessionId=" + session.getId() + " " + getSessionUsers();
            // メンバーが増えたことを全員に通知
            sendMessage(message, null);
        }

        @Override
        protected void onCloseProcess(Session session, CloseReason closeReason) {
            if(sessionSet.contains(session)) {
                sessionSet.remove(session);
            }
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            String message = "close session id=" + prop.getId() + " sessionId=" + session.getId() + " " + getSessionUsers();
            // メンバーが減ったことを全員に通知
            sendMessage(message, null);
        }

        @Override
        protected void onErrorProcess(Session session, Throwable thr) {
            thr.printStackTrace();
        }

        @Override
        protected void onMessageProcess(String message) {
            String targetUserId = null;
            if(message.indexOf("@") != -1){
                String paramUserId = message.substring(0, message.indexOf("@"));
                if(!"ALL".equals(paramUserId)){
                    targetUserId = paramUserId;
                }
                message = message.substring(message.indexOf("@") + 1);
            }
            SessionProperties prop = SessionProperties.getSessionProperty(session);
            message = "message recieve from session id=" + prop.getId() + " sessionId=" + session.getId() + " message is \"" + message + "\"";
            // 受信したメッセージを全員に通知
            sendMessage(message, targetUserId);
        }

    }
}

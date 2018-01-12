
import java.io.*;

import jp.ossc.nimbus.service.io.Externalizer;
import jp.ossc.nimbus.service.publish.MessageException;
import jp.ossc.nimbus.service.publish.tcp.*;

public class MyExternalizer implements Externalizer{
    
    public void writeExternal(Object obj, OutputStream out) throws IOException{
        MessageImpl message = (MessageImpl)obj;
        DataOutputStream dos = new DataOutputStream(out);
        String str = null;
        if(message.isServerClose()){
            str = "BYE";
        }else{
            try{
                str = message.getSubject() + "," + message.getKey() + "," + message.getObject().toString();
            }catch(MessageException e){
                throw new IOException(e.toString());
            }
        }
        dos.writeInt(str.length());
        byte[] bytes = str.getBytes();
        dos.write(bytes, 0, bytes.length);
        dos.flush();
    }
    
    public void writeExternal(Object obj, ObjectOutput out) throws IOException{
        throw new UnsupportedOperationException();
    }
    
    public Object readExternal(InputStream in) throws IOException, ClassNotFoundException{
        DataInputStream dis = new DataInputStream(in);
        int length = dis.readInt();
        ClientMessage cm = null;
        if(length > 0){
            byte[] bytes = new byte[length];
            dis.readFully(bytes);
            String str = new String(bytes);
            String[] params = str.split(",");
            if("ADD".equals(params[0])){
                String subject = params[1];
                String[] keys = null;
                if(params.length > 2){
                    keys = new String[params.length - 2];
                    System.arraycopy(params, 2, keys, 0, keys.length);
                }
                cm = new AddMessage(subject, keys);
            }else if("DEL".equals(params[0])){
                String subject = params[1];
                String[] keys = null;
                if(params.length > 2){
                    keys = new String[params.length - 2];
                    System.arraycopy(params, 2, keys, 0, keys.length);
                }
                cm = new RemoveMessage(subject, keys);
            }else if("START".equals(params[0])){
                cm = new StartReceiveMessage();
            }else if("STOP".equals(params[0])){
                cm = new StopReceiveMessage();
            }else if("BYE".equals(params[0])){
                cm = new ByeMessage();
            }else{
                throw new IOException("Illegal message." + str);
            }
            return cm;
        }else{
            throw new EOFException();
        }
    }
    
    public Object readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        throw new UnsupportedOperationException();
    }
}
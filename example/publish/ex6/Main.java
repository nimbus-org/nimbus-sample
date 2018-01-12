
import java.io.*;
import java.net.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.publish.ServerConnectionFactory;
import jp.ossc.nimbus.service.publish.ServerConnection;
import jp.ossc.nimbus.service.publish.Message;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        if(args != null && args.length != 0 && "server".equals(args[0])){
            
            // �T�[�r�X��`�t�@�C�������[�h����
            if(ServiceManagerFactory.loadManager("service-definition.xml")){
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
                
                System.out.println("�N���C�A���g���N��������A���M���郁�b�Z�[�W����͂��ĉ������B");
                System.out.println("���̓t�H�[�}�b�g�F�T�u�W�F�N�g,�L�[,���b�Z�[�W");
                
                // �T�[�r�X���擾����
                ServerConnectionFactory factory
                     = (ServerConnectionFactory)ServiceManagerFactory
                        .getServiceObject("ConnectionFactory");
                try{
                    // �T�[�o�R�l�N�V�������擾
                    ServerConnection connection = factory.getServerConnection();
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String line = null;
                    while((line = br.readLine()) != null){
                        String[] params = line.split(",");
                        if(params.length == 3){
                            // ���b�Z�[�W�𐶐�
                            Message message = connection.createMessage(params[0], params[1]);
                            message.setObject(params[2]);
                            
                            // ���b�Z�[�W�𑗐M
                            connection.send(message);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("�T�[�r�X��`�̓ǂݍ��݂Ɏ��s���܂����B");
            }
            
            // �T�[�r�X��`�t�@�C�����A�����[�h����
            ServiceManagerFactory.unloadManager("service-definition.xml");
        }else{
            try{
                final Socket socket = new Socket(InetAddress.getLocalHost(), 10000);
                Thread readThread = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                InputStream is = socket.getInputStream();
                                DataInputStream dis = new DataInputStream(is);
                                int length = 0;
                                while((length = dis.readInt()) > 0){
                                    byte[] bytes = new byte[length];
                                    dis.readFully(bytes);
                                    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                                    DataInputStream dis2 = new DataInputStream(bais);
                                    int length2 = dis2.readInt();
                                    byte[] bytes2 = new byte[length2];
                                    dis2.readFully(bytes2);
                                    String message = new String(bytes2);
                                    if("BYE".equals(message)){
                                        socket.close();
                                        System.out.println("�T�[�o����~���܂����B");
                                        System.exit(0);
                                    }
                                    System.out.println(message);
                                }
                            }catch(SocketException e){
                            }catch(EOFException e){
                                System.out.println("�T�[�o����~���܂����B");
                                System.exit(0);
                            }catch(Exception e){
                                e.printStackTrace();
                                System.exit(-1);
                            }
                        }
                    }
                );
                readThread.setDaemon(true);
                readThread.start();
                
                System.out.println("��M�o�^�FADD,�T�u�W�F�N�g,�L�[1,�L�[2,....");
                System.out.println("��M�����FDEL,�T�u�W�F�N�g,�L�[1,�L�[2,....");
                System.out.println("��M�J�n�FSTART");
                System.out.println("��M��~�FSTOP");
                System.out.println("�ؒf    �FBYE");
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                while((line = br.readLine()) != null){
                    if(line.length() != 0){
                        dos.writeInt(line.length() + 4);
                        dos.writeInt(line.length());
                        byte[] bytes = line.getBytes();
                        dos.write(bytes, 0, bytes.length);
                        dos.flush();
                        if("BYE".equals(line)){
                            socket.close();
                            break;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}

import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.DistributedSharedContext;
import jp.ossc.nimbus.service.context.DistributedSharedContextService;
import jp.ossc.nimbus.service.context.SharedContextTimeoutException;

/**
 * �T���v���U���s�N���X�B
 */
public class Main{
    
    public static final void main(String[] args){
        
        // �T�[�r�X��`�t�@�C�������[�h����
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("�T�[�r�X��`�̓ǂݍ��݂ɐ������܂����B");
            
            System.out.println("�N���C�A���g���N��������A���M���郁�b�Z�[�W����͂��ĉ������B");
            
            // �T�[�r�X���擾����
            DistributedSharedContext context = (DistributedSharedContext)ServiceManagerFactory.getServiceObject("Context");
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while((line = br.readLine()) != null){
                    
                    if(line.startsWith("put ")){
                        String keyValuePair = line.substring(4).trim();
                        String[] pair = keyValuePair.split(" ");
                        if(pair.length >= 2){
                            context.put(pair[0], pair[1]);
                        }
                    }else if(line.startsWith("get ")){
                        String key = line.substring(4).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 2){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[1]);
                            }catch(NumberFormatException e){}
                            System.out.println("get : " + context.get(pair[0], timeout));
                        }else if(key.length() != 0){
                            System.out.println("get : " + context.get(key));
                        }
                    }else if(line.startsWith("lock ")){
                        String key = line.substring(5).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 2){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[1]);
                            }catch(NumberFormatException e){}
                            try{
                                context.lock(pair[0], timeout);
                                System.out.println("lock : " + pair[0]);
                            }catch(SharedContextTimeoutException e){
                                System.out.println("lock timeout!!");
                            }
                        }else if(key.length() != 0){
                            context.lock(key);
                            System.out.println("lock : " + key);
                        }
                    }else if(line.startsWith("unlock ")){
                        String key = line.substring(7).trim();
                        if(key.length() != 0){
                            if(context.unlock(key)){
                                System.out.println("unlock : " + key);
                            }else{
                                System.out.println("can not unlock : " + key);
                            }
                        }
                    }else if(line.startsWith("lockOwner ")){
                        String key = line.substring(10).trim();
                        if(key.length() != 0){
                            System.out.println("lockOwner : " + context.getLockOwner(key));
                        }
                    }else if(line.startsWith("client ")){
                        String key = line.substring(6).trim();
                        if(key.length() != 0){
                            int index = 0;
                            try{
                                index = Integer.parseInt(key);
                            }catch(NumberFormatException e){}
                            System.out.println("client : " + context.isClient(index));
                        }
                    }else if(line.startsWith("main ")){
                        String key = line.substring(4).trim();
                        if(key.length() != 0){
                            int index = 0;
                            try{
                                index = Integer.parseInt(key);
                            }catch(NumberFormatException e){}
                            System.out.println("main : " + context.isMain(index));
                        }
                    }else if(line.startsWith("id")){
                        System.out.println("id : " + context.getId());
                    }else if(line.startsWith("mainId")){
                        System.out.println("main id : " + context.getMainId());
                    }else if(line.startsWith("dist")){
                        System.out.println(((DistributedSharedContextService)context).displayDistributeInfo());
                    }else if(line.startsWith("remove ")){
                        String key = line.substring(7).trim();
                        if(key.length() != 0){
                            System.out.println("removed : " + context.remove(key));
                        }
                    }else if(line.startsWith("clear")){
                        context.clear();
                    }else if(line.startsWith("size")){
                        String key = line.substring(4).trim();
                        if(key.length() > 0){
                            int index = 0;
                            try{
                                index = Integer.parseInt(key);
                            }catch(NumberFormatException e){}
                            System.out.println("size : " + context.size(index));
                        }else{
                            System.out.println("size : " + context.size());
                        }
                    }else if(line.startsWith("keySet")){
                        String key = line.substring(6).trim();
                        if(key.length() > 0){
                            int index = 0;
                            try{
                                index = Integer.parseInt(key);
                            }catch(NumberFormatException e){}
                            System.out.println("keySet : " + context.keySet(index));
                        }else{
                            System.out.println("keySet : " + context.keySet());
                        }
                    }else if(line.startsWith("exit")){
                        break;
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
        System.exit(0);
    }
    
}
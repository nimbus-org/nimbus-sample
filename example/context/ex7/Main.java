
import java.io.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.context.SharedContext;
import jp.ossc.nimbus.service.context.SharedContextTransactionManager;
import jp.ossc.nimbus.service.context.SharedContextTimeoutException;

/**
 * サンプル７実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            System.out.println("クライアントが起動したら、送信するメッセージを入力して下さい。");
            
            // サービスを取得する
            SharedContextTransactionManager transactionManager = (SharedContextTransactionManager)ServiceManagerFactory.getServiceObject("SharedContextTransactionManager");
            SharedContext context1 = (SharedContext)ServiceManagerFactory.getServiceObject("Context1");
            SharedContext context2 = (SharedContext)ServiceManagerFactory.getServiceObject("Context2");
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while((line = br.readLine()) != null){
                    
                    if(line.startsWith("begin")){
                        transactionManager.begin();
                    }else if(line.startsWith("commit")){
                        transactionManager.commit();
                    }else if(line.startsWith("rollback")){
                        transactionManager.rollback();
                    }else if(line.startsWith("put ")){
                        String keyValuePair = line.substring(4).trim();
                        String[] pair = keyValuePair.split(" ");
                        if(pair.length >= 4){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[3]);
                            }catch(NumberFormatException e){}
                            if(pair[0].equals("1")){
                                context1.put(pair[1], pair[2], timeout);
                            }else{
                                context2.put(pair[1], pair[2], timeout);
                            }
                        }else if(pair.length >= 3){
                            if(pair[0].equals("1")){
                                context1.put(pair[1], pair[2]);
                            }else{
                                context2.put(pair[1], pair[2]);
                            }
                        }
                    }else if(line.startsWith("get ")){
                        String key = line.substring(4).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 3){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[2]);
                            }catch(NumberFormatException e){}
                            if(pair[0].equals("1")){
                                System.out.println("get : " + context1.get(pair[1], timeout));
                            }else{
                                System.out.println("get : " + context2.get(pair[1], timeout));
                            }
                        }else if(pair[1].length() != 1){
                            if(pair[0].equals("1")){
                                System.out.println("get : " + context1.get(pair[1]));
                            }else{
                                System.out.println("get : " + context2.get(pair[1]));
                            }
                        }
                    }else if(line.startsWith("lock ")){
                        String key = line.substring(5).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 3){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[2]);
                            }catch(NumberFormatException e){}
                            try{
                                if(pair[0].equals("1")){
                                    context1.lock(pair[1], timeout);
                                }else{
                                    context2.lock(pair[1], timeout);
                                }
                                System.out.println("lock : " + pair[1]);
                            }catch(SharedContextTimeoutException e){
                                System.out.println("lock timeout!!");
                            }
                        }else if(pair[1].length() != 0){
                            if(pair[0].equals("1")){
                                context1.lock(pair[1]);
                            }else{
                                context2.lock(pair[1]);
                            }
                            System.out.println("lock : " + key);
                        }
                    }else if(line.startsWith("unlock ")){
                        String key = line.substring(7).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 2){
                            if(pair[1].length() != 0){
                                boolean unlocked = false;
                                if(pair[0].equals("1")){
                                    unlocked = context1.unlock(pair[1]);
                                }else{
                                    unlocked = context2.unlock(pair[1]);
                                }
                                if(unlocked){
                                    System.out.println("unlock : " + pair[1]);
                                }else{
                                    System.out.println("can not unlock : " + pair[1]);
                                }
                            }
                        }
                    }else if(line.startsWith("lockOwner ")){
                        String key = line.substring(10).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 2){
                            if(pair[1].length() != 0){
                                if(pair[0].equals("1")){
                                    System.out.println("lockOwner : " + context1.getLockOwner(pair[1]));
                                }else{
                                    System.out.println("lockOwner : " + context2.getLockOwner(pair[1]));
                                }
                            }
                        }
                    }else if(line.startsWith("id ")){
                        String contextKey = line.substring(3).trim();
                        if(contextKey.equals("1")){
                            System.out.println("id : " + context1.getId());
                        }else{
                            System.out.println("id : " + context1.getId());
                        }
                    }else if(line.startsWith("mainId ")){
                        String contextKey = line.substring(7).trim();
                        if(contextKey.equals("1")){
                            System.out.println("main id : " + context1.getMainId());
                        }else{
                            System.out.println("main id : " + context2.getMainId());
                        }
                    }else if(line.startsWith("remove ")){
                        String key = line.substring(7).trim();
                        String[] pair = key.split(" ");
                        if(pair.length >= 3){
                            long timeout = -1l;
                            try{
                                timeout = Long.parseLong(pair[2]);
                            }catch(NumberFormatException e){}
                            if(pair[1].length() != 0){
                                if(pair[0].equals("1")){
                                    System.out.println("removed : " + context1.remove(pair[1], timeout));
                                }else{
                                    System.out.println("removed : " + context2.remove(pair[1], timeout));
                                }
                            }
                        }else if(pair.length >= 2){
                            if(pair[1].length() != 0){
                                if(pair[0].equals("1")){
                                    System.out.println("removed : " + context1.remove(pair[1]));
                                }else{
                                    System.out.println("removed : " + context2.remove(pair[1]));
                                }
                            }
                        }
                    }else if(line.startsWith("clear ")){
                        String contextKey = line.substring(6).trim();
                        if(contextKey.equals("1")){
                            context1.clear();
                        }else{
                            context2.clear();
                        }
                    }else if(line.startsWith("size ")){
                        String contextKey = line.substring(5).trim();
                        if(contextKey.equals("1")){
                            System.out.println("size : " + context1.size());
                        }else{
                            System.out.println("size : " + context2.size());
                        }
                    }else if(line.startsWith("keySet ")){
                        String contextKey = line.substring(7).trim();
                        if(contextKey.equals("1")){
                            System.out.println("keySet : " + context1.keySet());
                        }else{
                            System.out.println("keySet : " + context2.keySet());
                        }
                    }else if(line.startsWith("values ")){
                        String contextKey = line.substring(7).trim();
                        if(contextKey.equals("1")){
                            System.out.println("values : " + context1.values());
                        }else{
                            System.out.println("values : " + context2.values());
                        }
                    }else if(line.startsWith("exit")){
                        break;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
        System.exit(0);
    }
    
}
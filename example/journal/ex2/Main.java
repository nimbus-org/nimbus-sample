
import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.service.journal.Journal;

/**
 * サンプル２実行クラス。
 */
public class Main{
    
    public static final void main(String[] args){
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            final Journal journal = (Journal)ServiceManagerFactory
                .getServiceObject("Journal");
            
            // ジャーナルを出力するスレッドを作成する
            Runnable runnable = new Runnable(){
                public void run(){
                    try{
                        // ジャーナルを開始する
                        journal.startJournal(Thread.currentThread().getName());
                        
                        // ジャーナルにジャーナル情報を追加する
                        journal.addInfo("INT", new Integer(1));
                        journal.addInfo("ARRAY", new String[]{"A", "B", "C"});
                        
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException e){
                        }
                        
                        try{
                            // ジャーナルステップを開始する
                            // 入れ子にしたい場合に、ステップを使用する
                            journal.addStartStep("Step1");
                            
                            try{
                                Thread.sleep(200);
                            }catch(InterruptedException e){
                            }
                            
                            // ジャーナルステップにジャーナル情報を追加する
                            journal.addInfo("STRING", "D");
                        }finally{
                            // ジャーナルステップを終了する
                            // ステップの終了は、開始(addStartStep())と
                            // 対になって必ず呼ばなければならない
                            // そのため、try～finally節を使って、
                            // 必ず対で呼び出しましょう。
                            journal.addEndStep();
                        }
                        
                    }finally{
                        
                        // ジャーナルを終了する
                        // ジャーナルの終了は、開始(startJournal())と
                        // 対になって必ず呼ばなければならない
                        // そのため、try～finally節を使って、
                        // 必ず対で呼び出しましょう。
                        journal.endJournal();
                    }
                }
            };
            Thread thread1 = new Thread(runnable, "JournalThread1");
            Thread thread2 = new Thread(runnable, "JournalThread2");
            
            // スレッドを開始する
            thread1.start();
            thread2.start();
            
            // スレッドの終了を待機する
            try{
                thread1.join();
                thread2.join();
            }catch(InterruptedException e){
            }
            
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
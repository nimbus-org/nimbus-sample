
import java.util.*;

import jp.ossc.nimbus.core.ServiceManagerFactory;
import jp.ossc.nimbus.ioc.FacadeValueAccess;
import jp.ossc.nimbus.ioc.FacadeValue;
import jp.ossc.nimbus.ioc.UnitOfWork;
import jp.ossc.nimbus.ioc.CommandBase;
import jp.ossc.nimbus.ioc.Command;
import jp.ossc.nimbus.service.ioccall.FacadeCaller;

/**
 * サンプル１実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Throwable{
        
        // サービス定義ファイルをロードする
        if(ServiceManagerFactory.loadManager("service-definition.xml")){
            System.out.println("サービス定義の読み込みに成功しました。");
            
            // サービスを取得する
            FacadeCaller caller = (FacadeCaller)ServiceManagerFactory
                    .getServiceObject("IOCFacadeCaller");
            try{
                // テーブル作成及びレコード追加を同一トランザクションで
                // 実行するために、複数コマンドを格納するUnitOfWorkを生成する
                UnitOfWork createAndInsertUOW
                     = FacadeValueAccess.createUnitOfWork();
                
                // テーブル作成コマンドを生成する
                Command createCommand
                     = FacadeValueAccess.createCommand("CreateTable", null);
                // テーブル作成コマンドをUnitOfWorkに追加する
                createAndInsertUOW.addCommand(createCommand);
                
                // 入力のレコードを生成
                System.out.println("レコード作成");
                System.out.println("名前,年齢,性別");
                List input = new ArrayList();
                for(int i = 0; i < 11; i++){
                    Map record = new HashMap();
                    record.put("name", "user" + i);
                    record.put("age", new Integer(i + 10));
                    record.put("sex", i % 2 == 0 ? "0" : "1");
                    input.add(record);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // レコード追加コマンドを生成する
                Command insertCommand
                     = FacadeValueAccess.createCommand("Insert", input);
                // レコード追加コマンドをUnitOfWorkに追加する
                createAndInsertUOW.addCommand(insertCommand);
                
                // テーブル作成及びレコード追加を同一トランザクションで実行する
                UnitOfWork resultUOW
                     = caller.syncUnitOfWorkCall(createAndInsertUOW);
                
                // 実行結果が成功しているか確認する
                if(resultUOW.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("テーブル作成及びレコード追加トランザクション失敗 : " + resultUOW.getStatus());
                    
                    // 例外が発生しているか確認する
                    if(resultUOW.getExceptionCount() != 0){
                        throw resultUOW.getExceptions()[0];
                    }
                    return;
                }
                
                // レコード検索コマンドを実行
                // 全検索する
                // 但し、フローにて、5件までしか検索結果を返さない
                
                // レコード検索コマンドを生成する
                Command searchAllCommand
                     = FacadeValueAccess.createCommand("Search", null);
                
                // レコード検索コマンドを実行する
                Command resultCommand
                     = caller.syncCommandCall(searchAllCommand);
                
                // 実行結果が成功しているか確認する
                if(resultCommand.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("レコード検索トランザクション失敗 : " + resultCommand.getStatus());
                    
                    // 例外が発生しているか確認する
                    if(resultCommand.getExceptionCount() != 0){
                        throw resultCommand.getExceptions()[0];
                    }
                    return;
                }
                
                // 実行結果を取得する
                List output = (List)resultCommand.getOutputObject();
                System.out.println("全検索（最大５件）");
                System.out.println("名前,年齢,性別");
                for(int i = 0, max = output.size(); i < max; i++){
                    Map record = (Map)output.get(i);
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // ２回のレコード検索フローを別トランザクションで１度に実行
                // 検索１：
                //   引数で、ユーザ名を検索条件として渡す
                //   検索結果該当あり
                // 検索２：
                //   引数で、ユーザ名を検索条件として渡す
                //   検索結果該当なし
                
                // 検索１コマンドを生成する
                Command search1Command
                     = FacadeValueAccess.createCommand("Search", "user10");
                // 検索１を独立したトランザクションで実行するために
                // コマンドを格納するUnitOfWorkを生成する
                UnitOfWork search1UOW = FacadeValueAccess.createUnitOfWork();
                // 検索１をUnitOfWorkに追加する
                search1UOW.addCommand(search1Command);
                
                // 検索２コマンドを生成する
                Command search2Command
                     = FacadeValueAccess.createCommand("Search", "user100");
                // 検索２を独立したトランザクションで実行するために
                // コマンドを格納するUnitOfWorkを生成する
                UnitOfWork search2UOW = FacadeValueAccess.createUnitOfWork();
                // 検索２をUnitOfWorkに追加する
                search2UOW.addCommand(search2Command);
                
                // 検索１UnitOfWorkと検索２UnitOfWork同時に実行するための
                // FacadeValueを生成して、各UnitOfWorkを追加する
                FacadeValue search1And2FV
                     = FacadeValueAccess.createCommandsValue();
                search1And2FV.addUnitOfWork(search1UOW);
                search1And2FV.addUnitOfWork(search2UOW);
                
                // 検索１と検索２をそれぞれ別トランザクションで実行する
                FacadeValue resultFV = caller.syncFacadeCall(search1And2FV);
                
                // 検索１の結果を取り出す
                UnitOfWork resutl1UOW = (UnitOfWork)resultFV.getCommand(0);
                Command resutl1Command = (Command)resutl1UOW.getCommand(0);
                
                // 実行結果が成功しているか確認する
                if(resutl1Command.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("検索１トランザクション失敗 : " + resutl1Command.getStatus());
                }else{
                    System.out.println("検索１ : user10");
                    // 実行結果を取得する
                    Map record = (Map)resutl1Command.getOutputObject();
                    System.out.println(record.get("name")
                        + "," + record.get("age")
                        + "," + record.get("sex"));
                }
                
                // 検索２の結果を取り出す
                UnitOfWork resutl2UOW = (UnitOfWork)resultFV.getCommand(1);
                Command resutl2Command = (Command)resutl2UOW.getCommand(0);
                
                // 実行結果が成功しているか確認する
                if(resutl2Command.getStatus() != CommandBase.C_STATUS_COMPLETE){
                    System.out.println("検索２トランザクション失敗 : " + resutl2Command.getStatus());
                }else{
                    System.out.println("検索２ : user100");
                    // 実行結果を取得する
                    Map record = (Map)resutl2Command.getOutputObject();
                    System.out.println(record);
                }
            }finally{
                // テーブル削除コマンドを生成する
                Command deleteCommand
                     = FacadeValueAccess.createCommand("DropTable", null);
                
                // テーブル削除コマンドを実行する
                Command resultCommand = caller.syncCommandCall(deleteCommand);
            }
        }else{
            System.out.println("サービス定義の読み込みに失敗しました。");
        }
        
        // サービス定義ファイルをアンロードする
        ServiceManagerFactory.unloadManager("service-definition.xml");
    }
    
}
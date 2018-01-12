
import java.util.*;

import jp.ossc.nimbus.beans.dataset.*;

/**
 * サンプル３実行クラス。
 */
public class Main{
    
    public static final void main(String[] args) throws Exception{
        
        System.out.println("//////// 1次元構造のみのデータセット ///////////");
        // データセット名：dataset1
        // データ構造：1次元構造で２つのプロパティを持つ
        //   プロパティ名        型
        //         A        java.lang.String
        //         B        int
        final DataSet dataset1 = new DataSet("dataset1");
        dataset1.setHeaderSchema(
            ":A,java.lang.String" + '\n'
            + ":B,int"
        );
        System.out.println("・データセット");
        System.out.println(dataset1);
        
        // 1次元構造を表現するヘッダを取得する
        final Header dataset1_header = dataset1.getHeader();
        System.out.println("・ヘッダのスキーマ定義");
        System.out.println(dataset1_header.getSchema());
        
        System.out.println("・データの設定・及び取得");
        // プロパティAに値を設定する
        dataset1_header.setProperty("A", "hoge");
        
        // プロパティAから値を取得する
        System.out.println("A=" + dataset1_header.getStringProperty("A"));
        
        // プロパティBに値を設定する
        dataset1_header.setProperty("B", 100);
        
        // プロパティBから値を取得する
        System.out.println("B=" + dataset1_header.getIntProperty("B"));
        
        System.out.println("・不正なデータの設定");
        // プロパティAに定義されている型と非互換な型の値を設定する
        try{
            dataset1_header.setProperty("A", 100);
        }catch(PropertySetException e){
            // 例外が発生する
            System.out.println("型が非互換です！" + e.getMessage());
        }
        
        // 存在しないプロパティCに値を設定する
        try{
            dataset1_header.setProperty("C", 100);
        }catch(PropertySetException e){
            // 例外が発生する
            System.out.println("存在しないプロパティです！" + e.getMessage());
        }
        
        
        
        System.out.println();
        System.out.println("//////// 2次元構造のみのデータセット ///////////");
        // データセット名：dataset2
        // データ構造：2次元構造で２つのプロパティを持つ
        //   プロパティ名        型
        //         A        java.lang.String
        //         B        int
        final DataSet dataset2 = new DataSet("dataset2");
        dataset2.setRecordListSchema(
            ":A,java.lang.String" + '\n'
            + ":B,int"
        );
        System.out.println("・データセット");
        System.out.println(dataset2);
        
        // 2次元構造を表現するレコードリストを取得する
        final RecordList dataset2_recordList = dataset2.getRecordList();
        System.out.println("・レコードリストのスキーマ定義");
        System.out.println(dataset2_recordList.getSchema());
        
        // レコードを生成する
        System.out.println("・レコード1の生成");
        final Record dataset2_recordList_record1
             = dataset2_recordList.createRecord();
        System.out.println("・レコード1のスキーマ定義");
        System.out.println(dataset2_recordList_record1.getSchema());
        System.out.println("・データの設定・及び取得");
        // プロパティAに値を設定する
        dataset2_recordList_record1.setProperty("A", "hoge");
        // プロパティAから値を取得する
        System.out.println("A=" + dataset2_recordList_record1.getStringProperty("A"));
        // プロパティBに値を設定する
        dataset2_recordList_record1.setProperty("B", 100);
        // プロパティBから値を取得する
        System.out.println("B=" + dataset2_recordList_record1.getIntProperty("B"));
        // レコードリストにレコードを追加する
        dataset2_recordList.addRecord(dataset2_recordList_record1);
        
        System.out.println("・レコード2の生成");
        final Record dataset2_recordList_record2
             = dataset2_recordList.createRecord();
        System.out.println("・レコード2のスキーマ定義");
        System.out.println(dataset2_recordList_record2.getSchema());
        System.out.println("・データの設定・及び取得");
        // プロパティAに値を設定する
        dataset2_recordList_record2.setProperty("A", "fuga");
        // プロパティAから値を取得する
        System.out.println("A=" + dataset2_recordList_record2.getStringProperty("A"));
        // プロパティBに値を設定する
        dataset2_recordList_record2.setProperty("B", 200);
        // プロパティBから値を取得する
        System.out.println("B=" + dataset2_recordList_record2.getIntProperty("B"));
        // レコードリストにレコードを追加する
        dataset2_recordList.addRecord(dataset2_recordList_record2);
        
        System.out.println("・レコードリスト内のレコードの取得");
        System.out.println("レコード件数=" + dataset2_recordList.size());
        Iterator records = dataset2_recordList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        
        
        
        System.out.println();
        System.out.println("//////// 1次元構造と2次元構造を併せ持つデータセット ///////////");
        // データセット名：dataset3
        // データ構造：1次元構造で２つのプロパティを持つ
        //   プロパティ名      型          入力変換種類 出力変換種類  制約
        //         A      java.lang.String    トリム     パディング   非null
        //         B      int               文字→数値   カンマ編集   1000以上
        //             2次元構造で３つのプロパティを持つ
        //   プロパティ名      型          入力変換種類 出力変換種類  制約
        //         A      java.lang.String
        //         B      int
        //         C      java.util.Date   yyMMdd→Date
        final DataSet dataset3 = new DataSet("dataset3");
        dataset3.setSchema(
            //ヘッダのスキーマ
            ":A,java.lang.String,\"jp.ossc.nimbus.util.converter.PaddingStringConverter{ConvertType=2;PaddingDirection=3}\",\"jp.ossc.nimbus.util.converter.PaddingStringConverter{ConvertType=1;PaddingLength=10;PaddingDirection=2}\",@value@!=null" + '\n'
            + ":B,long,\"jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=2;Format=#}\",\"jp.ossc.nimbus.util.converter.DecimalFormatConverter{ConvertType=1;Format=###,###,###}\",@value@>=1000",
            //レコードリストのスキーマ
            ":A,java.lang.String" + '\n'
            + ":B,int" + '\n'
            + ":C,java.util.Date,\"jp.ossc.nimbus.util.converter.DateFormatConverter{ConvertType=2;Format=yyMMdd}\""
        );
        System.out.println("・データセット");
        System.out.println(dataset3);
        
        // 1次元構造を表現するヘッダを取得する
        final Header dataset3_header = dataset3.getHeader();
        System.out.println("・ヘッダのスキーマ定義");
        System.out.println(dataset3_header.getSchema());
        
        System.out.println("・データの設定・及び取得");
        
        // プロパティAにパースした値を設定する
        dataset3_header.setParseProperty("A", "   hoge   ");
        
        // プロパティAから値を取得する
        System.out.println("A=\"" + dataset3_header.getStringProperty("A") + '"');
        
        // プロパティAからフォーマットした値を取得する
        System.out.println("A(フォーマット済み)=\"" + dataset3_header.getFormatProperty("A") + '"');
        
        // プロパティBにパースした値を設定する
        dataset3_header.setParseProperty("B", "10200");
        
        // プロパティBから値を取得する
        System.out.println("B=" + dataset3_header.getIntProperty("B"));
        
        // プロパティBからフォーマットした値を取得する
        System.out.println("B(フォーマット済み)=" + dataset3_header.getFormatProperty("B"));
        
        System.out.println("・不正なデータの設定");
        // プロパティAにnullの値を設定する
        try{
            dataset3_header.setProperty("A", null);
        }catch(PropertySetException e){
            // 例外が発生する
            System.out.println("値がnullです！" + e.getMessage());
        }
        
        // プロパティBに1000以下の値を設定する
        try{
            dataset3_header.setProperty("B", 100);
        }catch(PropertySetException e){
            // 例外が発生する
            System.out.println("値が1000より小さいです！" + e.getMessage());
        }
        
        // 2次元構造を表現するレコードリストを取得する
        final RecordList dataset3_recordList = dataset3.getRecordList();
        System.out.println("・レコードリストのスキーマ定義");
        System.out.println(dataset3_recordList.getSchema());
        
        // レコードを生成する
        System.out.println("・レコード1の生成");
        final Record dataset3_recordList_record1
             = dataset3_recordList.createRecord();
        // プロパティAに値を設定する
        dataset3_recordList_record1.setProperty("A", "hoge");
        // プロパティBに値を設定する
        dataset3_recordList_record1.setProperty("B", 100);
        // プロパティCに値を設定する
        dataset3_recordList_record1.setParseProperty("C", "071109");
        // レコードリストにレコードを追加する
        dataset3_recordList.addRecord(dataset3_recordList_record1);
        System.out.println("レコード1 : " + dataset3_recordList_record1);
        
        System.out.println("・レコード2の生成");
        final Record dataset3_recordList_record2
             = dataset3_recordList.createRecord();
        // プロパティAに値を設定する
        dataset3_recordList_record2.setProperty("A", "fuga");
        // プロパティBに値を設定する
        dataset3_recordList_record2.setProperty("B", 200);
        // プロパティCに値を設定する
        dataset3_recordList_record2.setParseProperty("C", "071110");
        // レコードリストにレコードを追加する
        dataset3_recordList.addRecord(dataset3_recordList_record2);
        System.out.println("レコード２ : " + dataset3_recordList_record2);
        
        System.out.println("・レコードリスト内のレコードの取得");
        System.out.println("レコード件数=" + dataset3_recordList.size());
        records = dataset3_recordList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        
        
        
        System.out.println();
        System.out.println("//////// 1次元構造に2次元構造がぶらさがったデータセット ///////////");
        // データセット名：dataset1
        // データ構造：1次元構造で２つのプロパティを持ち、そのうちの１つが2次元構造を持つ
        //   プロパティ名        型
        //         A        java.lang.String
        //         B        jp.ossc.nimbus.beans.dataset.RecordList
        //                  プロパティ名        型
        //                        C         java.lang.String
        //                        D         int
        final DataSet dataset4 = new DataSet("dataset4");
        dataset4.setHeaderSchema(
            ":A,java.lang.String" + '\n'
            + "LIST:B,BList"
        );
        dataset4.setNestedRecordListSchema(
            "BList",
            ":C,java.lang.String" + '\n'
            + ":D,int"
        );
        System.out.println("・データセット");
        System.out.println(dataset4);
        
        // 1次元構造を表現するヘッダを取得する
        final Header dataset4_header = dataset4.getHeader();
        System.out.println("・ヘッダのスキーマ定義");
        System.out.println(dataset4_header.getSchema());
        
        System.out.println("・データの設定");
        // プロパティAに値を設定する
        dataset4_header.setProperty("A", "hoge");
        
        // プロパティAから値を取得する
        System.out.println("A=" + dataset4_header.getStringProperty("A"));
        
        // プロパティBのレコードリストを生成する
        RecordList dataset4_header_bList = dataset4.createNestedRecordList("BList");
        System.out.println("・レコードリストのスキーマ定義");
        System.out.println(dataset4_header_bList.getSchema());
        
        // レコードを生成する
        System.out.println("・レコード1の生成");
        final Record dataset4_header_bList_record1
             = dataset4_header_bList.createRecord();
        // プロパティCに値を設定する
        dataset4_header_bList_record1.setProperty("C", "hoge");
        // プロパティDに値を設定する
        dataset4_header_bList_record1.setProperty("D", 100);
        // レコードリストにレコードを追加する
        dataset4_header_bList.addRecord(dataset4_header_bList_record1);
        System.out.println("レコード1 : " + dataset4_header_bList_record1);
        
        System.out.println("・レコード2の生成");
        final Record dataset4_header_bList_record2
             = dataset4_header_bList.createRecord();
        // プロパティCに値を設定する
        dataset4_header_bList_record2.setProperty("C", "hoge");
        // プロパティDに値を設定する
        dataset4_header_bList_record2.setProperty("D", 200);
        // レコードリストにレコードを追加する
        dataset4_header_bList.addRecord(dataset4_header_bList_record2);
        System.out.println("レコード2 : " + dataset4_header_bList_record2);
        
        // プロパティBにレコードリストを設定する
        dataset4_header.setProperty("B", dataset4_header_bList);
        
        
        // プロパティAから値を取得する
        System.out.println("A=\"" + dataset4_header.getStringProperty("A") + '"');
        System.out.println("B=");
        System.out.println("レコード件数=" + dataset4_header_bList.size());
        records = dataset4_header_bList.iterator();
        while(records.hasNext()){
            final Record record = (Record)records.next();
            final Iterator entries = record.entrySet().iterator();
            while(entries.hasNext()){
                final Map.Entry entry = (Map.Entry)entries.next();
                System.out.print(entry.getKey() + "=" + entry.getValue());
                if(entries.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
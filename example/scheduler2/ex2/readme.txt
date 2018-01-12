
サンプル２

○目標
 スケジュールをデータベースで管理してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・業務フロー定義ファイル
    flows\flow-definition.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
      スケジュールが実行され、データベースに実行された状態が保存される。
  （３）SQLでデータベースの状態を確認する。
      例：
        java -classpath C:\JBoss-3.2.7\server\default\lib\hsqldb.jar org.hsqldb.util.SqlTool --rcfile sqltool.rc localDB
        sql> select * from schedule;
  （４）再度Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar Main
      状態が保存されているため、同じスケジュールは実行されない。

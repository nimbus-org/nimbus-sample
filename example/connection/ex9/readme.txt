
サンプル７

○目標
 ２つのデータベースを同期してみよう。
 Connectionをラップして、更新トランザクションをトランザクションログテーブルに記録する。
 記録したトランザクションを読み込み、同期先のデータベースに対してトランザクションを再生して、データベースの同期を行う。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar
  ・Log4JのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;log4j-X.X.X.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main
   
  （３）標準出力にメトリクスが出力されることと、実行ディレクトリのjournal.txtを確認する。

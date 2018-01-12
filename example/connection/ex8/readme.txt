
サンプル８

○目標
 データセットを使ってCSVファイルからデータベースに書き込んでみよう。
 PersistentManagerとDataSetとの組み合わせで、より直観的にプログラムする。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・バッチ入力ファイル
    userlist.csv

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main

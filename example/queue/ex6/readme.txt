
サンプル６

○目標
 JVM間でQueueを共有してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java


○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）共有キューからGETして、100[ms]の処理時間がかかるプロセス１を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main GET 100
   
  （３）共有キューからGETして、100[ms]の処理時間がかかるプロセス２を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main GET 100
   
  （４）共有キューに100件PUSHするプロセスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main PUT 100

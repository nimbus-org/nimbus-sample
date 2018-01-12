
サンプル２

○目標
 キューを使って非同期処理をしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプルQueueHandlerクラスのソースファイル
    sample\handler\SampleQueueHandler.java
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java sample\handler\SampleQueueHandler.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

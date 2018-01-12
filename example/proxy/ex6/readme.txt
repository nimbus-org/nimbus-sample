
サンプル６

○目標
 リモートのサービスをクラスタ化して呼び出してみよう。

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
   
  （２）サーバ１を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （３）サーバ２を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （４）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client Main
   
  （５）サーバプロセス１を落とす。
   
  （６）サーバプロセス２を落とす。

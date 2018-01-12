
サンプル１

○目標
  JVMをクラスタ化してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・jp.ossc.nimbus.service.keepalive.ClusterListenerインタフェースのサンプル実装クラスのソースファイル
    ClusterListener.java
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar ClusterListener.java Main.java
   
  （２）クラスタクライアントとしてMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DisClient=true Main
   
  （３）クラスタサーバ１としてMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DisClient=false Main
   
  （４）クラスタサーバ２としてMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DisClient=false Main

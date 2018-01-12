
サンプル４

○目標
 リモートのサービスを呼び出す時にジャーナルを出力してみよう。
 クライアント側とサーバ側の両方にインターセプタを挟み込んで、ジャーナルを出力させる。

○リソース一覧
  ・サービス定義ファイル
    client-service-definition.xml
    server-service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サービスクラスのソースファイル
    sample\service\Messenger.java
    sample\service\POJOService.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac sample\service\*.java
        javac -classpath .;nimbus.jar Main.java
  
  （２）サーバプロセスを起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar jp.ossc.nimbus.core.ServiceManagerFactory -server server-service-definition.xml
   
  （３）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main


サンプル４

○目標
 コネクションを分散して、１対多でのメッセージ配信をしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
    SampleMessageListener.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java SampleMessageListener.java
   
  （２）サブジェクト"hoge"に任意のキーでメッセージを送信するMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server Main
   
  （３）サブジェクト"hoge"のメッセージを受信するクライアント１を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （４）サブジェクト"hoge"のメッセージを受信するクライアント２を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （５）（２）で起動したMainクラスのコンソールで任意のキーでメッセージを入力する。

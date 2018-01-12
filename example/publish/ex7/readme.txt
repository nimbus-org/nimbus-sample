
サンプル７

○目標
 一対多での同期通信をしてみよう。

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
   
  （２）サブジェクト"hoge"に任意のメッセージを送受信するMainクラス１を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （３）サブジェクト"hoge"に任意のメッセージを送受信するMainクラス２を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （４）サブジェクト"hoge"に任意のメッセージを送受信するMainクラス３を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （５）（２）で起動したMainクラス１のコンソールで任意のメッセージを入力する。
   
  （６）（３）（４）で起動したMainクラス２、３のコンソールに、（５）で送ったメッセージが表示されるので、それぞれのコンソールで応答メッセージを入力する。
   
  （７）（２）で起動したMainクラス１のコンソールにMainクラス２、３からの応答メッセージが表示される。

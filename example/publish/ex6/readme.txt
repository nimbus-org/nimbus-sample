
サンプル６

○目標
 TCPプロトコル上に独自通信プロトコルを作成して、１対多でのメッセージ配信をしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
    MyExternalizer.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java MyExternalizer.java
   
  （２）任意のメッセージを送信するMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main server
   
  （３）任意のメッセージを受信するクライアントを起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （４）（３）で起動したクライアント側のコンソールで、受信の登録と受信開始を行う。
      例：
        ADD,subject1,key1
        START
   
  （５）（２）で起動したサーバ側のコンソールで任意のメッセージを送信する。
      例：
        subject1,key1,hogehoge
        subject1,key1,fugafuga


サンプル７

○目標
 JVM間でコンテキストを共有して、トランザクション更新してみよう。

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
   
  （２）共有コンテキストをホスティングするMainクラス１を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DPort=10001 -DClient=false Main
   
  （３）共有コンテキストをホスティングするMainクラス２を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DPort=10002 -DClient=false Main
   
  （４）共有コンテキストを参照するMainクラス３を実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DPort=10003 -DClient=true Main
   
  （５）（２）で起動したMainクラス３のコンソールで以下を入力する。
      put 1 test 100
      put 2 test 200
   
  （６）（３）（４）で起動したMainクラス１、２のコンソールで以下を入力する。
      get 1 test
      get 2 test
   
  （７）（２）で起動したMainクラス３のコンソールで以下を入力する。
      begin
      put 1 test 101
      put 2 test 201
   
  （８）（３）（４）で起動したMainクラス１、２のコンソールで以下を入力する。
      get 1 test
      get 2 test
   
  （９）（２）で起動したMainクラス３のコンソールで以下を入力する。
      commit
      または
      rollback
   
  （１０）（３）（４）で起動したMainクラス１、２のコンソールで以下を入力する。
      get 1 test
      get 2 test

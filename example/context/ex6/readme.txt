
サンプル６

○目標
 JVM間でコンテキストを分散共有してみよう。

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
   
  （５）（２）（３）（４）で起動したコンソールで以下を入力する。
      size
   
  （６）（２）で起動したMainクラス１のコンソールで以下を入力する。
      put test 1
   
  （７）（２）（３）（４）で起動したコンソールで以下を入力する。
      size
      get test
      size
   
  （８）（３）で起動したMainクラス２のコンソールで以下を入力する。
      clear
   
  （９）（２）（３）（４）で起動したコンソールで以下を入力する。
      size

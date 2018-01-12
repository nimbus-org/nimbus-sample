
サンプル１

○目標
  サーバーを立ててソケット通信でアプリケーションを呼び出してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・業務フロー定義ファイル
    flows\flow-definition.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）サーバーを起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar  jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （３）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

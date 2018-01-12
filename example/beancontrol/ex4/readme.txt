
サンプル４

○目標
 業務フローで分散処理を実行してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）サーバ１を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （３）サーバ２を起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （４）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar Main


サンプル１

○目標
 業務フローをXML定義で制御してみよう。
 BeanFlowInvokerFactoryサービスを使ってみよう。

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
  ・Jakarta Commons JexlのJar
  ・Jakarta Commons LoggingのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main

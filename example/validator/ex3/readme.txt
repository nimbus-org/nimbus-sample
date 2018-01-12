
サンプル３

○目標
 業務フローで、自由に検証してみよう。
 
 更新頻度の低いマスタはコードマスタ化する。
 また、読み取り一貫性保障するために、BeanFlowの開始点でAOPを使って
 スレッドコンテキストに乗せておく。
 マスタを使った検証では、そのコードマスタから取得して検証するように
 設定する。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルBeanクラスのソースファイル
    sample\Employee.java
    sample\Family.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar
  ・JMSのJar
  ・commons-jexlのJar
  ・commons-loggingのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java sample\*.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;jms.jar;commons-jexl.jar;commons-logging.jar;C:\JBoss-3.2.7\server\default\lib\hsqldb.jar Main

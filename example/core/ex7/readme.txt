
サンプル７

○目標
  サービス定義を条件に応じて切り替えてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\POJOService.java
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\POJOService.java Main.java
   
  （２）システムプロパティを変えながらMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DService1=enable Main
        java -classpath .;nimbus.jar;jmx.jar -DService1=enable -DMessage=false -DInitState=Created Main
        java -classpath .;nimbus.jar;jmx.jar Main


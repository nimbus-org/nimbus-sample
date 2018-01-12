
サンプル１

○目標
  静的アスペクトを使ってみよう。

○リソース一覧
  ・アスペクト定義ファイル
    aspect-definition.xml
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\POJOService.java
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JavassistのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\POJOService.java Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main
   
  （３）アスペクトコンパイルする。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar jp.ossc.nimbus.service.aop.Compiler -servicepath aspect-definition.xml -d . sample.service.POJOService
   
  （４）アスペクトコンパイル後のクラスを使って、Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main


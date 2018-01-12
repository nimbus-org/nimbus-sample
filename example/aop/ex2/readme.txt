
サンプル２

○目標
  動的アスペクトを使ってみよう。

○リソース一覧
  ・アスペクト定義ファイル
    aspect-definition.xml
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\POJOService.java
    sample\service\Messenger.java
  ・サンプル実行クラスのソースファイル
    Main.java
    MainWithAspect.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JavassistのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\*.java Main.java MainWithAspect.java
   
  （２）アスペクト定義をロードしないMainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （３）アスペクト定義をロードするMainWithAspectクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar MainWithAspect


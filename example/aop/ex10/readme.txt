
サンプル１０

○目標
  リトライインターセプタをアスペクトしてみよう。

○リソース一覧
  ・アスペクト定義ファイル
    aspect-definition.xml
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\Caller.java
    sample\service\POJOService.java
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JavassistのJar
  ・Jakarta Commons JexlのJar
  ・Jakarta Commons LoggingのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\*.java Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main


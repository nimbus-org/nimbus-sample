
サンプル５

○目標
  非同期処理を行うインターセプタをアスペクトしてみよう。

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

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JavassistのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\*.java Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main


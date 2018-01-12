
サンプル７

○目標
  同期インターセプタをアスペクトしてみよう。

○リソース一覧
  ・アスペクト定義ファイル
    aspect-definition1.xml
    aspect-definition2.xml
    aspect-definition3.xml
    aspect-definition4.xml
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\POJOService1.java
    sample\service\POJOService2.java
    sample\service\Messenger.java
  ・サンプル実行クラスのソースファイル
    Main1.java
    Main2.java
    Main3.java
    Main4.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JavassistのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\*.java Main*.java
   
  （２）Main1～Main4クラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;javassist.jar Main1


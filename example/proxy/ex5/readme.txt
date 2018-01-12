
サンプル５

○目標
 ローカルのサービスを呼び出す時にジャーナルを出力してみよう。
 インターセプタを挟み込んで、ジャーナルを出力させる。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サービスクラスのソースファイル
    sample\service\Messenger.java
    sample\service\POJOService.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java sample\service\*.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

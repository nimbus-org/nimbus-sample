
サンプル３

○目標
 ジャーナルを自由にフォーマットしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・Log4JのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;log4j-X.X.X.jar;jmx.jar Main
   
  （３）実行ディレクトリのjournal.txtを確認する。


サンプル２

○目標
 ログをファイルに出力してみよう。
 デフォルトカテゴリの出力先をファイルにしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・ログメッセージ定義ファイル
    MyMessage1.def

○用意するもの
  ・NimbusのJar
  ・Log4JのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;log4j-X.X.X.jar;jmx.jar Main


サンプル３

○目標
 ログのフォーマットを変えてみよう。
 デフォルトカテゴリのログフォーマットを変えてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・ログメッセージ定義ファイル
    MyMessage1.def

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

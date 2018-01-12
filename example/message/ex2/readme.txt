
サンプル２

○目標
 メッセージを国際化対応してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・ログメッセージ定義ファイル
    MyMessage1.def
    MyMessage1_ja.def.src
    MyMessage1_de.def

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）日本語用のメッセージ定義ファイルをユニコードに変換する。
      例：
        native2ascii MyMessage1_ja.def.src MyMessage1_ja.def
   
  （３）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

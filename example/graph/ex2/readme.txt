
サンプル２

○目標
  ローソクチャート画像を生成してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルデータファイル
    data1.csv

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JFreeChartのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar;jfreechart.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jfreechart.jar Main
   
  （３）実行ディレクトリに作成されるgraph.pngを確認する。

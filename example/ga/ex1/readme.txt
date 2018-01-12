
サンプル１

○目標
 遺伝的アルゴリズムを使ってみよう。
 遺伝的アルゴリズムを使って最大/最小面積となる多角形を求めよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java


○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行し、1世代あたり100個のサンプリングで最大面積となる10角形を求める。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main 100 false 10

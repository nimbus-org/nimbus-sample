
サンプル４

○目標
 キューをファイルに永続化してみよう。

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
   
  （２）Mainクラスを実行して、永続化されたキューに投入する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main push
   
  （３）Mainクラスを実行して、キューから取得する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main get

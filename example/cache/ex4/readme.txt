
サンプル４

○目標
 ２次キャッシュにあふれさせてみよう。
 ヒープメモリが逼迫すると、先入れ先出し（FIFO）で、２次キャッシュに
 あふれていくようにする。

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
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main


サンプル３

○目標
 キャッシュからあふれさせてみよう。
 キャッシュのサイズが２を超えると、先入れ先出し（FIFO）で
 キャッシュがあふれていくようにする。

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

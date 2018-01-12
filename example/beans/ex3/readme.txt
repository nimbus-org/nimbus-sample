
サンプル３

○目標
  汎用的なBean（データセット）を動的に定義して使ってみよう。
  
  通常、アプリケーションで使用するデータ構造には、1次元で表現できるデータと
  2次元で表現できるデータ、またその組み合わせで表現できるデータがあります。
  
  Nimbusでは、このような汎用的なデータ構造を表現するクラスを、その時々に
  応じてクラスを実装して開発するコストを削減するために、データ構造を動的に
  定義して、汎用的なデータ構造を表現できる機能を提供します。

○リソース一覧
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・commons-jexlのjar
  ・commons-loggingのjar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;commons-jexl.jar;commons-logging.jar Main

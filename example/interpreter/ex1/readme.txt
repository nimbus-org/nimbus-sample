
サンプル１

○目標
  Javaをインタープリット実行してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・インタープリタ実行するソースコードファイル
    sample.txt
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・BeanShellのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;bsh.jar Main

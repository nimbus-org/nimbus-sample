
サンプル２

○目標
 業務フローで自由に変換してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルBeanクラスのソースファイル
    sample\Bean1.java
    sample\Bean2.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・commons-jexlのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java sample\*.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;commons-jexl.jar Main


サンプル６

○目標
 出力内容から条件判定をして出力方法を変えてみよう。
 出力情報をコンソールに出力する。
 但し、出力情報に例外が含まれる場合は、ファイルerror.txtにも出力する。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・Log4JのJar
  ・JMXのJar
  ・Jakarta Commons JexlのJar
  ・Jakarta Commons LoggingのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;log4j-X.X.X.jar;jmx.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main


サンプル８

○目標
 リモートのコンソールに出力してみよう。

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
   
  （２）サーバを起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Server jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml
   
  （３）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DMode=Client -DClient=Client1 Main

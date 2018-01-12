
サンプル１

○目標
 FTP通信をしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・commons-netのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。（各パラメータは環境に合わせて指定）
      例：
        java -classpath .;nimbus.jar;jmx.jar;commons-net.jar -DHOST=hostname -DPORT=port -DUSER=user -DPASSWORD=pass Main

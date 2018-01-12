
サンプル１

○目標
 スケジューラーを使ってみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・業務フロー定義ファイル
    flows\flow-definition.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar Main
      スケジュールが実行され、schdule/yyyyMMddのディレクトリにスケジュールされ、実行された状態が保存される。
  （３）再度Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar Main
      状態が保存されているため、同じスケジュールは実行されない。

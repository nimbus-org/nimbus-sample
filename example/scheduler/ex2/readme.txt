
サンプル２

○目標
 日付によって異なるスケジューラを起動してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルScheduleTaskクラスのソースファイル
    sample\task\SampleTask.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java sample\task\SampleTask.java
   
  （２）Mainクラスを実行する。引数で起動日付（yyyy/MM/dd）を指定する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main 2006/08/18

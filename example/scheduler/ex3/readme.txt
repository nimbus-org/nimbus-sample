
サンプル３

○目標
 スケジュールの状態を保存してみよう。
 スケジュール１～３は、指定された時間に1度だけ実行されるスケジュールである。
 スケジュール４は、1秒間隔で定期的に実行されるスケジュールである。
 スケジュールを実行すると、スケジュールの実行状態がカレントディレクトリにファイルとして保存される。
 そのため、再度スケジュールを実行しても、スケジュール１～３は、1度実行されたものは、再度実行されない。
 また、定期実行のスケジュール４は、何度でも実行される。

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
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main
   
  （３）Mainクラスを再度実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main


サンプル２

○目標
  コマンドベースで、Javaをインタープリット実行してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・インタープリタ実行するソースコードファイル
    sample.txt

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・BeanShellのJar

○実行
   
  （１）コマンドを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;bsh.jar jp.ossc.nimbus.service.interpreter.BeanShellInterpreterService -servicepath service-definition.xml -file sample.txt

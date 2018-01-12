
サンプル１

○目標
 テストフレームワークを使ってみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml

○用意するもの
  ・NimbusのJar
  ・commons-httpclientのJar
  ・commons-codecのJar
  ・commons-loggingのJar
  ・commons-langのJar
  ・commons-collectionsのJar
  ・velocityのJar
  ・bshのJar

○実行
   
  （１）TestRunnerを実行する。（JDK1.5以上を使用）
      例：
        java -classpath nimbus.jar;commons-httpclient.jar;commons-codec.jar;commons-logging.jar;commons-lang.jar;commons-collections.jar;velocity.jar -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false jp.ossc.nimbus.service.test.TestRunner runner.xml service-definition.xml

  （２）TestSwingRunnerを実行する。（JDK1.6以上を使用）
      例：
        java -classpath nimbus.jar;commons-httpclient.jar;commons-codec.jar;commons-logging.jar;commons-lang.jar;commons-collections.jar;velocity.jar -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false jp.ossc.nimbus.service.test.TestRunner service-definition.xml

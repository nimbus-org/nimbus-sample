
サンプル１

○目標
 JMXでJVMのヒープを監視してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml

○用意するもの
  ・NimbusのJar

○実行
  （１）実行する。（JDK1.5以上を使用）
      例：
        java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=1234 -Dcom.sun.management.jmxremote.ssl=false -classpath nimbus.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml

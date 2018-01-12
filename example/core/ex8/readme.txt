
サンプル８

○目標
  サービス定義ファイルをスタンドアローンに読み込もう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サービスクラスのソースファイル
    sample\service\POJOService.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\SampleService.java

  （２）スタンドアローンで起動する。
      例：
        java -classpath .;nimbus.jar;jmx.jar jp.ossc.nimbus.core.ServiceManagerFactory -server service-definition.xml


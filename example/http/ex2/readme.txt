
サンプル２

○目標
 HTTP通信でPOSTして、XMLを取得してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-client.xml
    service-server.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・ログインリクエストの応答用XMLファイル
    login_response.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar（JDK1.5以降は不要）
  ・Servlet APIのJar
  ・commons-httpclientのJar
  ・commons-loggingのJar
  ・commons-codecのJar
  ・commons-jexlのJar
  ・jaxpのJar（JDK1.5以降は不要）
  ・xalanのJar（javax.xml.xpath.XPathFactoryの実装が含まれるもの。JDK1.5以降は不要）

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;servletapi.jar;commons-httpclient.jar;commons-logging.jar;commons-codec.jar;commons-jexl.jar;jaxp.jar;xalan.jar Main

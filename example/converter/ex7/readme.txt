
サンプル７

○目標
 XMLストリームを任意のデータセットに変換してみよう。

○リソース一覧
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルXMLファイル
    sample.xml

○用意するもの
  ・NimbusのJar
  ・commons-loggingのJar
  ・commons-jexlのJar
  ・jaxpのJar（JDK1.5以降は不要）
  ・xalanのJar（javax.xml.xpath.XPathFactoryの実装が含まれるもの。JDK1.5以降は不要）

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;commons-logging.jar;commons-jexl.jar;jaxp.jar;xalan.jar Main

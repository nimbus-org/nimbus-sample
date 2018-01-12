
サンプル８

○目標
 HTMLストリームを任意のデータセットに変換してみよう。

○リソース一覧
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルHTMLファイル
    sample.html

○用意するもの
  ・NimbusのJar
  ・commons-loggingのJar
  ・commons-jexlのJar
  ・jaxpのJar（JDK1.5以降は不要）
  ・nekohtmlのJar
  ・xercesのJar
  ・xalanのJar（javax.xml.xpath.XPathFactoryの実装が含まれるもの。JDK1.5以降は不要）

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;commons-logging.jar;commons-jexl.jar;jaxp.jar;xerces.jar;xalan.jar Main

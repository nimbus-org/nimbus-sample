
サンプル６

○目標
 HTMLストリームとDOM（Document Object Model）を相互変換してみよう。

○リソース一覧
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプルHTMLファイル
    sample.html

○用意するもの
  ・NimbusのJar
  ・nekohtmlのJar
  ・jaxpのJar（JDK1.5以降は不要）
  ・xercesのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;nekohtml.jar;jaxp.jar;xerces.jar Main

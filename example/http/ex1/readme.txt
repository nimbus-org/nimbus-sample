
サンプル１

○目標
 HTTP通信でインターネットにアクセスしてHTMLを取得してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・commons-httpclientのJar
  ・commons-loggingのJar
  ・commons-codecのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;commons-httpclient.jar;commons-logging.jar;commons-codec.jar Main
   
  （３）取得したHTMLを確認する。
      実行したフォルダに、ProjectTopPage.htmlとProjectHomePage.htmlが作成されているので中身を確認する。

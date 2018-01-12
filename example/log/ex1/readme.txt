
サンプル１

○目標
 ログをコンソールに出力してみよう。
 デフォルトで用意されているログカテゴリを使ってログを出力してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・ログメッセージ定義ファイル
    MyMessage1.def

○メッセージ定義ファイルの仕様
  フォーマット : メッセージID,メッセージ,プライオリティ数値,カテゴリ名
  エスケープ文字 : \\
  埋め込み文字 : @連番
  シークレット埋め込み文字 : #連番

○用意するもの
  ・NimbusのJar
  ・JMXのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar Main

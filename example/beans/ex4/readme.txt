
サンプル４

○目標
  汎用的なBean（データセット）をコンクリートなクラスにしたソースを自動生成してみよう。

○リソース一覧
  ・データセット定義ファイル
    dataset-definition1.xml
    dataset-definition2.xml

○用意するもの
  ・NimbusのJar
  ・JMXのjar

○実行
  （１）データセット定義ファイル１からソースを生成する。
      例：
        java -classpath nimbus.jar;jmx.jar -DPACKAGE=sample.beans jp.ossc.nimbus.beans.dataset.DataSetCodeGenerator -v dataset-definition1.xml
  （２）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\beans\*.java
   
  （３）データセット定義ファイル２からソースを生成する。
      例：
        java -classpath .;nimbus.jar;jmx.jar -DPACKAGE=sample.beans jp.ossc.nimbus.beans.dataset.DataSetCodeGenerator -v dataset-definition2.xml
  （４）コンパイルする。
      例：
        javac -classpath .;nimbus.jar sample\beans\*.java


サンプル１

○目標
  Beanと文字列の相互変換をしてみよう。
  Nimbusで実装された様々なPropertyEditorを使ってみよう。
  
  JDKには、Stringと特定のオブジェクト間の相互変換をサポートする  PropertyEditor
  という仕組みが提供されています。
  しかしながら、その実装クラスは少なく、プリミティブ型と一部のクラスしか
  サポートしていません。
  
  Nimbusでは、サービス定義やBeanFlow定義などで、XML上で文字列で表現されたものを
  様々な型のオブジェクトに変換して、Beanにインジェクションする機能が必要になり
  ます。
  そこで、様々な型の変換をサポートするために、様々なPropertyEditor実装クラスを
  提供しています。
  ここで、提供されるPropertyEditor実装クラスは、Nimbus CoreやNimbus BeanFlowでも
  使用されています。

○リソース一覧
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar Main

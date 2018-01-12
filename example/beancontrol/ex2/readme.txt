
サンプル２

○目標
 業務フローのジャーナルを出力してみよう。
 BeanFlowInvokerFactoryサービスを使って、業務フローを実行して、ジャーナルを
 出力してみよう。
 ジャーナルは、実行ディレクトリのjournal.logファイルに出力する。
 
 外部から呼び出されるフロー（"Public-"から始まるフロー）にだけ、スレッドコン
 テキスト初期化処理が行われるように、インターセプタを挟む。
 スレッドコンテキストの初期化では、リクエストIDを採番して、スレッドコンテキ
 ストに乗せる。
 BeanFlowファクトリに設定されたジャーナルは、BeanFlowの処理中のジャーナルを
 記録する。その際、リクエストIDをスレッドコンテキストから取得する事で、一連
 の処理を紐付ける。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・業務フロー定義ファイル
    flows\flow-definition.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JTAのJar
  ・Jakarta Commons JexlのJar
  ・Jakarta Commons LoggingのJar

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
   
  （２）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;jta.jar;commons-jexl-X.X.jar;commons-logging-X.X.X.jar Main


サンプル３

○目標
  コマンドベースで、別VM上でJavaをインタープリット実行してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・インタープリタ実行するソースコードファイル
    sample.txt
  ・JBossサービスアーカイブ
    sample.sar
    
    ・サービス定義ファイル
      sample.sar\service-definition.xml
    ・JBossサービス定義ファイル
      sample.sar\META-INF\jboss-service.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・BeanShellのJar
  ・JBoss

○実行
  
  （１）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （２）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （３）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.sarフォルダをコピーする
   
  （４）コマンドを実行する。
      例：
        java -classpath .;nimbus.jar;jmx.jar;bsh.jar jp.ossc.nimbus.service.interpreter.BeanShellInterpreterService -servicepath service-definition.xml -file sample.txt

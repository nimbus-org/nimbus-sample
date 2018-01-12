
サンプル４

○目標
  サービスをJBoss Application Serverにデプロイしてみよう。

○リソース一覧
  ・JBossサービスアーカイブ
    sample.sar
    
    ・サービス定義ファイル
      sample.sar\service-definition.xml
    ・JBossサービス定義ファイル
      sample.sar\META-INF\jboss-service.xml
    ・サービスクラスのソースファイル
      sample.sar\sample\service\POJOService.java

○用意するもの
  ・NimbusのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\POJOService.java
  
  （２）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （３）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （４）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.sarフォルダをコピーする
  
  （５）JBossからアンデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployからsample.sarフォルダを削除する

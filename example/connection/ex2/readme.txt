
サンプル２

○目標
  JCA(Java Connector Architecture)を使ってJDBCコネクションを取得してみよう。

○リソース一覧
  ・Webアプリケーションアーカイブ
    sample.war
    
    ・サービス定義ファイル
      sample.war\service-definition.xml
    ・Webアプリケーション配置記述子ファイル
      sample.war\WEB-INF\web.xml
    ・サンプル実行JSPファイル
      sample.war\Main.jsp

○用意するもの
  ・NimbusのJar
  ・アプリケーションサーバ（このサンプルではJBossを使用する）

○実行
  （１）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （２）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （３）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.warフォルダをコピーする
  
  （４）ブラウザでサンプル実行JSPにアクセスする。
      例：
        ブラウザで、http://localhost:8080/sample/Main.jspにアクセスする。

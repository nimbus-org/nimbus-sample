
サンプル５

○目標
  HTTPリクエストを検証してみよう。
  Refererチェックをして、許可されたリンクからのアクセスしか許さないようにする。

○リソース一覧
  ・Webアプリケーションアーカイブ
    sample.war
    
    ・サービス定義ファイル
      sample.war\service-definition.xml
    ・Webアプリケーション配置記述子ファイル
      sample.war\WEB-INF\web.xml
    ・サンプルJSP
      sample.war\WEB-INF\sample.jsp

○用意するもの
  ・NimbusのJar
  ・サーブレットコンテナ（このサンプルではJBossを使用する）

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
  
  （４）http://localhost:8080/sample/index.htmlまたはhttp://localhost:8080/sample/にアクセスし、リンクから飛ぶ。
  
  （５）http://localhost:8080/sample/hogeに直接アクセスする。

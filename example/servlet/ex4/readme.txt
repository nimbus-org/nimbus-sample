
サンプル４

○目標
  2バイト文字のPOSTパラメータが文字化けしないようにしてみよう。

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
  
  （４）http://localhost:8080/sample/noencodingにアクセスして、2バイト文字を入力して送信。
  
  （５）http://localhost:8080/sample/encodingにアクセスして、2バイト文字を入力して送信。

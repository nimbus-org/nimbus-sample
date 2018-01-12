
サンプル８

○目標
  Webアプリケーションを業務フローで作ってみよう。

○リソース一覧
  ・BeanFlow定義ファイル
    ・common-flow-definition.xml
    ・login-flow-definition.xml
    ・logout-flow-definition.xml
  
  ・Webアプリケーションアーカイブ
    sample.war
    
    ・サービス定義ファイル
      sample.war\service-definition.xml
    ・Webアプリケーション配置記述子ファイル
      sample.war\WEB-INF\web.xml
    ・サンプルJSP
      sample.war\index.jsp
      sample.war\WEB-INF\hello.jsp

○用意するもの
  ・NimbusのJar
  ・Jakarta Commons JexlのJar
  ・サーブレットコンテナ（このサンプルではJBossを使用する）

○実行
  
  （１）JBossにNimbus、Jakarta Commons JexlのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbus、Jakarta Commons JexlのJarファイルをコピーする
  
  （２）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （３）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\defaultにflowsフォルダをコピーする
        C:\JBoss-3.2.7\server\default\deployにsample.warフォルダをコピーする
  
  （４）http://localhost:8080/sampleにアクセスする。
  
  （５）ログイン画面にて、何も入力せずに「ログイン」ボタンを押下する。
  
  （６）ログイン画面にて、IDに"hoge"、パスワードに"fuga"を入力して「ログイン」ボタンを押下する。
  
  （７）ログイン後画面にて、「ログアウト」ボタンを押下する。

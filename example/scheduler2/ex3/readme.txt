
サンプル3

○目標
 Scheduler2サービスを使って、Console画面を操作しよう。

○リソース一覧

  ・cssファイル
    \schedule_console.war\css
    
 ・JavaScriptファイル
    \schedule_console.war\js
    
  ・イメージファイル
    \schedule_console.war\images
    
 ・Fontファイル
    \schedule_console.war\fonts
    
  ・htmlファイル
    \schedule_console.war\index.html

  ・サービス定義ファイル
    \schedule_console.war\WEB-INF\service_servlet.xml
    \schedule_console.war\WEB-INF\web.xml

  ・Beanフローファイル
    \schedule_console.war\WEB-INF\beanflow

▲用意するもの
  ・nimbusのjar
  ・servletapiのjar
  ・commons-jexlのjar
  ・JBoss

▲実行       
  （１）nimbus、servletapi、commons-jexlのjarをlibフォルダに配置する
      例：\jboss\server\default\lib
        
  （２）JBossにwarファイルをデプロイする
      例：\jboss\server\default\deploy\schedule_console.war
        
  （３）JBossを起動する
        
  （４）Console画面を開く
      例：http://localhost:8080/schedule_console/


サンプル１

○目標
  サービスをサーブレットコンテナにデプロイしてみよう。

○リソース一覧
  ・Webアプリケーションアーカイブ
    sample.war
    
    ・サービス定義ファイル
      sample.war\service-definition.xml
    ・Webアプリケーション配置記述子ファイル
      sample.war\WEB-INF\web.xml
    ・サービスクラスのソースファイル
      sample.war\WEB-INF\classes\sample\service\POJOService.java

○用意するもの
  ・NimbusのJar
  ・サーブレットコンテナ（このサンプルではJBossを使用する）

○実行
  （１）コンパイルする。
      例：
        javac -d sample.war\WEB-INF\classes -classpath nimbus.jar sample.war\WEB-INF\classes\sample\service\POJOService.java

  
  （２）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （３）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （４）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.warフォルダをコピーする
  
  （５）JBossのJMXコンソールで確認する
      例：
        ブラウザで、http://localhost:8080/jmx-console/にアクセスする。
        JMXコンソールのNimbusドメインに、JMXオブジェクト名
        class=sample.service.POJOService,name=Service1
        として、Nimbusに登録したサービスがMBeanとして登録されている事が確認できる。
  
  （６）JBossからアンデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployからsample.warフォルダを削除する
  
  （７）JBossのJMXコンソールで確認する
      例：
        ブラウザで、http://localhost:8080/jmx-console/にアクセスする。
        JMXコンソールのNimbusドメインがなくなっている事が確認できる。

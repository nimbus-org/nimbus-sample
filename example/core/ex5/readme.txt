
サンプル５

○目標
  サービスをJMXサーバに登録してみよう。

○リソース一覧
  ・JBossサービスアーカイブ
    sample.sar
    
    ・サービス定義ファイル
      sample.sar\service-definition.xml
    ・JBossサービス定義ファイル
      sample.sar\META-INF\jboss-service.xml
    ・サービスクラスのソースファイル
      sample.sar\sample\service\POJOService.java
      sample.sar\sample\service\POJOService2.java
      sample.sar\sample\service\POJOService2MBean.java

○用意するもの
  ・NimbusのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar sample\service\*.java
  
  （２）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （３）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （４）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.sarフォルダをコピーする
  
  （５）JBossのJMXコンソールで確認する
      例：
        ブラウザで、http://localhost:8080/jmx-console/にアクセスする。
        JMXコンソールのNimbusドメインに、JMXオブジェクト名
        class=sample.service.POJOService,name=Service1
        として、Nimbusに登録したサービスがMBeanとして登録されている事が確認できる。
  
  （６）JBossからアンデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployからsample.sarフォルダを削除する
  
  （７）JBossのJMXコンソールで確認する
      例：
        ブラウザで、http://localhost:8080/jmx-console/にアクセスする。
        JMXコンソールのNimbusドメインがなくなっている事が確認できる。

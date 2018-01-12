
サンプル２

○目標
 リモートのサービスをEJBを経由して呼び出してみよう。
 EJBを経由して呼び出す事で、EJBコンテナの持つ流量制御やクラスタリングの機能を
 利用できるようになる。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・JBossサービスアーカイブ
    sample.sar
    
    ・サービス定義ファイル
      sample.sar\service-definition.xml
    ・JBossサービス定義ファイル
      sample.sar\META-INF\jboss-service.xml
    ・サービスクラスのソースファイル
      sample.sar\sample\service\Messenger.java
      sample.sar\sample\service\POJOService.java
  ・EJBアーカイブ
    sample.jar
    
    ・EJB配置記述子ファイル
      sample.sar\META-INF\ejb-jar.xml
    ・JBoss用EJB配置記述子ファイル
      sample.sar\META-INF\jboss.xml

○用意するもの
  ・NimbusのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -d sample.sar sample.sar\sample\service\*.java
        javac -classpath sample.sar;nimbus.jar Main.java
  
  （２）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （３）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （４）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.sarフォルダをコピーする
        C:\JBoss-3.2.7\server\default\deployにsample.jarフォルダをコピーする
   
  （５）Mainクラスを実行する。
      例：
        java -classpath .;sample.sar;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main


サンプル３

○目標
 リモートのMBeanを呼び出してみよう。

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
      sample.sar\sample\service\POJOService.java
      sample.sar\sample\service\POJOServiceMBean.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
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
   
  （５）Mainクラスを実行する。
      例：
        java -classpath .;sample.sar;nimbus.jar;jmx.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main

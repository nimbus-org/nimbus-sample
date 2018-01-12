
サンプル１

○目標
 Nimbus IOCを使ってみよう。
 クライアントプログラムで、トランザクションの制御を行いながら、Beanフローを実行する。

○リソース一覧
  ・IOC呼び出しサービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・IOC EJB Jar
    ioc-facade.jar
    
    ・EJB配置記述子ファイル
      ioc-facade.jar\META-INF\ejb-jar.xml
    ・JBoss用EJB配置記述子ファイル
      ioc-facade.jar\META-INF\jboss.xml
  ・IOCサービスアーカイブ
    nimbus.sar
    
    ・JBoss用サービスアーカイブ配置記述子ファイル
      nimbus.sar\META-INF\jboss.xml
    ・IOCサービス定義ファイル
      nimbus.sar\service-definition.xml

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・Jakarta Commons JexlのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath nimbus.jar Main.java
  
  （２）JBossに必要なJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
        C:\JBoss-3.2.7\server\default\libにJakarta Commons JexlのJarファイルをコピーする
  
  （３）JBossにデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにioc-facade.jarフォルダをコピーする
        C:\JBoss-3.2.7\server\default\deployにnimbus.sarフォルダをコピーする
  
  （４）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
   
  （５）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main

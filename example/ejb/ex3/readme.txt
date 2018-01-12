
サンプル３

○目標
 特定のEJB(EJB2.X)を呼び出す複数のサービスをグルーピングしてみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java
  ・サンプル EJB Jar
    sample.jar
    
    ・EJB配置記述子ファイル
      sample.jar\META-INF\ejb-jar.xml
    ・JBoss用EJB配置記述子ファイル
      sample.jar\META-INF\jboss.xml
    ・EJBクラスのソースファイル
      sample.jar\sample\ejb\Messenger.java
      sample.jar\sample\ejb\MessengerHome.java
      sample.jar\sample\ejb\MessengerHome2.java
      sample.jar\sample\ejb\MessengerBean.java
      sample.jar\sample\ejb\MessengerBean2.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath C:\JBoss-3.2.7\client\jboss-j2ee.jar sample\ejb\*.java
        javac -classpath C:\JBoss-3.2.7\client\jboss-j2ee.jar;nimbus.jar;sample.jar Main.java
  
  （２）JBossにNimbusのJarファイルを置く。
      例：
        C:\JBoss-3.2.7\server\default\libにNimbusのJarファイルをコピーする
  
  （３）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
  
  （４）JBossにホットデプロイする。
      例：
        C:\JBoss-3.2.7\server\default\deployにsample.jarフォルダをコピーする
   
  （５）Mainクラスを実行する。
      例：
        java -classpath .;sample.jar;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main

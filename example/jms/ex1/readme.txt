
サンプル１

○目標
 JMSコネクションを簡単に取得してみよう。
 JMSキューを使ってメッセージを送受信してみよう。

○リソース一覧
  ・サービス定義ファイル
    service-definition.xml
  ・サンプル実行クラスのソースファイル
    Main.java

○用意するもの
  ・NimbusのJar
  ・JMXのJar
  ・JBoss

○実行
  （１）コンパイルする。
      例：
        javac -classpath C:\JBoss-3.2.7\client\jboss-j2ee.jar;nimbus.jar Main.java
  
  （２）JBossを起動する。
      例：
        C:\JBoss-3.2.7\bin\run.bat
   
  （３）Mainクラスを実行する。
      例：
        java -classpath .;nimbus.jar;C:\JBoss-3.2.7\client\jbossall-client.jar Main

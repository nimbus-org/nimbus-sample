
サンプル１

○目標
 TomcatでWebsocketを動かしてみよう

○リソース一覧
  ・サンプルWebアプリケーション
    websocket ※WAR(Web application ARchive)ファイル一式
    
    定義ファイル
     ・websocket\WEB-INF\web.xml
       Webアプリケーション設定ファイル
     ・websocket\WEB-INF\classes\service-definition.list
       サービス定義リストファイル
     ・websocket\WEB-INF\classes\service_websocket.xml
       Websocketサービス定義ファイル

○用意するもの
  ・Tomcatサーバ
  jarファイル（websocket\WEB-INF\libに配置する）
  ・nimbus.jar
  ・nimbus-websocket.jar
  ・log4j.jar
  ・commons-logging.jar
  ・javax.websocket-api.jar（コンパイルに必要）

○実行
  （１）コンパイルする。websocket\WEB-INF\classesで実行する。
      例：
        javac -classpath nimbus.jar;nimbus-websocket.jar;javax.websocket-api.jar; jp\ossc\nimbus\service\websocket\*.java
   
  （２）Tomcatを起動する。
  
  （３）http://tomcatサーバIP:ポート/websocket/websocket.htmlにアクセスする。


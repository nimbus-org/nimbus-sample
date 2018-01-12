# nimbus-sample

nimbusを使ったサンプル

# サンプル一覧

<pre>

Nimbus サンプル集
│
├ 基本機能
│  │
│  ├ core：DIコンテナ
│  │  │
│  │  ├サンプル１：サービス定義ファイルに、サービスを登録して、サービスを取得してみよう。
│  │  ├サンプル２：サービス定義ファイルでインジェクションしてみよう。
│  │  ├サンプル３：サービスをファクトリ化してみよう。
│  │  ├サンプル４：サービスをJBoss Application Serverにデプロイしてみよう。
│  │  ├サンプル５：サービスをJMXサーバに登録してみよう。
│  │  ├サンプル６：変数をサービス定義から参照してみよう。
│  │  ├サンプル７：サービス定義を条件に応じて切り替えてみよう。
│  │  ├サンプル８：サービス定義ファイルをスタンドアローンに読み込もう。
│  │  └サンプル９：サービス定義ファイルをテンプレート化してみよう。
│  │
│  ├ beans：Java Beans
│  │  │
│  │  ├サンプル１：Beanと文字列の相互変換をしてみよう。
│  │  ├サンプル２：Beanの様々なプロパティに、汎用的にアクセスしてみよう。
│  │  ├サンプル３：汎用的なBean（データセット）を動的に定義して使ってみよう。
│  │  └サンプル４：汎用的なBean（データセット）をコンクリートなクラスにしたソースを自動生成してみよう。
│  │
│  ├ message：メッセージ
│  │  │
│  │  ├サンプル１：メッセージを管理してみよう。
│  │  └サンプル２：メッセージを国際化対応してみよう。
│  │
│  ├ writer：ライター
│  │  │
│  │  ├サンプル１：メッセージをフォーマットして、コンソールに出力してみよう。
│  │  ├サンプル２：マップをフォーマットして、コンソールに出力してみよう。
│  │  ├サンプル３：フォーマットと出力を隠蔽して、コンソールに出力してみよう。
│  │  ├サンプル４：フォーマットと出力を隠蔽して、ファイルに出力してみよう。
│  │  ├サンプル５：ファイルとコンソールに同時に出力してみよう。
│  │  ├サンプル６：出力内容から条件判定をして出力方法を変えてみよう。
│  │  └サンプル７：任意のBeanをフォーマットして、コンソールに出力してみよう。
│  │
│  ├ log：ログ
│  │  │
│  │  ├サンプル１：ログをコンソールに出力してみよう。
│  │  ├サンプル２：ログをファイルに出力してみよう。
│  │  ├サンプル３：ログのフォーマットを変えてみよう。
│  │  ├サンプル４：ログにコンテキスト情報を出力してみよう。
│  │  ├サンプル５：独自のカテゴリを作ってログを出力してみよう。
│  │  ├サンプル６：Jakarta Commons Logging にプラグインしてログ出力してみよう。
│  │  ├サンプル７：カテゴリ毎に異なる出力先にログを出力してみよう。
│  │  └サンプル８：複数の出力先にログを出力してみよう。
│  │
│  ├ queue：キュー
│  │  │
│  │  ├サンプル１：キューを使ってみよう。
│  │  ├サンプル２：キューを使って非同期処理をしてみよう。
│  │  ├サンプル３：遅延キューを使ってみよう。
│  │  ├サンプル４：キューを永続化してみよう。
│  │  └サンプル５：JVM間でQueueを共有してみよう。
│  │ 
│  └ semaphore：セマフォ
│      │
│      └サンプル１：セマフォを使ってみよう。
│
├ 応用機能
│  │
│  ├ sequence：通番
│  │  │
│  │  ├サンプル１：通番を発行してみよう。
│  │  └サンプル２：発番した通番を永続化してみよう。
│  │
│  ├ journal：ジャーナル
│  │  │
│  │  ├サンプル１：ジャーナルを取得してみよう。
│  │  ├サンプル２：ジャーナルをCSV形式にしてみよう。
│  │  └サンプル３：ジャーナルを自由にフォーマットしてみよう。
│  │
│  ├ aop：アスペクト指向
│  │  │
│  │  ├サンプル１：静的アスペクトを使ってみよう。
│  │  ├サンプル２：動的アスペクトを使ってみよう。
│  │  ├サンプル３：例外を操作するインターセプタをアスペクトしてみよう。
│  │  ├サンプル４：流量を制御するインターセプタをアスペクトしてみよう。
│  │  ├サンプル５：非同期処理を行うインターセプタをアスペクトしてみよう。
│  │  ├サンプル６：性能測定インターセプタをアスペクトしてみよう。
│  │  ├サンプル７：同期インターセプタをアスペクトしてみよう。
│  │  ├サンプル８：モックインターセプタをアスペクトしてみよう。
│  │  ├サンプル９：ジャーナルインターセプタをアスペクトしてみよう。
│  │  └サンプル１０：リトライインターセプタをアスペクトしてみよう。
│  │
│  ├ proxy：プロキシ
│  │  │
│  │  ├サンプル１：リモートのサービスを呼び出してみよう。
│  │  ├サンプル２：リモートのサービスをEJBを経由して呼び出してみよう。
│  │  ├サンプル３：リモートのMBeanを呼び出してみよう。
│  │  ├サンプル４：リモートのサービスを呼び出す時にジャーナルを出力してみよう。
│  │  ├サンプル５：ローカルのサービスを呼び出す時にジャーナルを出力してみよう。
│  │  └サンプル６：リモートのサービスをクラスタ化して呼び出してみよう。
│  │
│  ├ cache：キャッシュ
│  │  │
│  │  ├サンプル１：メモリ中にキャッシュしてみよう。
│  │  ├サンプル２：ファイルにキャッシュしてみよう。
│  │  ├サンプル３：キャッシュからあふれさせてみよう。
│  │  └サンプル４：２次キャッシュにあふれさせてみよう。
│  │
│  ├ keepalive：死活監視
│  │  │
│  │  └サンプル１：JVMをクラスタ化してみよう。
│  │
│  ├ publish：メッセージ配信
│  │  │
│  │  ├サンプル１：TCPプロトコルで１対多でのメッセージ配信をしてみよう。
│  │  ├サンプル２：UDPプロトコルで１対多でのメッセージ配信をしてみよう。
│  │  ├サンプル３：コネクションをグルーピングして、１対多でのメッセージ配信をしてみよう。
│  │  ├サンプル４：コネクションを分散して、１対多でのメッセージ配信をしてみよう。
│  │  ├サンプル５：コネクションをクラスタ化して、１対多でのメッセージ配信をしてみよう。
│  │  ├サンプル６：TCPプロトコル上に独自通信プロトコルを作成して、１対多でのメッセージ配信をしてみよう。
│  │  └サンプル７：一対多での同期通信をしてみよう。
│  │
│  ├ context：コンテキスト
│  │  │
│  │  ├サンプル１：コンテキストにデータを格納してみよう。
│  │  ├サンプル２：スレッド毎にコンテキストにデータを格納してみよう。
│  │  ├サンプル３：サーバの情報コンテキストから取得してみよう。
│  │  ├サンプル４：複数のコンテキストをグルーピングしてみよう。
│  │  ├サンプル５：JVM間でコンテキストを共有してみよう。
│  │  ├サンプル６：JVM間でコンテキストを分散共有してみよう。
│  │  └サンプル７：JVM間でコンテキストを共有して、トランザクション更新してみよう。
│  │
│  ├ codemaster：コードマスター
│  │
│  ├ interpreter：インタープリター
│  │  │
│  │  ├サンプル１：Javaをインタープリット実行してみよう。
│  │  ├サンプル２：コマンドベースで、Javaをインタープリット実行してみよう。
│  │  └サンプル３：コマンドベースで、別VM上でJavaをインタープリット実行してみよう。
│  │
│  ├ system：システム
│  │  │
│  │  └サンプル１：マシンリソースを取得してみよう。
│  │
│  ├ http：HTTP
│  │  │
│  │  ├サンプル１：HTTP通信でインターネットにアクセスしてHTMLを取得してみよう。
│  │  └サンプル２：HTTP通信でPOSTして、XMLを取得してみよう。
│  │
│  ├ ftp：FTP
│  │  │
│  │  └サンプル１：FTP通信をしてみよう。
│  │
│  └ graph：グラフ
│      │
│      ├サンプル１：チャート画像を生成してみよう。
│      └サンプル２：ローソクチャート画像を生成してみよう。
│
├ フレームワーク
│  │
│  ├ beancontrol：業務フロー
│  │  │
│  │  ├サンプル１：業務フローをXML定義で制御してみよう。
│  │  ├サンプル２：業務フローのジャーナルを出力してみよう。
│  │  ├サンプル３：業務フローで並列処理を実行してみよう。
│  │  └サンプル４：業務フローで分散処理を実行してみよう。
│  │
│  ├ ioc：IOC
│  │  │
│  │  └サンプル１：Nimbus IOCを使ってみよう。
│  │
│  ├ scheduler：スケジューラー
│  │  │
│  │  ├サンプル１：スケジューラーを使ってみよう。
│  │  ├サンプル２：日付によって異なるスケジューラを起動してみよう。
│  │  ├サンプル３：スケジュールの状態を保存してみよう。
│  │  └サンプル４：スケジュールをデータベースで管理してみよう。
│  │
│  ├ scheduler2：スケジューラー２
│  │  │
│  │  ├サンプル１：スケジューラーを使ってみよう。
│  │  ├サンプル２：スケジュールをデータベースで管理してみよう。
│  │  ├サンプル３：Scheduler2サービスを使って、Console画面を操作しよう。
│  │  └サンプル４：スケジューラーを使って集配信を管理してみよう。
│  │
│  ├ server：サーバー
│  │  │
│  │  └サンプル１：サーバーを立ててソケット通信でアプリケーションを呼び出してみよう。
│  │
│  └ ga：遺伝的アルゴリズム
│      │
│      └サンプル１：遺伝的アルゴリズムを使ってみよう。
│
├ Java規格支援機能
│  │
│  ├ connection：JDBC
│  │  │
│  │  ├サンプル１：JDBC(Java Data Base Connectivity)コネクションを取得してみよう。
│  │  ├サンプル２：JCA(Java Connector Architecture)を使ってJDBCコネクションを取得してみよう。
│  │  ├サンプル３：JDBCコネクションをラップして機能を付加してみよう。
│  │  ├サンプル４：データベースにテーブルを作ってデータを準備してみよう。
│  │  ├サンプル５：POJOとSQLでO/R Mappingしてみよう。
│  │  ├サンプル６：POJOとSQLライクなクエリでO/R Mappingしてみよう。
│  │  ├サンプル７：CSVファイルからデータベースに書き込んでみよう。
│  │  ├サンプル８：データセットを使ってCSVファイルからデータベースに書き込んでみよう。
│  │  └サンプル９：２つのデータベースを同期してみよう。
│  │
│  ├ jndi：JNDI
│  │  │
│  │  ├サンプル１：JNDIに簡単にアクセスしてみよう。
│  │  └サンプル２：JNDIリモートオブジェクトをキャッシュしてみよう。
│  │
│  ├ jms：JMS
│  │  │
│  │  ├サンプル１：JMSコネクションを簡単に取得してみよう。
│  │  ├サンプル２：JMSセッションを簡単に取得してみよう。
│  │  ├サンプル３：JMSメッセージプロデューサを簡単に取得してみよう。
│  │  └サンプル４：JMSメッセージコンシューマを簡単に取得してみよう。
│  │
│  ├ ejb：EJB
│  │  │
│  │  ├サンプル１：任意のEJB(EJB2.X)を簡単に呼び出してみよう。
│  │  ├サンプル２：特定のEJB(EJB2.X)を簡単に呼び出してみよう。
│  │  └サンプル３：特定のEJB(EJB2.X)を呼び出す複数のサービスをグルーピングしてみよう。
│  │
│  ├ servlet：サーブレット
│  │  │
│  │  ├サンプル１：サービスをサーブレットコンテナにデプロイしてみよう。
│  │  ├サンプル２：Nimbusコンソールを使ってみよう。
│  │  ├サンプル３：サーブレットフィルタからインターセプタを呼び出してみよう。
│  │  ├サンプル４：2バイト文字のPOSTパラメータが文字化けしないようにしてみよう。
│  │  ├サンプル５：HTTPリクエストを検証してみよう。
│  │  ├サンプル６：リクエスト属性にサービスを設定してみよう。
│  │  ├サンプル７：アクセスジャーナルを取得してみよう。
│  │  └サンプル８：Webアプリケーションを業務フローで作ってみよう。
│  │
│  ├ transaction：JTA
│  │
│  └ jmx：JMX
│      │
│      └サンプル１：JMXでJVMのヒープを監視してみよう。
│
└ ユーティリティ機能
    │
    ├ io：I/O
    │  │
    │  ├サンプル１：CSVファイルを読み書きしてみよう。
    │  ├サンプル２：データセットを使って、CSVファイルを読み書きしてみよう。
    │  ├サンプル３：FLV（Fixed Length Value：固定長）ファイルを読み書きしてみよう。
    │  └サンプル４：データセットを使って、FLV（Fixed Length Value：固定長）ファイルを読み書きしてみよう。
    │
    ├ converter：変換
    │  │
    │  ├サンプル１：文字列を変換してみよう。
    │  ├サンプル２：業務フローで自由に変換してみよう。
    │  ├サンプル３：BeanとJSONストリームを相互変換してみよう。
    │  ├サンプル４：データセットとJSONストリームを相互変換してみよう。
    │  ├サンプル５：データセットとXMLストリームを相互変換してみよう。
    │  ├サンプル６：HTMLストリームとDOM（Document Object Model）を相互変換してみよう。
    │  ├サンプル７：XMLストリームを任意のデータセットに変換してみよう。
    │  └サンプル８：HTMLストリームを任意のデータセットに変換してみよう。
    │
    ├ validator：検証
    │  │
    │  ├サンプル１：色々な値の検証をしてみよう。
    │  ├サンプル２：データベース上のマスタを使って、値の検証をしてみよう。
    │  └サンプル３：業務フローで、自由に検証してみよう。
    │
    └ crypt：暗号
        │
        └サンプル１：暗号化してみよう。

</pre>

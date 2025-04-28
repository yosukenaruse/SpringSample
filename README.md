# SpringSample

Spring BootとMyBatisを使用したサンプルプロジェクト

## 使用技術
- Java 17
- Spring Boot 3.2.3
- MyBatis 3.0.3
- SQLite
- Gradle
- Spring Boot DevTools

## 環境構築手順

### 1. 必要なソフトウェアのインストール
- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Gradle](https://gradle.org/install/)
- [SQLite](https://www.sqlite.org/download.html)

### 2. プロジェクトのクローン
```bash
git clone https://github.com/yosukenaruse/SpringSample.git
cd SpringSample
```

### 3. データベースの準備
1. SQLiteデータベースファイルの配置
   - `/Users/yosuke.naruse/develop/SQLite/sample1/sample.sqlite`に配置
   - または、`application.properties`の`spring.datasource.url`を適宜変更

2. テーブルの作成
```sql
CREATE TABLE t_sample(id INTEGER PRIMARY KEY, name TEXT NOT NULL);
```

### 4. アプリケーションの起動
```bash
gradle bootRun
```

### 5. ホットデプロイの設定
- アプリケーション起動中にJavaファイルを変更すると、自動的に再起動されます
- 静的ファイル（HTML, CSS, JavaScript等）は即時反映されます
- 再起動を除外するファイルは`application.properties`で設定可能です

## 機能
- サンプルデータの検索
  - 全件取得
  - 名前による部分一致検索

## Gradleコマンド

### アプリケーションの起動
```bash
gradle bootRun
```

### ビルド
```bash
gradle build
```

### テストの実行
```bash
gradle test
```

### 依存関係の更新
```bash
gradle build --refresh-dependencies
```

### クリーンビルド
```bash
gradle clean build
```

### Hot Reload
```bash
gradle build --continuous
gradle bootRun 
```

## Todo
- エラーハンドリング
- ロギングAOP
- テストスクリプト
- 入力チェック
- Upsert処理
- 静的ファイル配置

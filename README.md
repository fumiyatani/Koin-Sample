# Koin-Sample
Koinを使ってDIを試してみようという趣旨のサンプル

## 機能
- GitHubのAPIからリポジトリ一覧を取得する
- 取得したリポジトリ一覧をRecyclerViewで表示する

## アプリの主な構成
#### アーキテクチャ
MVVMを採用
- ViewModel
- LiveData
- DataBinding
を使用して実現しています。

#### API通信
- Retrofit2
- Moshi

#### 画面周り
- Navigation Component
- RecyclerView

## これからやること
- Android DevelopersのDagger Hiltの説明をKoinで実装する
  - [この辺り](https://developer.android.com/training/dependency-injection?hl=ja)
- テストコードを書く
- 機能拡充
  - DB登録(検索履歴とか）
  - 詳細画面作成

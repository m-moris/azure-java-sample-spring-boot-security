# Spring Boot and OAuth2 with Azure Active Directory for Java

Spring Boot Security と Azure Active Dicretory (AAD) を組み合わせた認証サンプルです。Azure Active Directory上に任意のテナントと組織アカウントを作成しAADを使って認証し、Webアプリにアクセスします。

## 必要なもの

* Azure サブスクリプション

## 準備

以下のURLの「認証とディレクトリ アクセスを構成する」を参考にWebアプリケーションの登録を行います。

* [AAD](https://docs.microsoft.com/ja-jp/azure/app-service-web/web-sites-dotnet-lob-application-azure-ad)

Webアプリケーションの登録が終わると、以下の3つの情報が手に入ります。

* テナントID
* クライアントID
* クライアントキー

それらの情報を ```src/main/resources/application.yaml``` に埋め込みます。```src/main/resources/application.orig.yaml``` をコピーして使ってください。

```yaml
security:
  oauth2:
    client:
      clientId: <<your client id >>
      clientSecret: <<your client key>>
      accessTokenUri: https://login.microsoftonline.com/<<your tenant id>>/oauth2/token
      userAuthorizationUri: https://login.microsoftonline.com/<<your tenant id>/oauth2/authorize
      clientAuthenticationScheme: form
      scope: read
    resource:
      preferTokenInfo: false
      userInfoUri: https://graph.windows.net/me?api-version=1.6

...

aad:
  resource: https://graph.windows.net
```

## 実行

以下のコマンドで実行できます。http://localhost:8080/ へアクセスしてください。

```
$ bower install
$ mvn spring-boot:run
```

実行してブラウザを開くと、Login画面が表示されます。Loginボタンを押すと、AADの認証画面に遷移するので、AADで有効なユーザーで認証してみてください。認証が成功するとユーザデータが表示されます。


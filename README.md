# Spring Boot and OAuth2 with Azure Active Directory

[Japanese](./README.ja.md)

Sample application of Spring Boot Security and Azure Active Directory.

## Requirements

* Azure subscription

## Preparation

You configure authentication and directory access. Please refer to the following URL.

[Create a line-of-business Azure app with Azure Active Directory authentication](https://docs.microsoft.com/en-us/azure/app-service-web/web-sites-dotnet-lob-application-azure-ad)

When you register web application into AAD. You will get following informations.

* Tenant id
* Client id
* Client key (Secred key)

You embed these id/key into application.yaml.

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

## Execution
You can execute the following commands.

```sh
$ bower install
$ mvn spring-boot:run
```

* Open http://localhost:8080/
* Click login button.
* Redirect authentication page and logi it.
* The login uers's information will be displayed.






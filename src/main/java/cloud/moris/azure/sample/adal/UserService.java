package cloud.moris.azure.sample.adal;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private OAuth2RestTemplate oauth2;

    private final RestTemplate restTemplate;

    private static String LIST_USERS = "https://graph.windows.net/myorganization/users?api-version=1.6";

    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String listUsers() {
        RequestEntity<Void> entity = RequestEntity
                .get(URI.create(LIST_USERS))
                .header("Authorization", "Bearer " + oauth2.getAccessToken())
                .build();
        ResponseEntity<String> exchange = this.restTemplate.exchange(entity, String.class);
        return exchange.getBody();
    }
}
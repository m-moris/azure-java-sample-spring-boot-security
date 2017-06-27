package cloud.moris.azure.sample.adal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.RequestEnhancer;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

@Component
public class AzureRequestEnhancer implements RequestEnhancer {
    
    @Value("${aad.resource:null}")
    private String aadResource;

    @Override
    public void enhance(AccessTokenRequest request, OAuth2ProtectedResourceDetails resource, MultiValueMap<String, String> form, HttpHeaders headers) {
        if (!StringUtils.isEmpty(aadResource)) {
            form.set("resource", aadResource);
        }
    }
}
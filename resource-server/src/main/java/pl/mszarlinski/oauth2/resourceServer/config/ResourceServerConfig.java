package pl.mszarlinski.oauth2.resourceServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author mszarlinski on 2015-10-12.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "person";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .regexMatchers(HttpMethod.GET, "/person").permitAll()
            .regexMatchers(HttpMethod.POST).access("#oauth2.hasScope('write')")
            .anyRequest().authenticated()
            .and()
            .csrf().disable();
    }

    @Bean
    public RemoteTokenServices remoteTokenServices(
        final @Value("${auth.server.checkTokenUrl}") String checkTokenUrl,
        final @Value("${auth.server.clientId}") String clientId,
        final @Value("${auth.server.clientSecret}") String clientSecret) {

        final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(checkTokenUrl);
        remoteTokenServices.setClientId(clientId);
        remoteTokenServices.setClientSecret(clientSecret);
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

}

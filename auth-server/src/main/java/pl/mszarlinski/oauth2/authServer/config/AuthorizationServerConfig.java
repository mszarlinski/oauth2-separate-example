package pl.mszarlinski.oauth2.authServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

/**
 * @author mszarlinski on 2015-10-12.
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private static final String RESOURCE_ID = "person";

    private static final String CLIENT_ID = "resource-server";

    private static final String SECRET = "secret";

    private static final String PASSWORD_GRANT_TYPE = "password";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(CLIENT_ID)
                .secret(SECRET)
                .authorizedGrantTypes(PASSWORD_GRANT_TYPE)
                .resourceIds(RESOURCE_ID)
                .scopes("read", "write");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.authenticationManager(authenticationManager).accessTokenConverter(
                defaultAccessTokenConverter());
    }

    @Bean
    public DefaultAccessTokenConverter defaultAccessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("authenticated"); // enable '/oauth/check_token' endpoint
    }
}

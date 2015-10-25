package pl.mszarlinski.oauth2.authServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static java.util.Arrays.asList;

/**
 * Created by Maciej on 2015-10-16.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ROLE_USER = "ROLE_USER";
    private static final String ROLE_KILLER = "ROLE_KILLER";

    @Autowired
    protected void registerAuthentication(
            final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(
                asList(
                        User.create("mszarl", "secret", ROLE_USER),
                        User.create("killer", "killer", ROLE_KILLER)));
    }


}


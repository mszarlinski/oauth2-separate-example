package pl.mszarlinski.oauth2.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 REQUEST TO OBTAIN A TOKEN:

 curl -X POST -H "Authorization: Basic cmVzb3VyY2Utc2VydmVyOnNlY3JldA=="
 -H "Cache-Control: no-cache" -H "Postman-Token: 2b8fe5ee-ec3f-fc53-5ea8-e19b6ca4c489"
 -H "Content-Type: application/x-www-form-urlencoded"
 -d 'username=mszarl&password=secret&client_id=resource-server&client_secret=&grant_type=password&'
 'http://localhost:9999/auth-server/oauth/token'

 REQUEST TO CHECK A TOKEN:

 curl -X POST -H "Authorization: Basic cmVzb3VyY2Utc2VydmVyOnNlY3JldA=="
 -H "Cache-Control: no-cache" -H "Postman-Token: 8380b2c4-8c65-2294-7a38-dd9388c9f953"
 'http://localhost:9999/auth-server/oauth/check_token?token=c159efe2-4a2a-43d0-a779-c9b2a917f673'
 */
@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}

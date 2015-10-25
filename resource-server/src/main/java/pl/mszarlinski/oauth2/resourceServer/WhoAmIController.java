package pl.mszarlinski.oauth2.resourceServer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Maciej on 2015-10-16.
 */
@RestController
public class WhoAmIController {
    /**
    curl --request GET \
      --url http://localhost:8080/whoAmI \
      --header 'authorization: Bearer bcf11c6d-dfe7-4fb7-8213-cc521e16836d' \
      --header 'cache-control: no-cache' \
      --header 'postman-token: 4a36c0d0-cdca-ddd7-54ff-7c9abd8e694b'
     */
    @PreAuthorize("authenticated")
    @RequestMapping("/whoAmI")
    public String whoAmI( final Principal principal) {
        return principal.getName();
    }
}

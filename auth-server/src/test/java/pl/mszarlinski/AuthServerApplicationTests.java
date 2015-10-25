package pl.mszarlinski;

import pl.mszarlinski.oauth2.authServer.AuthServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthServerApplication.class)
@WebAppConfiguration
public class AuthServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}

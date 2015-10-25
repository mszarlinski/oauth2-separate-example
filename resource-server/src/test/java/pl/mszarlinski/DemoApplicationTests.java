package pl.mszarlinski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.mszarlinski.oauth2.resourceServer.ResourceServerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ResourceServerApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}

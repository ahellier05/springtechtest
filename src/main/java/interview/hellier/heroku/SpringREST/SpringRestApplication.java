package interview.hellier.heroku.SpringREST;

import interview.hellier.heroku.SpringREST.Config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
		LOG.info("Heroku API started");
	}

}

package interview.hellier.heroku.SpringREST.Config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Config class to create rest template bean which can be instantiated for use
 * in Service class to make HTTP calls
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */

@Configuration
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    /**
     * Method to create spring bean rest template using rest template builder for scope across
     * application
     * @param restTemplateBuilder
     * @return restTemplateBuilder with read and connect properties set
     */

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

}

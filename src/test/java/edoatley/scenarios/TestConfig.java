package edoatley.scenarios;

import edoatley.ds.DefaultNumberGenerator;
import edoatley.ds.NumberGenerator;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    NumberGenerator numberGenerator() {
        return new TestNumberGenerator();
    }
}

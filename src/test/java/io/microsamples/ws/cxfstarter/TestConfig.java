package io.microsamples.ws.cxfstarter;

import io.microsamples.ws.cxfstarter.config.ClientConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@TestConfiguration
@PropertySources({
        @PropertySource("classpath:application.properties")
})
@Import({ClientConfiguration.class})
public class TestConfig {
}

package ar.curiosidadesespaciales.homebeat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@Profile("dev")
public class DevTrigger implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final HomeBeatService service;

    @Autowired
    public DevTrigger(HomeBeatService service) {
        this.service = service;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        logger.info("⌨️ Triggering service on startup due to dev profile");
        service.beat(ZonedDateTime.now());
        logger.info("⌨️ Done!");
    }
}
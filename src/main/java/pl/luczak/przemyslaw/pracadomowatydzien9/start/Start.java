package pl.luczak.przemyslaw.pracadomowatydzien9.start;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

    }

}

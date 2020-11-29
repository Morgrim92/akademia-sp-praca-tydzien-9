package pl.luczak.przemyslaw.pracadomowatydzien9.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.luczak.przemyslaw.pracadomowatydzien9.model.User;
import pl.luczak.przemyslaw.pracadomowatydzien9.service.CsvUserService;
import pl.luczak.przemyslaw.pracadomowatydzien9.service.UserMongoService;

import java.util.List;
import java.util.Optional;

@Component
public class Start {

    private final UserMongoService userRepository;
    private final CsvUserService csvUserService;

    @Autowired
    public Start(UserMongoService userRepository, CsvUserService csvUserService) {
        this.userRepository = userRepository;
        this.csvUserService = csvUserService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        List<User> users = loadDataToApplication();
        userRepository.saveAll(users);
        userRepository.getAllUsers();
    }

    private List<User> loadDataToApplication() {
        Optional<List<List<String>>> userListFile = csvUserService.loadUserCsv("src/main/resources/MOCK_DATA.csv");
        return csvUserService.mongoListToUser(userListFile.get());
    }

}

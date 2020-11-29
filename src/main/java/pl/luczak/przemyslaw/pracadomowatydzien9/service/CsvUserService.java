package pl.luczak.przemyslaw.pracadomowatydzien9.service;

import org.springframework.stereotype.Service;
import pl.luczak.przemyslaw.pracadomowatydzien9.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CsvUserService {

    public Optional<List<List<String>>> loadUserCsv(String path){
        List<List<String>> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                users.add(Arrays.asList(values));
            }
            return Optional.of(users);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<User> mongoListToUser(List<List<String>> list){
        List<User> userList = new ArrayList<>();
        list.forEach(user -> userList.add(new User(
                user.get(0),
                user.get(1),
                user.get(2))));

        return userList;
    }

}

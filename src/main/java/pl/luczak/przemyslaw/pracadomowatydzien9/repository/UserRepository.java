package pl.luczak.przemyslaw.pracadomowatydzien9.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.luczak.przemyslaw.pracadomowatydzien9.model.User;

@Repository
public interface UserRepository extends MongoRepository <User, Long> {
}

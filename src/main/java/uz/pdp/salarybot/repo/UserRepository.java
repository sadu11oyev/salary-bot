package uz.pdp.salarybot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.salarybot.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByPhone(String phoneNumber);

    User findByChatId(Long id);
}
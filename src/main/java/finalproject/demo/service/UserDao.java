package finalproject.demo.service;


import finalproject.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserInfo, Integer> {
    UserInfo findByUsername(String username);
}

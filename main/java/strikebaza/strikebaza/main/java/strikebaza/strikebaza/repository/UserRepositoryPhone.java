package strikebaza.strikebaza.repository;

import strikebaza.strikebaza.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPhone extends JpaRepository<User, Integer> {
    User findByPhone(String phone);
}
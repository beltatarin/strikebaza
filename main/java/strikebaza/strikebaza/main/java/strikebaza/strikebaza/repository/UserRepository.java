package strikebaza.strikebaza.repository;

import strikebaza.strikebaza.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
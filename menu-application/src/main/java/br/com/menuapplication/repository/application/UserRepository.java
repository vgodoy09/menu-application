package br.com.menuapplication.repository.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.menuapplication.model.application.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

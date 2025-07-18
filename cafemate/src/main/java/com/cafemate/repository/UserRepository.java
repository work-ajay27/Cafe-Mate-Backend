package com.cafemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.cafemate.entity.User;

public interface UserRepository extends JpaRepository<User, ID> {
	User findByEmail(String email);
}

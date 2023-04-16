package com.example.boardproject.persistence;

import com.example.boardproject.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}

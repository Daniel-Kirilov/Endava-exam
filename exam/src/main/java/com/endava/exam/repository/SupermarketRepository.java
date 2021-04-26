package com.endava.exam.repository;

import com.endava.exam.model.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, String> {
    Optional<Supermarket> findById(String id);

    boolean existsByName(String name);
}

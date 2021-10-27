package com.example.jewerlystore.repository;

import com.example.jewerlystore.model.Client;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findById(Long id);
}

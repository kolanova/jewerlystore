package com.example.jewerlystore.repository;

import com.example.jewerlystore.model.Jewel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface JewelRepository extends JpaRepository<Jewel, String> {
    Jewel findJewelById(Long id);
    void deleteById(Long id);
}

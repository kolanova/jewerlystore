package com.example.jewerlystore.repository;

import com.example.jewerlystore.model.Store;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
    Store findStoreById(Long id);
    Store findStoreByName(String name);
    void deleteStoreById(String valueOf);
}

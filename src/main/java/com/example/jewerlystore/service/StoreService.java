package com.example.jewerlystore.service;

import com.example.jewerlystore.model.Store;
import com.example.jewerlystore.repository.StoreRepository;
import com.example.jewerlystore.request.StoreCreationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {
    StoreRepository storeRepository;
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    //find all
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
    //find by id
    public Store getStoreById(Long id){
        return  storeRepository.findStoreById(id);
    }
    public List<Store> createStore(List<StoreCreationRequest> storeCreationRequestList){
        List<Store> newStoreList = new ArrayList<>();
        Store newStore;
        for (StoreCreationRequest storeCreationRequest:storeCreationRequestList){
            newStore=Store.builder()
                    .name(storeCreationRequest.getName())
                    .build();
            storeRepository.save(newStore);
            newStoreList.add(newStore);
        }
        return newStoreList;
    }
    //update store
    public Store  updateStoreById(Long id, String name) {
        Store storeToUpdate=this.getStoreById(id);
        storeToUpdate.setName(name);
        storeRepository.save(storeToUpdate);
        return storeToUpdate;
    }
    //delete by id
    public void deleteStoreById(Long id) {
        this.getStoreById(id);
        storeRepository.deleteStoreById(String.valueOf(id));
    }

}

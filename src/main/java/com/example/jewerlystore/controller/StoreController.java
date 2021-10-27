package com.example.jewerlystore.controller;

import com.example.jewerlystore.model.Client;
import com.example.jewerlystore.model.Store;
import com.example.jewerlystore.request.ClientCreationRequest;
import com.example.jewerlystore.request.StoreCreationRequest;
import com.example.jewerlystore.request.UpdateClientNameRequest;
import com.example.jewerlystore.request.UpdateStoreNameRequest;
import com.example.jewerlystore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
@Validated
public class StoreController {
    @Autowired
    StoreService storeService;
    @GetMapping
    public Store getStoreById(@PathVariable Long id){
        return storeService.getStoreById(id);
    }
    @PostMapping
    public List<Store> createStore(@RequestBody @Valid List<StoreCreationRequest>storeCreationRequest){
        return storeService.createStore(storeCreationRequest);
    }
    @PutMapping
    public Store updateStoreName(@PathVariable(value = "id")Long id, @RequestBody UpdateStoreNameRequest updateStoreNameRequest){
        return storeService.updateStoreById(id, updateStoreNameRequest.getName());
    }
    @DeleteMapping
    public void deleteById(@PathVariable(value = "id")Long id){storeService.deleteStoreById(id);}

}

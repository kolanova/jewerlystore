package com.example.jewerlystore.service;

import com.example.jewerlystore.model.Jewel;
import com.example.jewerlystore.repository.JewelRepository;
import com.example.jewerlystore.request.JewelCreationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JewelService {
    JewelRepository jewelRepository;
    public JewelService(JewelRepository jewelRepository){
        this.jewelRepository =jewelRepository;
    }
    //find all jewels
    public List<Jewel> findAll(){
        return jewelRepository.findAll();
    }
    //find by id
    public Jewel getJewelById(Long id){
        return  jewelRepository.findJewelById(id);
    }

    public List<Jewel> createJewel(List<JewelCreationRequest> jewelCreationRequestList) {
        List<Jewel> newJewelList = new ArrayList<>();
        Jewel newJewel;
        for (JewelCreationRequest jewelCreationRequest : jewelCreationRequestList) {
            newJewel = Jewel
                    .builder()
                    .brand(jewelCreationRequest.getBrand())
                    .build();
            jewelRepository.save(newJewel);
            newJewelList.add(newJewel);
        }
        return newJewelList;
    }

    //update jewel by it's brand
    public Jewel updateJewel(Long id, String brand){
        Jewel jewelToUpdate=this.getJewelById(id);
        jewelToUpdate.setBrand(brand);
        jewelRepository.save(jewelToUpdate);
        return jewelToUpdate;
    }
    //delete by name
    public void deleteJewelById(Long id){
        this.getJewelById(id);
        jewelRepository.deleteJewelById(id);
    }
}

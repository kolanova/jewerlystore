package com.example.jewerlystore.controller;

import com.example.jewerlystore.model.Jewel;
import com.example.jewerlystore.request.JewelCreationRequest;
import com.example.jewerlystore.request.UpdateJewelNameRequest;
import com.example.jewerlystore.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class JewelController {
    @Autowired
    JewelService jewelService;
    @GetMapping("/jewels")
    public Jewel getJewelById(@PathVariable Long id){
        return jewelService.getJewelById(id);
    }
    @PostMapping("/jewels{id}")
    public List<Jewel> createJewel(@RequestBody @Valid List<JewelCreationRequest>jewelCreationRequest){
        return jewelService.createJewel(jewelCreationRequest);
    }
    @PutMapping(value = "/jewel-update{id}")
    public Jewel updateJewelName(@PathVariable(value = "id")Long id, @RequestBody UpdateJewelNameRequest updateJewelNameRequest){
        return jewelService.updateJewel(id, updateJewelNameRequest.getName());
    }
    @DeleteMapping(value = "/jewel-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){jewelService.deleteJewelById(id);}

}

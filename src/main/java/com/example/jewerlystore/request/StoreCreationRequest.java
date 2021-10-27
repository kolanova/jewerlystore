package com.example.jewerlystore.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreCreationRequest {
    @NotBlank(message = "Please insert your store's name")
    private String name;
}

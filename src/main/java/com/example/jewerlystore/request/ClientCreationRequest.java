package com.example.jewerlystore.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreationRequest {
    @NotBlank(message = "Please insert your client's name")
    private String name;
}

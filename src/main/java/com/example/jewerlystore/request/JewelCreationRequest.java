package com.example.jewerlystore.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JewelCreationRequest extends ClientCreationRequest {
    @NotBlank(message = "Please insert your jewel's brand")
    private String brand;
}

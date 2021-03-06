package com.example.jewerlystore.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JewelReturnRequest {
    @NotBlank(message = "Please insert your jewel's brand")
    private String brand;
}

package com.example.jewerlystore.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientReturnRequest {
    @NotBlank(message = "Please insert your client's name")
    private String name;
}

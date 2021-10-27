package com.example.jewerlystore.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateJewelNameRequest {
    private String name;
}

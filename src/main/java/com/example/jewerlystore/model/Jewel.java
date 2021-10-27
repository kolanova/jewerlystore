package com.example.jewerlystore.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="jewels")
public class Jewel {
    //many jewels goes to many clients
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    @ManyToMany
    @JoinTable(
            name = "client_jewels",
            joinColumns = @JoinColumn(name="jewel_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clientJewels = new HashSet<>();
}

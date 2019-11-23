package com.sda.hotelcleancode.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String type;

    @NotBlank
    private Integer maxPeople;

    private String bedType;

    @NotBlank
    private BigDecimal price;

}

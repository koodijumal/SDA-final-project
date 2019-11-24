package com.sda.hotelcleancode.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RoomType type;

    @NotNull
    private Integer maxPeople;

    @Enumerated(value = EnumType.STRING)
    private RoomBedType bedType;

    @NotNull
    private BigDecimal price;

    public Room(@NotNull RoomType type, @NotNull Integer maxPeople, RoomBedType bedType, @NotNull BigDecimal price) {
        this.type = type;
        this.maxPeople = maxPeople;
        this.bedType = bedType;
        this.price = price;
    }
}

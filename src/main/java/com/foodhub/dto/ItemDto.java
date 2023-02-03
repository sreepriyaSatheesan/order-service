package com.foodhub.dto;

import com.foodhub.model.Item;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemDto {

//    @Id
//    @GeneratedValue
    private Long itemId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
    //private List<Item> items;
    @NotBlank(message = "Invalid quantity: quantity is Empty ")
    @NotNull(message = "Invalid quantity: quantity is NULL")
    private Integer itemQuantity;

    private BigDecimal itemPrice;


}

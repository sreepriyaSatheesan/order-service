package com.foodhub.dto;

import com.foodhub.model.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long customerId;

    //@NotBlank(message = "Invalid order_Items: Order is Empty ")
   // @NotNull(message = "Invalid Order: Order is NULL")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @Fetch(FetchMode.SELECT)
    private List<Item> items;

    private String orderInstruction;


}

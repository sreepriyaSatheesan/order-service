package com.foodhub.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long orderId;
        private Long customerId;
        private String orderInstruction;
        private String orderStatus;
        private LocalDate orderDate;
        private LocalDateTime orderDateTime;

        //@JoinColumn(name = "order_id")
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "order_id")
        @Fetch(FetchMode.SELECT)
        private List<Item> items;



//        public Order(Long orderId, String orderInstruction, String orderStatus, LocalDateTime orderDateTime) {
//                this.orderId = orderId;
//                //this.order_items = order_items;
//                this.orderInstruction = orderInstruction;
//                this.orderStatus = orderStatus;
//                this.orderDateTime = orderDateTime;
//        }
//
//        public Order(Long orderId) {
//                this.orderId = orderId;
//        }
//
//        public Long getOrderId() {
//                return orderId;
//        }
//
//        public void setOrderId(Long orderId) {
//                this.orderId = orderId;
//        }
//
//        public Long getCustomerId() {
//                return customerId;
//        }
//
//        public void setCustomerId(Long customerId) {
//                this.customerId = customerId;
//        }
//
//        public String getOrderInstruction() {
//                return orderInstruction;
//        }
//
//        public void setOrderInstruction(String orderInstruction) {
//                this.orderInstruction = orderInstruction;
//        }
//
//        public String getOrderStatus() {
//                return orderStatus;
//        }
//
//        public void setOrderStatus(String orderStatus) {
//                this.orderStatus = orderStatus;
//        }
//
//        public LocalDate getOrderDate() {
//                return orderDate;
//        }
//
//        public void setOrderDate(LocalDate orderDate) {
//                this.orderDate = orderDate;
//        }
//
//        public LocalDateTime getOrderDateTime() {
//                return orderDateTime;
//        }
//
//        public void setOrderDateTime(LocalDateTime orderDateTime) {
//                this.orderDateTime = orderDateTime;
//        }
//
//        public List<Item> getItems() {
//                return items;
//        }
//
//        public void setItems(List<Item> items) {
//                this.items = items;
//        }
}

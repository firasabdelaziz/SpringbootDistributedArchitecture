package com.example.order.dto;

import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO implements Serializable{

    private Long orderId;

    private Date orderDate;

    private String orderStatus;

    private Double orderTotal;

    private Long customerId;

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}


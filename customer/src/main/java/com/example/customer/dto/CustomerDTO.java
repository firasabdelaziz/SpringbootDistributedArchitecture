package com.example.customer.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomerDTO implements Serializable {

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String[] orderIds;

    public String getFirstName() { return firstName; }

    public String getLastName() { return  lastName; }

    public String getEmail() { return email;}

    public String getPhoneNumber() { return phoneNumber;}

    public String[] getOrderIds() { return orderIds;}

    public void setFirstName(String firstName){ this.firstName=firstName;}

    public void setLastName(String lastName){this.lastName=lastName;}

    public void setEmail(String email){this.email=email;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

    public void setOrderIds(String[] orderIds){this.orderIds=orderIds;}

}

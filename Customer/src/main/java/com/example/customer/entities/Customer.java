package com.example.customer.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="customer")
@Builder
@ToString
public class Customer implements Serializable {

    @Id
    private String customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Convert
    private String[] orderIds;
    public void setFirstName(String firstName){ this.firstName=firstName;}

    public void setLastName(String lastName){this.lastName=lastName;}

    public void setEmail(String email){this.email=email;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

    public void setOrderIds(String[] orderIds){this.orderIds=orderIds;}
}

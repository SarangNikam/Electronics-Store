package com.electronic.Strore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Orders")
public class Order {
    @Id
    private String orderId;
    private  String orderStatus;
    private String paymentStatus;

    private int orderAmount;
    @Column(length = 100)
    private String address;
    private String billingPhone;
    private String billingName;
    private Date orderDate;
    private Date deliveredDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OrderItem> orderItems=new ArrayList<>();
}

package com.sp.entity;

import com.sp.domain.PaymentMethod;
import com.sp.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Long amount;
    private PaymentOrderStatus status=PaymentOrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private String PaymentLinkId;

    @ManyToOne
    private User user;

    private Set<Order> orders=new HashSet<>();


}

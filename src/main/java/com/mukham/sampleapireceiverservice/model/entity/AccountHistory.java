package com.mukham.sampleapireceiverservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountHistory {
    private Long id;
    private String accountName;
    private String cardType;
    private String serviceType;
    private String phone;
    private String address;
    private String transactionDate;
    private String balance;
}

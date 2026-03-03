package com.example.crypto_wallet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String currency;  // "USDT", "BTC" и т.д.

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    private Long userId;  // пока просто поле, позже сделаем связь
}
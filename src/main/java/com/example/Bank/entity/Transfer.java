package com.example.Bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter  @Setter  @AllArgsConstructor  @NoArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "remetente", nullable = false)
    private String remetente;
    @Column(name = "destinatario", nullable = false)
    private String destinatario;
    @NumberFormat(pattern = "#,###.00")
    @Column(name = "valorTransfer", nullable = false)
    private BigDecimal valorTransfer;
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hrDtTransacao = LocalDateTime.now();
}

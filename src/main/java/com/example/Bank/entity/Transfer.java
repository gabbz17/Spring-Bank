package com.example.Bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "valorTransfer", nullable = false)
    private Double valorTransfer;
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hrDtTransacao = LocalDateTime.now();
}

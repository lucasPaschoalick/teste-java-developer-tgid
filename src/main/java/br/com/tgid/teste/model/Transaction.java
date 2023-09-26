package br.com.tgid.teste.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double valTransferencia;
    private double taxaEmpresa;
    private LocalDate timestamp;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Company company;


    @Enumerated(EnumType.STRING)
    private TransactionType type;
}

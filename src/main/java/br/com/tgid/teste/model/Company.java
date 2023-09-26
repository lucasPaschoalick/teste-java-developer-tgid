package br.com.tgid.teste.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company {
    public Company() {
    }

    @JsonProperty("cnpj")
    @Id
    private String cnpj;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("taxa")
    private Double taxa;

    @JsonProperty("saldo")
    private Double saldo;
}

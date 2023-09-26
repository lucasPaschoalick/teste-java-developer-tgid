package br.com.tgid.teste.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client {

    public Client() {
    }

    @JsonProperty("cpf")
    @Id
    private String cpf;

    @JsonProperty("nome")
    private String nome;
}
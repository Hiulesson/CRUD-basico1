package com.hiulesson.pessoa.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;

@Entity
@Table( name = "bd_pessoa" )
@NoArgsConstructor
@Getter@Setter
public class Pessoa {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", nullable = false, unique = true )
    @Setter( AccessLevel.NONE )
    private Long id;

    @Column( nullable = false)
    private String nome;

    @Column( nullable = false, unique = true )
    private String cpf;

    @Column
    private Integer idade;

    @Builder
    public Pessoa(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}

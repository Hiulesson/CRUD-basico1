package com.hiulesson.pessoa.dto.response;

import com.hiulesson.pessoa.entity.Pessoa;
import lombok.Getter;

@Getter
public class PessoaResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;

    public PessoaResponseDTO( Pessoa pessoa ){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.idade = pessoa.getIdade();
    }

}

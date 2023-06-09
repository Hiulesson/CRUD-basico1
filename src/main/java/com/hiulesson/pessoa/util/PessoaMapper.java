package com.hiulesson.pessoa.util;

import com.hiulesson.pessoa.dto.request.PessoaRequestDTO;
import com.hiulesson.pessoa.dto.response.PessoaResponseDTO;
import com.hiulesson.pessoa.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    public Pessoa toPessoa(PessoaRequestDTO pessoaDTO){
        return Pessoa.builder()
                .idade(pessoaDTO.getIdade())
                .nome(pessoaDTO.getNome())
                .cpf(pessoaDTO.getCpf())
                .build();
    }

    public PessoaResponseDTO toPessoaDTO(Pessoa p ){
        return new PessoaResponseDTO(p);
    }

    public List<PessoaResponseDTO> toPeopleDTO( List<Pessoa> p){
        return p.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());

    }

    public void updatePersonData(Pessoa person, PessoaRequestDTO personDTO){

        person.setNome(personDTO.getNome());
        person.setCpf(personDTO.getCpf());
        person.setIdade(person.getIdade());

    }


}

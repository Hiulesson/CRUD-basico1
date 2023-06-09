package com.hiulesson.pessoa.service;

import com.hiulesson.pessoa.dto.request.PessoaRequestDTO;
import com.hiulesson.pessoa.dto.response.PessoaResponseDTO;
import com.hiulesson.pessoa.entity.Pessoa;
import com.hiulesson.pessoa.repository.PessoaRepository;
import com.hiulesson.pessoa.util.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper mapper;

    @Override
    public PessoaResponseDTO findById(Long id) {
        return mapper.toPessoaDTO(returnUser(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return mapper.toPeopleDTO(pessoaRepository.findAll());
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaDTO) {
        Pessoa p = mapper.toPessoa(pessoaDTO);
        return mapper.toPessoaDTO(pessoaRepository.save(p));
    }


    @Override
    public PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO) {
        Pessoa p = returnUser(id);

        mapper.updatePersonData( p, pessoaDTO);

        return mapper.toPessoaDTO(pessoaRepository.save(p));
    }

    @Override
    public String delete(Long id) {
        pessoaRepository.deleteById(id);
        return "Pessoa id:" +id +" foi delatado";
    }

    private Pessoa returnUser(Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa nao encontrada!!!"));
    }

}

package com.hiulesson.pessoa.service;


import com.hiulesson.pessoa.dto.request.PessoaRequestDTO;
import com.hiulesson.pessoa.dto.response.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {

    PessoaResponseDTO findById(Long id);
    List<PessoaResponseDTO> findAll();
    PessoaResponseDTO register(PessoaRequestDTO pessoaDTO );
    PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO);

    String delete(Long id);

}

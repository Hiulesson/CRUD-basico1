package com.hiulesson.pessoa.controller;

import com.hiulesson.pessoa.dto.request.PessoaRequestDTO;
import com.hiulesson.pessoa.dto.response.PessoaResponseDTO;
import com.hiulesson.pessoa.service.PessoaService;
import com.hiulesson.pessoa.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> findById( @PathVariable Long id){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody PessoaRequestDTO pessoaRequestDTO, UriComponentsBuilder uriBuilder){

        PessoaResponseDTO pessoaResponseDTO = pessoaService.register(pessoaRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(pessoaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@RequestBody PessoaRequestDTO personDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(pessoaService.update(id, personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete( @PathVariable Long id){
        return ResponseEntity.ok().body(pessoaService.delete(id));
    }



}

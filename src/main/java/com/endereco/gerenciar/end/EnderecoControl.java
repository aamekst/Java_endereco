package com.endereco.gerenciar.end;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnderecoControl {
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/endereco")
    public ResponseEntity ende (@RequestBody EnderecoDto enderecoDto){
        Endereco ende = new Endereco();
        ende.setCEP(enderecoDto.getCep());
        ende.setNumero(enderecoDto.getNumero());
        ende.setRua(enderecoDto.getRua());
        Endereco enderecoCreated = enderecoRepository.save(ende);
        return ResponseEntity.ok().body(enderecoCreated);
    }

    @GetMapping("/listar")
    public List<Endereco> enderecoList() {
        return enderecoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String excluirPorId(@PathVariable Integer id) {
        var enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        enderecoRepository.deleteById(id);
        return "Ok";
    }

    @GetMapping("/{id}")
    public Endereco buscarId(@PathVariable Integer id) {
        var enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return enderecoOptional.get();
    }

    @PutMapping("/{id}")
    public Endereco atualizarId(@PathVariable Integer id, @RequestBody Endereco endereco) {
        var enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }


}

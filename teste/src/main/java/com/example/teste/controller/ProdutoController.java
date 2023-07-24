package com.example.teste.controller;

import com.example.teste.domain.Produto;
import com.example.teste.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    public ProdutoRespository produtoRespository;

    @GetMapping("/produto/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
        Optional<Produto> produto = produtoRespository.findById(id);
        if (produto.isPresent()){
            return ResponseEntity.ok(produto);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    public ProdutoController(ProdutoRespository produtoRespository) {
        this.produtoRespository = produtoRespository;
    }

    @PostMapping("/produto")
    public ResponseEntity<Void> createCashCard(@RequestBody Produto newCashCardRequest, UriComponentsBuilder ucb) {
        Produto savedCashCard = produtoRespository.save(newCashCardRequest);
        URI locationOfNewCashCard = ucb
                .path("/produto/{id}")
                .buildAndExpand(savedCashCard.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();
    }


    /*
    *
    * Spring Rest Course --- claudianecosta241@gmail.com , password : Cl@u...
    * */
}




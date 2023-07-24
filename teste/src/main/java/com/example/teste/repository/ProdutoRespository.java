package com.example.teste.repository;

import com.example.teste.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Long> {
}

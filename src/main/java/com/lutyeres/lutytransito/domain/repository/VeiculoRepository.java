package com.lutyeres.lutytransito.domain.repository;

import com.lutyeres.lutytransito.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByVeicPlaca(String veicPlaca);



}

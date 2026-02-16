CREATE TABLE veiculo (
                         veicId BIGSERIAL PRIMARY KEY,
                         propId BIGINT NOT NULL,
                         veicMarca VARCHAR(20) NOT NULL,
                         veicModelo VARCHAR(20) NOT NULL,
                         veicPlaca VARCHAR(7) NOT NULL,
                         veicDataApreensao TIMESTAMP NULL,
                         veicStatus VARCHAR(20) NOT NULL,
                         veicDataCadastro TIMESTAMP NOT NULL,

                         CONSTRAINT veicPlaca_unique UNIQUE (veicPlaca),

                         CONSTRAINT fk_veiculo_proprietario
                             FOREIGN KEY (propId)
                                 REFERENCES proprietario (propId)
                                 ON DELETE NO ACTION
                                 ON UPDATE NO ACTION
);

CREATE TABLE veiculo (
                         veicId BIGINT NOT NULL AUTO_INCREMENT,
                         propId BIGINT NOT NULL,
                         veicMarca VARCHAR(20) NOT NULL,
                         veicModelo VARCHAR(20) NOT NULL,
                         veicPlaca VARCHAR(7) NOT NULL,
                         veicDataApreensao DATETIME NULL,
                         veicStatus VARCHAR(20) NOT NULL,
                         veicDataCadastro DATETIME NOT NULL,
                         PRIMARY KEY (veicId),
                         UNIQUE INDEX veicPlaca_UNIQUE (veicPlaca ASC),
                         CONSTRAINT fk_veiculo_proprietario
                             FOREIGN KEY (propId)
                                 REFERENCES proprietario (propId)
                                 ON DELETE NO ACTION
                                 ON UPDATE NO ACTION
);
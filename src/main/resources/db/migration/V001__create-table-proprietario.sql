CREATE TABLE proprietario (
                              propId BIGINT NOT NULL AUTO_INCREMENT,
                              propNome VARCHAR(60) NOT NULL,
                              propEmail VARCHAR(225) NOT NULL,
                              propTelefone VARCHAR(20) NOT NULL,
                              PRIMARY KEY (propId),
                              UNIQUE INDEX propEmail_UNIQUE (propEmail ASC)
);
CREATE TABLE proprietario (
                              prop_id BIGINT NOT NULL AUTO_INCREMENT,
                              prop_nome VARCHAR(60) NOT NULL,
                              prop_email VARCHAR(225) NOT NULL,
                              prop_telefone VARCHAR(20) NOT NULL,
                              PRIMARY KEY (prop_id),
                              UNIQUE INDEX prop_email_UNIQUE (prop_email ASC)
);
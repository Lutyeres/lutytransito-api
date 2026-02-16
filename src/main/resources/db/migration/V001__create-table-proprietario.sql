CREATE TABLE proprietario (
                              propId BIGSERIAL PRIMARY KEY,
                              propNome VARCHAR(60) NOT NULL,
                              propEmail VARCHAR(225) NOT NULL,
                              propTelefone VARCHAR(20) NOT NULL,
                              CONSTRAINT proprietario_prop_email_unique UNIQUE (propEmail)
);
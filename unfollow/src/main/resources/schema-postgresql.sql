CREATE TABLE IF NOT EXISTS cliente (
     id serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);

-- Tabela de disciplinas
CREATE TABLE IF NOT EXISTS disciplina (
    id SERIAL PRIMARY KEY,
    nm_disciplina VARCHAR(50),
    cd_prof INTEGER
);

-- Tabela de notas com chaves estrangeiras
CREATE TABLE IF NOT EXISTS nota (
    cd_cliente INTEGER,
    cd_disciplina INTEGER,
    qt_nota decimal(3,1),
    a1 decimal(3,1),
    a2 decimal(3,1),
    PRIMARY KEY (cd_cliente, cd_disciplina),
    FOREIGN KEY (cd_cliente) REFERENCES cliente(id),
    FOREIGN KEY (cd_disciplina) REFERENCES disciplina(id)
);

/*INSERT INTO cliente (nome, cpf) VALUES ('Ana Souza', '12345678901'), ('Bruno Lima', '23456789012'), ('Carlos Mendes', '34567890123'), ('Daniela Rocha', '45678901234'), ('Eduardo Silva', '56789012345');

INSERT INTO disciplina (nm_disciplina, cd_prof) VALUES
('Matemática', 1),
('Português', 2),
('História', 3),
('Física', 4),
('Biologia', 5);

INSERT INTO nota (cd_cliente, cd_disciplina, qt_nota, a1, a2) VALUES
(1, 1, null, 8.0, 9.0),
(1, 2, null, 6.5, null),
(2, 1, null, 6.0, null),
(2, 3, null, 9.0, null),
(3, 1, null, 5.0, 6.0),
(3, 4, null, 8.0, null),
(4, 5, null, 9.5, 9.0),
(5, 2, null, 6.0, 6.0);
*/
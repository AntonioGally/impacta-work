----------- PARTICIPANTES -----------
--- Alex Carvalho - 2102085
--- Antônio Gally - 2102145
--- Edson Fagundes - 2102719
--- Íris Zarate - 2102682
--- Luciano Silva - 2102690

CREATE TABLE TB_AERODROMO (
    ID INT PRIMARY KEY,
    SG_AERODROMO CHAR(4) NOT NULL UNIQUE,
    NM_AERODROMO CHAR(100) NOT NULL UNIQUE,
    NM_CIDADE CHAR(50),
    SG_UF CHAR(2),
    NM_PAIS CHAR(50) NOT NULL,
    NM_CONTINENTE CHAR(20) NOT NULL
);

CREATE TABLE TB_EMPRESA (
    ID INT PRIMARY KEY,
    SG_EMPRESA CHAR(3) NOT NULL,
    NM_EMPRESA CHAR(100) NOT NULL,
    DS_TIPO_EMPRESA VARCHAR NOT NULL
);

CREATE TABLE TB_JUSTIFICATIVA (
    ID INT PRIMARY KEY,
    SG_JUSTIFICATIVA CHAR(2) NOT NULL UNIQUE,
    DS_JUSTIFICATIVA VARCHAR NOT NULL
);

CREATE TABLE TB_TIPO_LINHA (
    ID INT PRIMARY KEY,
    CD_TIPO_LINHA CHAR(1) NOT NULL UNIQUE,
    DS_SERVICO_TIPO_LINHA VARCHAR NOT NULL,
    DS_NATUREZA_TIPO_LINHA VARCHAR NOT NULL
);

CREATE TABLE TB_TIPO_VOO (
    ID INT PRIMARY KEY,
    DS_TIPO_VOO CHAR(30) NOT NULL UNIQUE,
    DS_CLASSIFICACAO_VOO VARCHAR NOT NULL
);

CREATE TABLE TB_VOO (
    ID_VOO INT PRIMARY KEY,
    ID_EMPRESA INT,
    NR_VOO NUMERIC(4) NOT NULL,
    ID_TIPO_VOO INT NOT NULL,
    ID_TIPO_LINHA INT NOT NULL,
    ID_AERODROMO_ORIGEM INT NOT NULL,
    ID_AERODROMO_DESTINO INT NOT NULL,
    DT_HR_PARTIDA_PREVISTA DATE NOT NULL,
    DT_HR_PARTIDA_REAL DATE,
    DT_HR_CHEGADA_PREVISTA DATE NOT NULL,
    DT_HR_CHEGADA_REAL DATE,
    FL_SITUACAO TINYINT(1) NOT NULL,
    ID_JUSTIFICATIVA INT,

    FOREIGN KEY (ID_EMPRESA) REFERENCES TB_EMPRESA(ID),
    FOREIGN KEY (ID_TIPO_VOO) REFERENCES TB_TIPO_VOO(ID),
    FOREIGN KEY (ID_TIPO_LINHA) REFERENCES TB_TIPO_LINHA(ID),
    FOREIGN KEY (ID_AERODROMO_ORIGEM) REFERENCES TB_AERODROMO(ID),
    FOREIGN KEY (ID_AERODROMO_DESTINO) REFERENCES TB_AERODROMO(ID),
    FOREIGN KEY (ID_JUSTIFICATIVA) REFERENCES TB_JUSTIFICATIVA(ID)
);
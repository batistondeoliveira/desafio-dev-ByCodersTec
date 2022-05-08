CREATE TABLE `representante` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `id_loja` int(11) NOT NULL,
  constraint unico UNIQUE (nome, id_loja)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

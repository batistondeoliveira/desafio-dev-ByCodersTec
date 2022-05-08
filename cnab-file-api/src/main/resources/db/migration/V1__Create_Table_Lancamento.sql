CREATE TABLE `lancamento` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `tipo_transacao` int(1) NOT NULL,
  `data` date NOT NULL,
  `valor` decimal(12,2) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `cartao` varchar(255) NOT NULL,   
  `hora` varchar(255) NOT NULL,
  `representante_loja` varchar(255) NOT NULL,
  `nome_loja` varchar(255) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
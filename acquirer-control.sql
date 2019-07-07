-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Jul-2019 às 13:38
-- Versão do servidor: 10.3.15-MariaDB
-- versão do PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acquirer`
--

CREATE TABLE `acquirer` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `acquirer`
--

INSERT INTO `acquirer` (`id`, `name`) VALUES
(1, 'UflaCard'),
(2, 'FagammonCard');

-- --------------------------------------------------------

--
-- Estrutura da tabela `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `client`
--

INSERT INTO `client` (`id`, `name`) VALUES
(1, 'Rex'),
(2, 'Cafézinho Expresso');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contract`
--

CREATE TABLE `contract` (
  `client_id` int(11) NOT NULL,
  `acquirer_id` int(11) NOT NULL,
  `establishment` varchar(15) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `contract`
--

INSERT INTO `contract` (`client_id`, `acquirer_id`, `establishment`, `create_at`) VALUES
(1, 2, '32165487', '2019-07-03 17:01:04'),
(2, 1, '9875643211', '2019-07-03 17:01:31');

-- --------------------------------------------------------

--
-- Estrutura da tabela `file`
--

CREATE TABLE `file` (
  `id` int(11) NOT NULL,
  `registry_type` varchar(2) NOT NULL,
  `establishment` varchar(15) NOT NULL,
  `processing_date` varchar(8) NOT NULL,
  `initial_period` varchar(8) DEFAULT NULL,
  `final_period` varchar(8) DEFAULT NULL,
  `sequence` varchar(15) NOT NULL,
  `acquirer_name` varchar(45) NOT NULL,
  `status` enum('Esperando','Aprovado','Rejeitado') NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `file`
--

INSERT INTO `file` (`id`, `registry_type`, `establishment`, `processing_date`, `initial_period`, `final_period`, `sequence`, `acquirer_name`, `status`, `create_at`) VALUES
(13, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-07-02 17:07:53'),
(14, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-07-03 17:07:58'),
(15, '1', '32165487', '20190524', NULL, NULL, '0002451', 'FagammonCard', 'Aprovado', '2019-07-03 17:08:02'),
(16, '1', '32165487', '20190524', NULL, NULL, '0002451', 'FagammonCard', 'Aprovado', '2019-07-01 17:08:15'),
(17, '1', '32165487', '20190524', NULL, NULL, '0002451', 'FagammonCard', 'Aprovado', '2019-07-03 17:08:17'),
(18, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-06-29 17:08:22'),
(19, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-07-05 15:13:03'),
(20, '1', '32165487', '20190524', NULL, NULL, '0002451', 'FagammonCard', 'Esperando', '2019-07-06 04:00:11'),
(21, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-07-06 04:03:46'),
(22, '0', '9835643211', '20190624', '20190623', '20190623', '0000001', 'UflaCard', 'Esperando', '2019-07-06 16:10:45');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `acquirer`
--
ALTER TABLE `acquirer`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`client_id`,`acquirer_id`),
  ADD KEY `fk_Cliente_has_Adquirente_Adquirente1_idx` (`acquirer_id`),
  ADD KEY `fk_Cliente_has_Adquirente_Cliente_idx` (`client_id`);

--
-- Índices para tabela `file`
--
ALTER TABLE `file`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `acquirer`
--
ALTER TABLE `acquirer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `file`
--
ALTER TABLE `file`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `fk_Cliente_has_Adquirente_Adquirente1` FOREIGN KEY (`acquirer_id`) REFERENCES `acquirer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_has_Adquirente_Cliente` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

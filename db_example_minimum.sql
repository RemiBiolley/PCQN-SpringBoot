-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 20 jan. 2019 à 17:03
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_example`
--

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL,
  `contenu` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `game_id` int(11) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdnsshxpxsyim4eglkpc9je1ol` (`game_id`),
  KEY `FKmk3c8pbvysjndxywunibl2voc` (`comment_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL,
  `jaquette` varchar(255) DEFAULT NULL,
  `editeur` varchar(255) DEFAULT NULL,
  `jeu_moment` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `nombre_notes` int(11) NOT NULL,
  `note_moyenne` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `game`
--

INSERT INTO `game` (`id`, `jaquette`, `editeur`, `jeu_moment`, `nom`, `nombre_notes`, `note_moyenne`) VALUES
(1, 'https://media.senscritique.com/media/000008112391/source_big/Rambo_III.jpg', 'Stallone Corp', 0, 'Rambo', 0, 0),
(2, 'https://images-na.ssl-images-amazon.com/images/I/51vSuy9309L._SX342_.jpg', 'Nintendo', 1, 'PokemonPerle', 1, 3.5),
(3, 'https://media.senscritique.com/media/000017808479/source_big/Final_Fantasy_VII.png', 'Square', 1, 'FinalFantasy7', 1, 4.5);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7),
(7),
(7),
(7),
(7);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) NOT NULL,
  `note` float NOT NULL,
  `game_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsx26jyhwdniyrro9lunu5yexa` (`game_id`),
  KEY `FKmoddtnuw3yy6ct34xnw6u0boh` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `spring_session`
--

INSERT INTO `spring_session` (`PRIMARY_ID`, `SESSION_ID`, `CREATION_TIME`, `LAST_ACCESS_TIME`, `MAX_INACTIVE_INTERVAL`, `EXPIRY_TIME`, `PRINCIPAL_NAME`) VALUES
('05e9de33-394d-489c-be89-ff3b1a70a413', '08bc920c-63ca-440e-8b85-6cae18b4417d', 1548003709183, 1548003744074, 1800, 1548005544074, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `spring_session_attributes`
--

INSERT INTO `spring_session_attributes` (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_BYTES`) VALUES
('05e9de33-394d-489c-be89-ff3b1a70a413', 'avatar', 0xaced000574005868747470733a2f2f643369736d6137736e6a336c63782e636c6f756466726f6e742e6e65742f6f7074696d2f696d616765732f70686f746f732f33302f35302f34302f31302f4d45333035303430313031315f322e6a7067),
('05e9de33-394d-489c-be89-ff3b1a70a413', 'user', 0xaced000573720012636f6d2e7063716e2e64656d6f2e55736572a85ee7de156a6f3402000b4c00066176617461727400124c6a6176612f6c616e672f537472696e673b4c0008636f6d6d656e74737400164c6a6176612f7574696c2f436f6c6c656374696f6e3b4c0005656d61696c71007e00014c000269647400134c6a6176612f6c616e672f496e74656765723b4c00056e6f74657371007e00024c000870617373776f726471007e00014c0006706f696e747371007e00034c000472616e6b71007e00014c000875736572496e666f7400184c636f6d2f7063716e2f64656d6f2f55736572496e666f3b4c0008757365724e616d6571007e00014c000875736572547970657400184c636f6d2f7063716e2f64656d6f2f55736572547970653b787074005868747470733a2f2f643369736d6137736e6a336c63782e636c6f756466726f6e742e6e65742f6f7074696d2f696d616765732f70686f746f732f33302f35302f34302f31302f4d45333035303430313031315f322e6a70677372002f6f72672e68696265726e6174652e636f6c6c656374696f6e2e696e7465726e616c2e50657273697374656e744261673e6a0d30495f208f0200014c00036261677400104c6a6176612f7574696c2f4c6973743b7872003e6f72672e68696265726e6174652e636f6c6c656374696f6e2e696e7465726e616c2e416273747261637450657273697374656e74436f6c6c656374696f6e402cf80d58d552f202000b5a001b616c6c6f774c6f61644f7574736964655472616e73616374696f6e49000a63616368656453697a655a000564697274795a000e656c656d656e7452656d6f7665645a000b696e697469616c697a65645a000d697354656d7053657373696f6e4c00036b65797400164c6a6176612f696f2f53657269616c697a61626c653b4c00056f776e65727400124c6a6176612f6c616e672f4f626a6563743b4c0004726f6c6571007e00014c001273657373696f6e466163746f72795575696471007e00014c000e73746f726564536e617073686f7471007e000b787000ffffffff00000000737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b02000078700000000171007e000674001b636f6d2e7063716e2e64656d6f2e557365722e636f6d6d656e747370707074000f61646d696e40676d61696c2e636f6d71007e00107371007e000800ffffffff0000000071007e001071007e0006740018636f6d2e7063716e2e64656d6f2e557365722e6e6f74657370707074000561646d696e7371007e000e0000000274000a426c65757361696c6c6573720016636f6d2e7063716e2e64656d6f2e55736572496e666f9746095e6684028d0200064c000966697273744e616d6571007e00014c000467616d657400144c636f6d2f7063716e2f64656d6f2f47616d653b4c0002696471007e00034c00086c6173744e616d6571007e00014c000974656c6570686f6e6571007e00014c0004757365727400144c636f6d2f7063716e2f64656d6f2f557365723b78707400074c617572656e7473720012636f6d2e7063716e2e64656d6f2e47616d65971c35f2a60941600200094600046e6f74654c0003626f7871007e00014c00076564697465757271007e00014c0002696471007e00034c000a6d6f6d656e7447616d6571007e00034c00046e616d6571007e00014c00096e6272654e6f74657371007e00034c00056e6f74657371007e00024c000975736572496e666f7371007e000278704090000074005268747470733a2f2f6d656469612e73656e7363726974697175652e636f6d2f6d656469612f3030303031373830383437392f736f757263655f6269672f46696e616c5f46616e746173795f5649492e706e677400065371756172657371007e000e0000000371007e001074000d46696e616c46616e746173793771007e00107371007e000800ffffffff0000000071007e002171007e001e740018636f6d2e7063716e2e64656d6f2e47616d652e6e6f7465737070707371007e000800ffffffff0000000071007e002171007e001e74001c636f6d2e7063716e2e64656d6f2e47616d652e75736572496e666f7370707071007e0010740008506965646d6f6e747071007e00067400045051434e73720016636f6d2e7063716e2e64656d6f2e55736572547970652097c49bd4cbdb7f0200034c0002696471007e00034c0008747970654e616d6571007e00014c0005757365727371007e0002787071007e002174001041646d696e697374726174657572202b7371007e000800ffffffff0000000071007e002171007e002a74001c636f6d2e7063716e2e64656d6f2e55736572547970652e7573657273707070);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `points` int(11) NOT NULL,
  `rang` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlrk9xrdps0emd6d5rx5x3ib6h` (`user_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `avatar`, `email`, `mdp`, `points`, `rang`, `pseudo`, `user_type_id`) VALUES
(1, 'https://d3isma7snj3lcx.cloudfront.net/optim/images/photos/30/50/40/10/ME3050401011_2.jpg', 'admin@gmail.com', 'admin', 2, 'Bleusaille', 'PQCN', 3);

-- --------------------------------------------------------

--
-- Structure de la table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKglomqsp2xdjdn68ksu7pjhagp` (`game_id`),
  KEY `FKn8pl63y4abe7n0ls6topbqjh2` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_info`
--

INSERT INTO `user_info` (`id`, `prenom`, `nom`, `telephone`, `game_id`, `user_id`) VALUES
(1, 'Laurent', 'Piedmont', NULL, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int(11) NOT NULL,
  `nom_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_type`
--

INSERT INTO `user_type` (`id`, `nom_type`) VALUES
(1, 'Utilisateur'),
(2, 'Administrateur'),
(3, 'Administrateur +');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 20 jan. 2019 à 17:20
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

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `contenu`, `date`, `game_id`, `comment_id`, `user_id`) VALUES
(7, 'Voici la première solution du site ! J\'espère qu\'elle vous plaira !', '2019-01-20 17:03:43', 2, NULL, 1),
(12, 'Super soluce, ça m\'a beaucoup aidé !', '2019-01-20 17:04:52', 2, NULL, 10),
(13, 'Un grand classique du jeu-vidéo ! Cette soluce en aidera plus d\'un !', '2019-01-20 17:05:23', 3, NULL, 10),
(18, 'La première et, je l\'espère, pas la dernière !', '2019-01-20 17:06:39', 2, 7, 16),
(22, 'L\'une des plus grandes oeuvres du 20e siècle :O', '2019-01-20 17:07:54', 1, NULL, 16),
(23, 'Dont moi xD', '2019-01-20 17:08:19', 3, 13, 16),
(26, 'Trop choupi ces bestioles !', '2019-01-20 17:10:21', 2, NULL, 24),
(27, 'Ah et merci pour cet article :)', '2019-01-20 17:10:41', 2, NULL, 24),
(30, 'Sympa, ca a quand même pas mal vieilli ...', '2019-01-20 17:11:26', 3, NULL, 24),
(32, 'C\'était INCROYABLE', '2019-01-20 17:11:48', 1, NULL, 24),
(33, 'On est bien d\'accord !', '2019-01-20 17:11:58', 1, 22, 24),
(34, 'Ne ti\'inquiète pas pour ça !', '2019-01-20 17:16:13', 2, 7, 1),
(35, 'Je voulais partager ce jeu avec vous, une vraie pépite méconnue !', '2019-01-20 17:17:39', 1, NULL, 1),
(36, 'Content que ça vous plaise jusque là :)', '2019-01-20 17:18:22', 2, NULL, 1);

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
(1, 'https://media.senscritique.com/media/000008112391/source_big/Rambo_III.jpg', 'Stallone Corp', 0, 'Rambo', 2, 5),
(2, 'https://images-na.ssl-images-amazon.com/images/I/51vSuy9309L._SX342_.jpg', 'Nintendo', 1, 'PokemonPerle', 5, 3.875),
(3, 'https://media.senscritique.com/media/000017808479/source_big/Final_Fantasy_VII.png', 'Square', 1, 'FinalFantasy7', 5, 3.625);

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
(37),
(37),
(37),
(37),
(37),
(37);

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

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`id`, `note`, `game_id`, `user_id`) VALUES
(9, 4.5, 3, 1),
(8, 3.5, 2, 1),
(14, 5, 3, 10),
(15, 4, 2, 10),
(19, 3, 2, 16),
(20, 2.5, 3, 16),
(21, 5, 1, 16),
(28, 5, 2, 24),
(29, 2.5, 3, 24),
(31, 5, 1, 24);

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
(1, 'https://d3isma7snj3lcx.cloudfront.net/optim/images/photos/30/50/40/10/ME3050401011_2.jpg', 'admin@gmail.com', 'admin', 260, 'Dieu de la guerre', 'PQCN', 3),
(10, 'https://mir-s3-cdn-cf.behance.net/project_modules/disp/636b6721340091.562ff8a1e6d56.jpg', 'remi@gmail.com', 'remi', 4, 'Bleusaille', 'Storpax', 1),
(16, 'https://mir-s3-cdn-cf.behance.net/project_modules/disp/3eb13e21340091.562ff8a21c1f8.jpg', 'tristan@gmail.com', 'tristan', 6, 'Apprenti aventurier', 'Triskhel', 1),
(24, 'https://mir-s3-cdn-cf.behance.net/project_modules/disp/3a11a921340091.562ff8a218e81.jpg', 'fanny@gmail.com', 'fanny', 10, 'Apprenti aventurier', 'Nigirith', 1);

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
(1, 'Laurent', 'Piedmont', NULL, 3, 1),
(11, NULL, NULL, NULL, 2, 10),
(17, NULL, NULL, NULL, NULL, 16),
(25, NULL, NULL, NULL, NULL, 24);

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

CREATE TABLE `esami` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `id_utente` int NOT NULL,
                         `passato` tinyint(1) DEFAULT NULL,
                         `name` varchar(1000) DEFAULT NULL,
                         `results` text,
                         PRIMARY KEY (`id`),
                         KEY `utente` (`id_utente`),
                         CONSTRAINT `utente` FOREIGN KEY (`id_utente`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


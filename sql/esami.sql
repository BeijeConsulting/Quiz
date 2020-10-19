CREATE TABLE `esami` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `id_utente` int NOT NULL,
                         `percentuale` double DEFAULT NULL,
                         `passato` tinyint(1) DEFAULT NULL,
    `name` varchar(100) DEFAULT NULL,
    `results` text,
    PRIMARY KEY (`id`),
    KEY `utente` (`id_utente`),
    CONSTRAINT `utente` FOREIGN KEY (`id_utente`) REFERENCES `users` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
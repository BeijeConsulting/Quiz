CREATE TABLE `risposte` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `id_domanda` bigint DEFAULT NULL,
                            `letter` char(1) DEFAULT NULL,
    `text` text,
    PRIMARY KEY (`id`),
    KEY `domande` (`id_domanda`),
    CONSTRAINT `domande` FOREIGN KEY (`id_domanda`) REFERENCES `domande` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2671 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


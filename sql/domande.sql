CREATE TABLE `domande` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `book` text,
                           `testo` text,
                           `answerType` text,
                           `risposte` text,
                           `rispostaEsatta` text,
                           `spiegazione` text,
                           `chapter` int DEFAULT NULL,
                           `question` int DEFAULT NULL,
                           `id_da_xml` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
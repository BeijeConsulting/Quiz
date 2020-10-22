CREATE TABLE `risposte` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_risposta` bigint DEFAULT NULL,
  `lettera` varchar(1) DEFAULT NULL,
  `testo` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

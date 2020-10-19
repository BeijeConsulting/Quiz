# Quiz
Modificare nel quiz controller riga 74 in base al proprio User e modificare il persistence.xml con il proprio utente e passw di mySQL

	### Creazione Tabella
	
	CREATE TABLE `storico` (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `id_utente` int DEFAULT NULL,
	  `data` date DEFAULT NULL,
	  `durata` varchar(45) DEFAULT NULL,
	  `esito` varchar(45) DEFAULT NULL,
	  `score` double DEFAULT NULL,
	  `punteggio` varchar(45) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
	
	CREATE TABLE `utente` (
	  `id` int NOT NULL AUTO_INCREMENT,
	  `nome` varchar(45) NOT NULL,
	  `cognome` varchar(45) NOT NULL,
	  `email` varchar(200) NOT NULL,
	  `password` varchar(45) NOT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

	### Riempi DB
	BEGIN;
	insert into utenti (cognome, nome, email, password)
	    values ('rossi', 'piero', 'pierorossi@rossi.it', 'a');
	    insert into utenti (cognome, nome, email, password)
	    values ('bianchi', 'piero', 'bianchi@piero.it', 'a');
	    insert into utenti (cognome, nome, email, password)
	    values ('verdi', 'piero', 'verdi@piero.it', 'a');
	    insert into utenti (cognome, nome, email, password)
	    values ('paolo', 'paolo', 'paolo@paolo.it', 'a');
	    insert into utenti (cognome, nome, email, password)
	    values ('asfgha', 'mirko', 'mirko@rossi.it', 'a');


CREATE TABLE `quiz`.`risposte_date` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_utente` INT NULL,
  `id_domanda` BIGINT NULL,
  `id_esame` BIGINT NULL,
  `risposta` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_utente_idx` (`id_utente` ASC) VISIBLE,
  INDEX `id_domanda_idx` (`id_domanda` ASC) VISIBLE,
  INDEX `id_esame_idx` (`id_esame` ASC) VISIBLE,
  CONSTRAINT `id_utente`
    FOREIGN KEY (`id_utente`)
    REFERENCES `quiz`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_domanda`
    FOREIGN KEY (`id_domanda`)
    REFERENCES `quiz`.`domande` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_esame`
    FOREIGN KEY (`id_esame`)
    REFERENCES `quiz`.`esami` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
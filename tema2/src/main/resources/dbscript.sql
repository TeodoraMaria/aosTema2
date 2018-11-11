CREATE TABLE `test`.`Person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `WantsNewsletter` TINYINT NOT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE INDEX `idPerson_UNIQUE` (`idPerson` ASC) VISIBLE);
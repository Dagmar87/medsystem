CREATE TABLE `medsystem`.`especialidade`(
`id` INT NOT NULL,
`nome` VARCHAR(255) NOT NULL,
`descricao` TEXT NOT NULL,
`ativo` TINYINT NOT NULL,
PRIMARY KEY (`id`));

ALTER TABLE `medsystem`.`especialidade`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC); 

CREATE TABLE `medsystem`.`medico`(
`id` INT NOT NULL,
`nome` VARCHAR(255) NOT NULL,
`datanascimento` DATETIME NOT NULL,
`ativo` TINYINT NOT NULL,
`esp_id` INT NOT NULL,
PRIMARY KEY (`id`));

ALTER TABLE `medsystem`.`medico`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC); 

ALTER TABLE `medsystem`.`medico`
ADD CONSTRAINT `fk_medico_esp`
FOREIGN KEY(`esp_id`) REFERENCES `especialidade`(`id`);

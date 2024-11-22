-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.

-- Modify this code to update the DB schema diagram.
-- To reset the sample schema, replace everything with
-- two dots ('..' - without quotes).

CREATE TABLE `customer` (
    `id` int  NOT NULL ,
    `name` varchar(500)  NOT NULL ,
    `last_name` varchar(500)  NOT NULL ,
    `identification` int  NOT NULL ,
    `id_category` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `category` (
    `id` int  NOT NULL ,
    `description` varchar(500)  NOT NULL ,
    `date_created` date  NOT NULL ,
    `date_udpate` date  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

ALTER TABLE `customer` ADD CONSTRAINT `fk_customer_id_category` FOREIGN KEY(`id_category`)
REFERENCES `category` (`id`);


-- Insert Category
INSERT INTO `supermercado_mvc`.`category` (`id`, `description`, `date_created`, `date_udpate`) VALUES (1, 'Premium', NOW(), NOW());
INSERT INTO `supermercado_mvc`.`category` (`id`, `description`, `date_created`, `date_udpate`) VALUES (2, 'Platinum', NOW(), NOW());
INSERT INTO `supermercado_mvc`.`category` (`id`, `description`, `date_created`, `date_udpate`) VALUES (3, 'Estandar', NOW(), NOW());
INSERT INTO `supermercado_mvc`.`category` (`id`, `description`, `date_created`, `date_udpate`) VALUES (4, 'New', NOW(), NOW());

-- Insert Customer
INSERT INTO `supermercado_mvc`.`customer` (`id`, `name`, `last_name`, `identification`, `id_category`) VALUES (1, 'Heidy', 'Niño', 123456, 1);
INSERT INTO `supermercado_mvc`.`customer` (`id`, `name`, `last_name`, `identification`, `id_category`) VALUES (2, 'Fabian', 'Villon', 789101, 2);
INSERT INTO `supermercado_mvc`.`customer` (`id`, `name`, `last_name`, `identification`, `id_category`) VALUES (3, 'Isabella', 'Garcia', 159753, 3);
INSERT INTO `supermercado_mvc`.`customer` (`id`, `name`, `last_name`, `identification`, `id_category`) VALUES (4, 'Juan', 'Ascencio', 357951, 4);


CREATE TABLE `tb_tiny_url`
(
    `tiny_url_slug` varchar(10)  NOT NULL,
    `full_url`      varchar(255) NOT NULL,
    PRIMARY KEY (`tiny_url_slug`) USING BTREE
);
ALTER TABLE `tb_tiny_url`
    add index index_of_full_url (`full_url`);

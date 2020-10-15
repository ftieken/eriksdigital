
drop table if exists orders;

--  id IDENTITY PRIMARY KEY,
create table orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(10),
    price DECIMAL(10,2),
    date DATE
);

-- CREATE DATABASE IF NOT EXISTS eriks;
-- USE eriks;
--
-- CREATE TABLE IF NOT EXISTS orders (
--     id  bigint(5) NOT NULL AUTO_INCREMENT,
--     status VARCHAR(10),
--     price DECIMAL(6,2),
--     date DATE,
--     PRIMARY KEY (id)
-- );
--
insert into orders (status, price, date) values
    ('S1', 12.50, PARSEDATETIME('2020-10-10', 'yyyy-MM-dd')),
    ('S2', 99.50, PARSEDATETIME('2020-10-10', 'yyyy-MM-dd')),
    ('S3', 99999999.99, PARSEDATETIME('2020-10-10', 'yyyy-MM-dd')),
    ('S3', 120.99, PARSEDATETIME('2020-10-10', 'yyyy-MM-dd'));

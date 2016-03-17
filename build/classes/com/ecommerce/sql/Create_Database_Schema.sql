CREATE TABLE IF NOT EXISTS PRODUCT (
        PRODUCT_ID               INT NOT NULL AUTO_INCREMENT UNIQUE,
        PRODUCT_NAME             VARCHAR(20) NOT NULL,
        MANUFACTURER             VARCHAR(32),
        PRICE                    NUMERIC(10,2) NOT NULL,
        EXPIRY_DTM               TIMESTAMP(6) NOT NULL,
        PRIMARY KEY              (PRODUCT_ID) 
);


CREATE TABLE IF NOT EXISTS CARTDETAILS
  (
     CUSTOMER_ID            INT NOT NULL,
     CART_ID                INT NOT NULL AUTO_INCREMENT,
     PRODUCT_LIST           VARCHAR(55),
     PRIMARY KEY            (CART_ID) 

  );

CREATE TABLE IF NOT EXISTS CUSTOMER
  (
     CUSTOMER_ID           INT NOT NULL AUTO_INCREMENT UNIQUE,
     FIRST_NAME            VARCHAR(20) NOT NULL,
     LAST_NAME             VARCHAR(20),
     PASSWORD              CHAR(4) NOT NULL,
     ADDRESS               VARCHAR(20),
     EMAIL                 VARCHAR(20),
     PRIMARY KEY           (CUSTOMER_ID )
  );


CREATE TABLE IF NOT EXISTS ADDRESSES
  (
     CUSTOMER_ID            INT NOT NULL,
     STREET_NAME            VARCHAR(20),
     CITY                   VARCHAR(20),
     APT                    CHAR(8),
     ADDRESS_TYPE           VARCHAR(20),
     CHECK (ADDRESS_TYPE IN ('BUSSINESS','RESI', 'BILLING')),
     PRIMARY KEY            (CUSTOMER_ID )
  );


CREATE TABLE IF NOT EXISTS CARDDETAILS
  (
     CUSTOMER_ID            INT NOT NULL,
     CARD_NUMBER            VARCHAR(20) NOT NULL,
     PIN                    CHAR(4) NOT NULL,
     CARD_EXPIRY_DTM        TIMESTAMP(6) NOT NULL,
     CARD_TYPE              VARCHAR(20) NOT NULL, 
     CHECK (ADDRESS_TYPE IN ('MASTER','VISA', 'DEBIT')),
     BANK_NAME              VARCHAR(20) 
  );

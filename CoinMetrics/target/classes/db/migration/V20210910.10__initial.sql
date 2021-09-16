create table if not exists coin_market_entity
(
    uuid                     varchar(36) NOT NULL,
    coin_gecko_id            varchar(40) NOT NULL,
    symbol                   varchar(20) NOT NULL,
    name                     varchar(40) NOT NULL,
    current_price            double precision  NOT NULL,
    market_cap               bigint NOT NULL,
    market_cap_rank          smallint NOT NULL,
    date                     varchar(26) NOT NULL,
    date_as_date             timestamp,

    PRIMARY KEY (uuid)
);
create table if not exists market_chart_entity
(
    uuid                     varchar(36) NOT NULL,
    coin_gecko_id            varchar(40) NOT NULL,
    price                    double precision  NOT NULL,
    market_cap               bigint NOT NULL,
    unix                     bigint NOT NULL,
    date                     timestamp NOT NULL,

    PRIMARY KEY (uuid)
);
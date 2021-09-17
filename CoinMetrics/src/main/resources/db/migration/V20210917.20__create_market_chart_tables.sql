create table if not exists market_chart_parent_entity
(
    uuid                     varchar(36) NOT NULL,
    coin_gecko_id            varchar(40) NOT NULL,

    PRIMARY KEY (uuid)
);

create table if not exists market_chart_child_entity
(
    uuid                     varchar(36) NOT NULL,
    price                    double precision  NOT NULL,
    market_cap               bigint NOT NULL,
    unix                     bigint NOT NULL,
    date                     timestamp NOT NULL,

    PRIMARY KEY (uuid)
);

create table if not exists market_chart_parent_children
(
    market_chart_parent_uuid varchar(36) NOT NULL,
    children_uuid            varchar(36) NOT NULL
);
drop table market_chart_parent_entity_children;

create table market_chart_parent_entity_children
(
    market_chart_parent_entity_uuid varchar(36) NOT NULL,
    children_uuid                   varchar(36) NOT NULL
);

alter table market_chart_parent_entity_children add constraint fk_parent foreign key
(market_chart_parent_entity_uuid) references market_chart_parent_entity;

alter table market_chart_parent_entity_children add constraint fk_child foreign key
(children_uuid) references market_chart_child_entity;
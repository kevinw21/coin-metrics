alter table coin_market_entity add constraint no_duplicate_coin_and_date unique
(coin_gecko_id, date);
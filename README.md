# READ ME

### Reference Documentation
This service is meant to be deployed and ran on a schedule or launched and updated as needed by calling to get the latest
price info and save in CoinMarketController. Note that there are API limits do to constraints on Coin Gecko api usage.
Check https://www.coingecko.com/en/api for the latest.




### Useful queries
select * from market_chart_parent_entity_children bridge
join market_chart_child_entity c on bridge.children_uuid = c.uuid
join market_chart_parent_entity p on bridge.market_chart_parent_entity_uuid = p.uuid;

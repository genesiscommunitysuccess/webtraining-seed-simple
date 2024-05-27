package scripts

/**
 *
 *   System              : alpha
 *   Sub-System          : alpha Configuration
 *   Version             : 1.0
 *   Copyright           : (c) GENESIS
 *   Date                : 2021-09-07
 *
 *   Function : Provide Data Server Configuration for alpha.
 *
 *   Modification History
 *
 */

dataServer {
    query("ALL_TRADES", TRADE_VIEW) {
        permissioning {
            auth(mapName = "ENTITY_VISIBILITY") {
                TRADE_VIEW.COUNTERPARTY_ID
            }
        }
    }
    query("ALL_PRICES", TRADE){
        fields{
            PRICE
            SYMBOL
        }
        where { trade -> trade.price > 10.0 }
    }
    query("ALL_INSTRUMENTS", INSTRUMENT)
    query("ALL_COUNTERPARTIES", COUNTERPARTY)
    query("ALL_POSITIONS", POSITION)
}
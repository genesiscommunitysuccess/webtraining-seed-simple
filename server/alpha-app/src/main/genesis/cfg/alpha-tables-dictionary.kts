import global.genesis.dictionary.pal.table.TableFieldType

/**
 * System              : Genesis Business Library
 * Sub-System          : multi-pro-code-test Configuration
 * Version             : 1.0
 * Copyright           : (c) Genesis
 * Date                : 2022-03-18
 * Function : Provide table definition config for multi-pro-code-test.
 *
 * Modification History
 */

tables {

    table (name = "TRADE", id = 2000, audit = details(id = 2100, sequence = "TR")) {
        field("TRADE_ID",STRING).sequence("TR").primaryKey()
        field("TRADE_DATE",DATE)
        field("ENTERED_BY",STRING).username().notNull()
        field("TRADE_STATUS", ENUM("NEW","ALLOCATED","CANCELLED")).default("NEW")
        field("COUNTERPARTY_ID",STRING).notNull()
        field("INSTRUMENT_ID",STRING).notNull()
        field("QUANTITY",INT)
        field("PRICE",DOUBLE).notNull()
        field("SYMBOL",STRING)
        field("DIRECTION", ENUM("BUY","SELL")).default("BUY")
    }

    table (name = "COUNTERPARTY", id = 2001) {
        field("COUNTERPARTY_ID",STRING).sequence("CP").primaryKey()
        field("COUNTERPARTY_NAME",STRING)
        field("ENABLED",BOOLEAN)
        field("COUNTERPARTY_LEI",STRING)
    }

    table (name = "INSTRUMENT", id = 2002) {
        field("INSTRUMENT_ID",STRING).sequence("IN").primaryKey()
        field("INSTRUMENT_NAME",STRING)
        field("MARKET_ID", STRING)
        field("COUNTRY_CODE",STRING)
        field("CURRENCY_ID",STRING)
        field("ASSET_CLASS", STRING)
    }

    table(name = "POSITION", id = 2003) {
        field("INSTRUMENT_ID",STRING).notNull().primaryKey()
        field("QUANTITY",INT)
        field("NOTIONAL",DOUBLE)
        field("VALUE",DOUBLE)
        field("PNL",DOUBLE)
    }

    table(name = "INSTRUMENT_PRICE", id = 2004) {
        field("INSTRUMENT_ID",STRING).primaryKey()
        field("LAST_PRICE",DOUBLE)
    }


    table(name = "STOCK", id = 2005){

        field("STOCK_ID", type = STRING).primaryKey().sequence("ST")
        field("COMPANY_NAME", type = STRING).notNull()
        field("TRADING_VOLUME", type = DOUBLE).notNull()
        field("CEO", type = STRING).notNull()
        field("SYMBOL", type = STRING).notNull()
        field("PRICE",DOUBLE).notNull()

    }

    table(name = "ORDER", id = 2006) {
        field("ORDER_ID",STRING).sequence("OI").primaryKey()
        field("INSTRUMENT_ID",STRING).notNull()
        field("QUANTITY",INT).notNull()
        field("PRICE",DOUBLE).notNull()
        field("DIRECTION", ENUM("BUY","SELL")).default("BUY")
        field("NOTES", type = STRING)
    }

}
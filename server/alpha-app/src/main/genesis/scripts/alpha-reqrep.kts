requestReplies {
    requestReply("INSTRUMENT_MARKET_DATA", INSTRUMENT_PRICE) {

        request {
            INSTRUMENT_ID
        }

        reply {
            INSTRUMENT_PRICE.INSTRUMENT_ID
            INSTRUMENT_PRICE.LAST_PRICE
        }

        where { row, parameters ->
            row.instrumentId.equals(parameters.getString("INSTRUMENT_ID"))
        }
    }

    requestReply("ALL_REQ_INSTRUMENTS", INSTRUMENT)
    requestReply("ALL_REQ_TRADES", TRADE)
}
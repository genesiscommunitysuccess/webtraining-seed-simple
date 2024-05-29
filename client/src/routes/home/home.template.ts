import {html} from '@genesislcap/web-core';
import type {Home} from './home';
import { tradeFormCreateSchema, tradeFormUpdateSchema } from './schemas';


export const HomeTemplate = html<Home>`
    <rapid-card class="top-layout">
        <entity-management
          resourceName="ALL_TRADES"
          title = "Trades"
          entityLabel="Trades"
          createEvent = "EVENT_TRADE_INSERT"
          updateEvent = "EVENT_TRADE_MODIFY"
          deleteEvent = "EVENT_TRADE_CANCELLED"
          :columns=${x => x.columns}
          :createFormUiSchema=${() => tradeFormCreateSchema}
          :updateFormUiSchema=${() => tradeFormUpdateSchema}
        ></entity-management>
    </rapid-card>
    <rapid-card class="positions-card top-layout">
        <span class="card-title">Positions</span>
        <rapid-grid-pro>
              <grid-pro-genesis-datasource resource-name="ALL_POSITIONS"></grid-pro-genesis-datasource>
        </rapid-grid-pro>
    </rapid-card>
`;

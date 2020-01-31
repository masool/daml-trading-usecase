package com.digitalasset.damlpoc.trade;

import com.daml.ledger.javaapi.data.Contract;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.Identifier;
import com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueAgreement;
import com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueProposal;
import com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeMaster;
import com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Trade;
import com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeExecuted;
import com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueAgreement;
import com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueProposal;
import com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeMaster;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class TemplateDecoder {
  private static HashMap<Identifier, Function<CreatedEvent, Contract>> decoders;

  static {
    decoders = new HashMap<Identifier, Function<CreatedEvent, Contract>>();
    decoders.put(TradeMaster.TEMPLATE_ID, TradeMaster.Contract::fromCreatedEvent);
    decoders.put(TradeIssueAgreement.TEMPLATE_ID, TradeIssueAgreement.Contract::fromCreatedEvent);
    decoders.put(Trade.TEMPLATE_ID, Trade.Contract::fromCreatedEvent);
    decoders.put(TradeExecuted.TEMPLATE_ID, TradeExecuted.Contract::fromCreatedEvent);
    decoders.put(TradeIssueProposal.TEMPLATE_ID, TradeIssueProposal.Contract::fromCreatedEvent);
    decoders.put(BrokerTradeMaster.TEMPLATE_ID, BrokerTradeMaster.Contract::fromCreatedEvent);
    decoders.put(BrokerTradeIssueProposal.TEMPLATE_ID, BrokerTradeIssueProposal.Contract::fromCreatedEvent);
    decoders.put(BrokerTradeIssueAgreement.TEMPLATE_ID, BrokerTradeIssueAgreement.Contract::fromCreatedEvent);
  }

  public static Contract fromCreatedEvent(CreatedEvent event) throws IllegalArgumentException {
    Identifier templateId = event.getTemplateId();
    Function<CreatedEvent, Contract> decoderFunc = getDecoder(templateId).orElseThrow(() -> new IllegalArgumentException("No template found for identifier " + templateId));
    return decoderFunc.apply(event);
  }

  public static Optional<Function<CreatedEvent, Contract>> getDecoder(Identifier templateId) {
    return Optional.ofNullable(decoders.get(templateId));
  }
}

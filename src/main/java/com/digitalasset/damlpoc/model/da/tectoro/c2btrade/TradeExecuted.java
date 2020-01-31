package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Decimal;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class TradeExecuted extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04", "DA.Tectoro.C2BTrade", "TradeExecuted");

  public final String broker;

  public final String regulator;

  public final String exchange;

  public final String securityId;

  public final LocalDate tradeDate;

  public final String openQty;

  public final Long filledQty;

  public final String status;

  public final String orderId;

  public final String operation;

  public final String client;

  public final String executionId;

  public final Long qty;

  public final BigDecimal price;

  public TradeExecuted(String broker, String regulator, String exchange, String securityId,
      LocalDate tradeDate, String openQty, Long filledQty, String status, String orderId,
      String operation, String client, String executionId, Long qty, BigDecimal price) {
    this.broker = broker;
    this.regulator = regulator;
    this.exchange = exchange;
    this.securityId = securityId;
    this.tradeDate = tradeDate;
    this.openQty = openQty;
    this.filledQty = filledQty;
    this.status = status;
    this.orderId = orderId;
    this.operation = operation;
    this.client = client;
    this.executionId = executionId;
    this.qty = qty;
    this.price = price;
  }

  public CreateCommand create() {
    return new CreateCommand(TradeExecuted.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Unit arg) {
    return new CreateAndExerciseCommand(TradeExecuted.TEMPLATE_ID, this.toValue(), "Archive", arg);
  }

  public static CreateCommand create(String broker, String regulator, String exchange,
      String securityId, LocalDate tradeDate, String openQty, Long filledQty, String status,
      String orderId, String operation, String client, String executionId, Long qty,
      BigDecimal price) {
    return new TradeExecuted(broker, regulator, exchange, securityId, tradeDate, openQty, filledQty, status, orderId, operation, client, executionId, qty, price).create();
  }

  public static TradeExecuted fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 14) {
      throw new IllegalArgumentException("Expected 14 arguments, got " + numberOfFields);
    }
    String broker = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected broker to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String regulator = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected regulator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String exchange = fields$.get(2).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected exchange to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String securityId = fields$.get(3).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected securityId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    LocalDate tradeDate = fields$.get(4).getValue().asDate().orElseThrow(() -> new IllegalArgumentException("Expected tradeDate to be of type com.daml.ledger.javaapi.data.Date")).getValue();
    String openQty = fields$.get(5).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected openQty to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    Long filledQty = fields$.get(6).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected filledQty to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    String status = fields$.get(7).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected status to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String orderId = fields$.get(8).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected orderId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String operation = fields$.get(9).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected operation to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String client = fields$.get(10).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected client to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String executionId = fields$.get(11).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected executionId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    Long qty = fields$.get(12).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected qty to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    BigDecimal price = fields$.get(13).getValue().asDecimal().orElseThrow(() -> new IllegalArgumentException("Expected price to be of type com.daml.ledger.javaapi.data.Decimal")).getValue();
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeExecuted(broker, regulator, exchange, securityId, tradeDate, openQty, filledQty, status, orderId, operation, client, executionId, qty, price);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(14);
    fields.add(new Record.Field("broker", new Party(this.broker)));
    fields.add(new Record.Field("regulator", new Party(this.regulator)));
    fields.add(new Record.Field("exchange", new Party(this.exchange)));
    fields.add(new Record.Field("securityId", new Text(this.securityId)));
    fields.add(new Record.Field("tradeDate", new Date((int) this.tradeDate.toEpochDay())));
    fields.add(new Record.Field("openQty", new Text(this.openQty)));
    fields.add(new Record.Field("filledQty", new Int64(this.filledQty)));
    fields.add(new Record.Field("status", new Text(this.status)));
    fields.add(new Record.Field("orderId", new Text(this.orderId)));
    fields.add(new Record.Field("operation", new Text(this.operation)));
    fields.add(new Record.Field("client", new Party(this.client)));
    fields.add(new Record.Field("executionId", new Text(this.executionId)));
    fields.add(new Record.Field("qty", new Int64(this.qty)));
    fields.add(new Record.Field("price", new Decimal(this.price)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof TradeExecuted)) {
      return false;
    }
    TradeExecuted other = (TradeExecuted) object;
    return this.broker.equals(other.broker) && this.regulator.equals(other.regulator) && this.exchange.equals(other.exchange) && this.securityId.equals(other.securityId) && this.tradeDate.equals(other.tradeDate) && this.openQty.equals(other.openQty) && this.filledQty.equals(other.filledQty) && this.status.equals(other.status) && this.orderId.equals(other.orderId) && this.operation.equals(other.operation) && this.client.equals(other.client) && this.executionId.equals(other.executionId) && this.qty.equals(other.qty) && this.price.equals(other.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.broker, this.regulator, this.exchange, this.securityId, this.tradeDate, this.openQty, this.filledQty, this.status, this.orderId, this.operation, this.client, this.executionId, this.qty, this.price);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeExecuted(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", this.broker, this.regulator, this.exchange, this.securityId, this.tradeDate, this.openQty, this.filledQty, this.status, this.orderId, this.operation, this.client, this.executionId, this.qty, this.price);
  }

  public static final class ContractId {
    public final String contractId;

    public ContractId(String contractId) {
      this.contractId = contractId;
    }

    public ExerciseCommand exerciseArchive(Unit arg) {
      return new ExerciseCommand(TradeExecuted.TEMPLATE_ID, this.contractId, "Archive", arg);
    }

    public Value toValue() {
      return new com.daml.ledger.javaapi.data.ContractId(this.contractId);
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof ContractId)) {
        return false;
      }
      ContractId other = (ContractId) object;
      return this.contractId.equals(other.contractId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.contractId);
    }

    @Override
    public String toString() {
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeExecuted.ContractId(%s)", this.contractId);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final TradeExecuted data;

    public final Optional<String> agreementText;

    public Contract(ContractId id, TradeExecuted data, Optional<String> agreementText) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText) {
      ContractId id = new ContractId(contractId);
      TradeExecuted data = TradeExecuted.fromValue(record$);
      return new Contract(id, data, agreementText);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      TradeExecuted data = TradeExecuted.fromValue(record$);
      return new Contract(id, data, Optional.empty());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText());
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof Contract)) {
        return false;
      }
      Contract other = (Contract) object;
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText);
    }

    @Override
    public String toString() {
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeExecuted.Contract(%s, %s, %s)", this.id, this.data, this.agreementText);
    }
  }
}

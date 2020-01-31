package com.digitalasset.damlpoc.model.da.tectoro.facts;

import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Decimal;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
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

public class OrderTerms {
  public static final String _packageId = "7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04";

  public final String operation;

  public final String securityId;

  public final String orderId;

  public final Long qty;

  public final BigDecimal price;

  public final String exchange;

  public final String regulator;

  public final LocalDate tradeDate;

  public OrderTerms(String operation, String securityId, String orderId, Long qty, BigDecimal price,
      String exchange, String regulator, LocalDate tradeDate) {
    this.operation = operation;
    this.securityId = securityId;
    this.orderId = orderId;
    this.qty = qty;
    this.price = price;
    this.exchange = exchange;
    this.regulator = regulator;
    this.tradeDate = tradeDate;
  }

  public static OrderTerms fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 8) {
      throw new IllegalArgumentException("Expected 8 arguments, got " + numberOfFields);
    }
    String operation = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected operation to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String securityId = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected securityId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String orderId = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected orderId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    Long qty = fields$.get(3).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected qty to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    BigDecimal price = fields$.get(4).getValue().asDecimal().orElseThrow(() -> new IllegalArgumentException("Expected price to be of type com.daml.ledger.javaapi.data.Decimal")).getValue();
    String exchange = fields$.get(5).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected exchange to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String regulator = fields$.get(6).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected regulator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    LocalDate tradeDate = fields$.get(7).getValue().asDate().orElseThrow(() -> new IllegalArgumentException("Expected tradeDate to be of type com.daml.ledger.javaapi.data.Date")).getValue();
    return new com.digitalasset.damlpoc.model.da.tectoro.facts.OrderTerms(operation, securityId, orderId, qty, price, exchange, regulator, tradeDate);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(8);
    fields.add(new Record.Field("operation", new Text(this.operation)));
    fields.add(new Record.Field("securityId", new Text(this.securityId)));
    fields.add(new Record.Field("orderId", new Text(this.orderId)));
    fields.add(new Record.Field("qty", new Int64(this.qty)));
    fields.add(new Record.Field("price", new Decimal(this.price)));
    fields.add(new Record.Field("exchange", new Party(this.exchange)));
    fields.add(new Record.Field("regulator", new Party(this.regulator)));
    fields.add(new Record.Field("tradeDate", new Date((int) this.tradeDate.toEpochDay())));
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
    if (!(object instanceof OrderTerms)) {
      return false;
    }
    OrderTerms other = (OrderTerms) object;
    return this.operation.equals(other.operation) && this.securityId.equals(other.securityId) && this.orderId.equals(other.orderId) && this.qty.equals(other.qty) && this.price.equals(other.price) && this.exchange.equals(other.exchange) && this.regulator.equals(other.regulator) && this.tradeDate.equals(other.tradeDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operation, this.securityId, this.orderId, this.qty, this.price, this.exchange, this.regulator, this.tradeDate);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.facts.OrderTerms(%s, %s, %s, %s, %s, %s, %s, %s)", this.operation, this.securityId, this.orderId, this.qty, this.price, this.exchange, this.regulator, this.tradeDate);
  }
}

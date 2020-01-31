package com.digitalasset.damlpoc.model.da.tectoro.b2eagree;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExchangeAccept {
  public static final String _packageId = "7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04";

  public final Long tradingLimit;

  public final String volumeLimit;

  public final Long exchangeFee;

  public ExchangeAccept(Long tradingLimit, String volumeLimit, Long exchangeFee) {
    this.tradingLimit = tradingLimit;
    this.volumeLimit = volumeLimit;
    this.exchangeFee = exchangeFee;
  }

  public static ExchangeAccept fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    Long tradingLimit = fields$.get(0).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected tradingLimit to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    String volumeLimit = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected volumeLimit to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    Long exchangeFee = fields$.get(2).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected exchangeFee to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    return new com.digitalasset.damlpoc.model.da.tectoro.b2eagree.ExchangeAccept(tradingLimit, volumeLimit, exchangeFee);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("tradingLimit", new Int64(this.tradingLimit)));
    fields.add(new Record.Field("volumeLimit", new Text(this.volumeLimit)));
    fields.add(new Record.Field("exchangeFee", new Int64(this.exchangeFee)));
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
    if (!(object instanceof ExchangeAccept)) {
      return false;
    }
    ExchangeAccept other = (ExchangeAccept) object;
    return this.tradingLimit.equals(other.tradingLimit) && this.volumeLimit.equals(other.volumeLimit) && this.exchangeFee.equals(other.exchangeFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tradingLimit, this.volumeLimit, this.exchangeFee);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.b2eagree.ExchangeAccept(%s, %s, %s)", this.tradingLimit, this.volumeLimit, this.exchangeFee);
  }
}

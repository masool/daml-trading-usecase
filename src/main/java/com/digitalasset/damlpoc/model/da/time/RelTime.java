package com.digitalasset.damlpoc.model.da.time;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RelTime {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Long microseconds;

  public RelTime(Long microseconds) {
    this.microseconds = microseconds;
  }

  public static RelTime fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Long microseconds = fields$.get(0).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected microseconds to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    return new com.digitalasset.damlpoc.model.da.time.RelTime(microseconds);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("microseconds", new Int64(this.microseconds)));
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
    if (!(object instanceof RelTime)) {
      return false;
    }
    RelTime other = (RelTime) object;
    return this.microseconds.equals(other.microseconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.microseconds);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.time.RelTime(%s)", this.microseconds);
  }
}

package com.digitalasset.damlpoc.model.da.monoid;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class All {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Boolean getAll;

  public All(Boolean getAll) {
    this.getAll = getAll;
  }

  public static All fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Boolean getAll = fields$.get(0).getValue().asBool().orElseThrow(() -> new IllegalArgumentException("Expected getAll to be of type com.daml.ledger.javaapi.data.Bool")).getValue();
    return new com.digitalasset.damlpoc.model.da.monoid.All(getAll);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("getAll", new Bool(this.getAll)));
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
    if (!(object instanceof All)) {
      return false;
    }
    All other = (All) object;
    return this.getAll.equals(other.getAll);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getAll);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.monoid.All(%s)", this.getAll);
  }
}

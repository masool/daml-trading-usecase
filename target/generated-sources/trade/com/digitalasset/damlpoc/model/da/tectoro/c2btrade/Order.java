package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import com.digitalasset.damlpoc.model.da.tectoro.facts.OrderTerms;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
  public static final String _packageId = "7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04";

  public final OrderTerms terms;

  public Order(OrderTerms terms) {
    this.terms = terms;
  }

  public static Order fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    OrderTerms terms = OrderTerms.fromValue(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Order(terms);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("terms", this.terms.toValue()));
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
    if (!(object instanceof Order)) {
      return false;
    }
    Order other = (Order) object;
    return this.terms.equals(other.terms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.terms);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Order(%s)", this.terms);
  }
}

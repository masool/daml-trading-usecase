package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Execute {
  public static final String _packageId = "7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04";

  public final String executionId;

  public Execute(String executionId) {
    this.executionId = executionId;
  }

  public static Execute fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String executionId = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected executionId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Execute(executionId);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("executionId", new Text(this.executionId)));
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
    if (!(object instanceof Execute)) {
      return false;
    }
    Execute other = (Execute) object;
    return this.executionId.equals(other.executionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.executionId);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Execute(%s)", this.executionId);
  }
}

package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AcceptTradeProposal {
  public static final String _packageId = "7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04";

  public AcceptTradeProposal() {
  }

  public static AcceptTradeProposal fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 0) {
      throw new IllegalArgumentException("Expected 0 arguments, got " + numberOfFields);
    }
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.AcceptTradeProposal();
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(0);
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
    if (!(object instanceof AcceptTradeProposal)) {
      return false;
    }
    AcceptTradeProposal other = (AcceptTradeProposal) object;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "com.digitalasset.damlpoc.model.da.tectoro.c2btrade.AcceptTradeProposal";
  }
}

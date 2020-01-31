package com.digitalasset.damlpoc.model.da.internal.template;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Archive {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public Archive() {
  }

  public static Archive fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 0) {
      throw new IllegalArgumentException("Expected 0 arguments, got " + numberOfFields);
    }
    return new com.digitalasset.damlpoc.model.da.internal.template.Archive();
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
    if (!(object instanceof Archive)) {
      return false;
    }
    Archive other = (Archive) object;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    return "com.digitalasset.damlpoc.model.da.internal.template.Archive";
  }
}

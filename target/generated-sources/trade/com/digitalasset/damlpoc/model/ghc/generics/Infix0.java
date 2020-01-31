package com.digitalasset.damlpoc.model.ghc.generics;

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

public class Infix0 {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final Associativity associativity;

  public final Long fixity;

  public Infix0(Associativity associativity, Long fixity) {
    this.associativity = associativity;
    this.fixity = fixity;
  }

  public static Infix0 fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    Associativity associativity = Associativity.fromValue(fields$.get(0).getValue());
    Long fixity = fields$.get(1).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected fixity to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    return new com.digitalasset.damlpoc.model.ghc.generics.Infix0(associativity, fixity);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("associativity", this.associativity.toValue()));
    fields.add(new Record.Field("fixity", new Int64(this.fixity)));
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
    if (!(object instanceof Infix0)) {
      return false;
    }
    Infix0 other = (Infix0) object;
    return this.associativity.equals(other.associativity) && this.fixity.equals(other.fixity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.associativity, this.fixity);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.ghc.generics.Infix0(%s, %s)", this.associativity, this.fixity);
  }
}

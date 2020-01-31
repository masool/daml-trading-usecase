package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class K1<i, c, p> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final c unK1;

  public K1(c unK1) {
    this.unK1 = unK1;
  }

  public static <i, c, p> K1<i, c, p> fromValue(Value value$, Function<Value, c> fromValuec) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    c unK1 = fromValuec.apply(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.ghc.generics.K1<i, c, p>(unK1);
  }

  public Record toValue(Function<c, Value> toValuec) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("unK1", toValuec.apply(this.unK1)));
    return new Record(fields);
  }

  public static <i, c, p> K1<i, c, p> fromValue(Value value$, Function<Value, i> fromValuei,
      Function<Value, c> fromValuec, Function<Value, p> fromValuep) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    c unK1 = fromValuec.apply(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.ghc.generics.K1<i, c, p>(unK1);
  }

  public Record toValue(Function<i, Value> toValuei, Function<c, Value> toValuec,
      Function<p, Value> toValuep) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("unK1", toValuec.apply(this.unK1)));
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
    if (!(object instanceof K1)) {
      return false;
    }
    K1 other = (K1) object;
    return this.unK1.equals(other.unK1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unK1);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.ghc.generics.K1(%s)", this.unK1);
  }
}

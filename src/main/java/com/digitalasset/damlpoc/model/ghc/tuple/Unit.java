package com.digitalasset.damlpoc.model.ghc.tuple;

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

public class Unit<a> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final a _1;

  public Unit(a _1) {
    this._1 = _1;
  }

  public static <a> Unit<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    a _1 = fromValuea.apply(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.ghc.tuple.Unit<a>(_1);
  }

  public Record toValue(Function<a, Value> toValuea) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("_1", toValuea.apply(this._1)));
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
    if (!(object instanceof Unit)) {
      return false;
    }
    Unit other = (Unit) object;
    return this._1.equals(other._1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.ghc.tuple.Unit(%s)", this._1);
  }
}

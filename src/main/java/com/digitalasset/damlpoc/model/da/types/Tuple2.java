package com.digitalasset.damlpoc.model.da.types;

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

public class Tuple2<a, b> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final a _1;

  public final b _2;

  public Tuple2(a _1, b _2) {
    this._1 = _1;
    this._2 = _2;
  }

  public static <a, b> Tuple2<a, b> fromValue(Value value$, Function<Value, a> fromValuea,
      Function<Value, b> fromValueb) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    a _1 = fromValuea.apply(fields$.get(0).getValue());
    b _2 = fromValueb.apply(fields$.get(1).getValue());
    return new com.digitalasset.damlpoc.model.da.types.Tuple2<a, b>(_1, _2);
  }

  public Record toValue(Function<a, Value> toValuea, Function<b, Value> toValueb) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("_1", toValuea.apply(this._1)));
    fields.add(new Record.Field("_2", toValueb.apply(this._2)));
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
    if (!(object instanceof Tuple2)) {
      return false;
    }
    Tuple2 other = (Tuple2) object;
    return this._1.equals(other._1) && this._2.equals(other._2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.types.Tuple2(%s, %s)", this._1, this._2);
  }
}

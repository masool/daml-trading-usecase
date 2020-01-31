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

public class Tuple4<a, b, c, d> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final a _1;

  public final b _2;

  public final c _3;

  public final d _4;

  public Tuple4(a _1, b _2, c _3, d _4) {
    this._1 = _1;
    this._2 = _2;
    this._3 = _3;
    this._4 = _4;
  }

  public static <a, b, c, d> Tuple4<a, b, c, d> fromValue(Value value$,
      Function<Value, a> fromValuea, Function<Value, b> fromValueb, Function<Value, c> fromValuec,
      Function<Value, d> fromValued) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    a _1 = fromValuea.apply(fields$.get(0).getValue());
    b _2 = fromValueb.apply(fields$.get(1).getValue());
    c _3 = fromValuec.apply(fields$.get(2).getValue());
    d _4 = fromValued.apply(fields$.get(3).getValue());
    return new com.digitalasset.damlpoc.model.da.types.Tuple4<a, b, c, d>(_1, _2, _3, _4);
  }

  public Record toValue(Function<a, Value> toValuea, Function<b, Value> toValueb,
      Function<c, Value> toValuec, Function<d, Value> toValued) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("_1", toValuea.apply(this._1)));
    fields.add(new Record.Field("_2", toValueb.apply(this._2)));
    fields.add(new Record.Field("_3", toValuec.apply(this._3)));
    fields.add(new Record.Field("_4", toValued.apply(this._4)));
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
    if (!(object instanceof Tuple4)) {
      return false;
    }
    Tuple4 other = (Tuple4) object;
    return this._1.equals(other._1) && this._2.equals(other._2) && this._3.equals(other._3) && this._4.equals(other._4);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2, this._3, this._4);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.types.Tuple4(%s, %s, %s, %s)", this._1, this._2, this._3, this._4);
  }
}

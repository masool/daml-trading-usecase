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

public class Tuple7<a, b, c, d, e, f, g> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final a _1;

  public final b _2;

  public final c _3;

  public final d _4;

  public final e _5;

  public final f _6;

  public final g _7;

  public Tuple7(a _1, b _2, c _3, d _4, e _5, f _6, g _7) {
    this._1 = _1;
    this._2 = _2;
    this._3 = _3;
    this._4 = _4;
    this._5 = _5;
    this._6 = _6;
    this._7 = _7;
  }

  public static <a, b, c, d, e, f, g> Tuple7<a, b, c, d, e, f, g> fromValue(Value value$,
      Function<Value, a> fromValuea, Function<Value, b> fromValueb, Function<Value, c> fromValuec,
      Function<Value, d> fromValued, Function<Value, e> fromValuee, Function<Value, f> fromValuef,
      Function<Value, g> fromValueg) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 7) {
      throw new IllegalArgumentException("Expected 7 arguments, got " + numberOfFields);
    }
    a _1 = fromValuea.apply(fields$.get(0).getValue());
    b _2 = fromValueb.apply(fields$.get(1).getValue());
    c _3 = fromValuec.apply(fields$.get(2).getValue());
    d _4 = fromValued.apply(fields$.get(3).getValue());
    e _5 = fromValuee.apply(fields$.get(4).getValue());
    f _6 = fromValuef.apply(fields$.get(5).getValue());
    g _7 = fromValueg.apply(fields$.get(6).getValue());
    return new com.digitalasset.damlpoc.model.da.types.Tuple7<a, b, c, d, e, f, g>(_1, _2, _3, _4, _5, _6, _7);
  }

  public Record toValue(Function<a, Value> toValuea, Function<b, Value> toValueb,
      Function<c, Value> toValuec, Function<d, Value> toValued, Function<e, Value> toValuee,
      Function<f, Value> toValuef, Function<g, Value> toValueg) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(7);
    fields.add(new Record.Field("_1", toValuea.apply(this._1)));
    fields.add(new Record.Field("_2", toValueb.apply(this._2)));
    fields.add(new Record.Field("_3", toValuec.apply(this._3)));
    fields.add(new Record.Field("_4", toValued.apply(this._4)));
    fields.add(new Record.Field("_5", toValuee.apply(this._5)));
    fields.add(new Record.Field("_6", toValuef.apply(this._6)));
    fields.add(new Record.Field("_7", toValueg.apply(this._7)));
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
    if (!(object instanceof Tuple7)) {
      return false;
    }
    Tuple7 other = (Tuple7) object;
    return this._1.equals(other._1) && this._2.equals(other._2) && this._3.equals(other._3) && this._4.equals(other._4) && this._5.equals(other._5) && this._6.equals(other._6) && this._7.equals(other._7);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this._1, this._2, this._3, this._4, this._5, this._6, this._7);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.types.Tuple7(%s, %s, %s, %s, %s, %s, %s)", this._1, this._2, this._3, this._4, this._5, this._6, this._7);
  }
}

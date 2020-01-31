package com.digitalasset.damlpoc.model.da.nonempty;

import com.daml.ledger.javaapi.data.DamlList;
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
import java.util.stream.Collectors;

public class NonEmpty<a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final a hd;

  public final List<a> tl;

  public NonEmpty(a hd, List<a> tl) {
    this.hd = hd;
    this.tl = tl;
  }

  public static <a> NonEmpty<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    a hd = fromValuea.apply(fields$.get(0).getValue());
    List<a> tl = fields$.get(1).getValue().asList().map(v$0 -> v$0.getValues().stream().map(v$1 -> fromValuea.apply(v$1)).collect(Collectors.<a>toList())).orElseThrow(() -> new IllegalArgumentException("Expected tl to be of type com.daml.ledger.javaapi.data.DamlList"));
    return new com.digitalasset.damlpoc.model.da.nonempty.NonEmpty<a>(hd, tl);
  }

  public Record toValue(Function<a, Value> toValuea) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("hd", toValuea.apply(this.hd)));
    fields.add(new Record.Field("tl", new DamlList(this.tl.stream().map(v$0 -> toValuea.apply(v$0)).collect(Collectors.<Value>toList()))));
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
    if (!(object instanceof NonEmpty)) {
      return false;
    }
    NonEmpty other = (NonEmpty) object;
    return this.hd.equals(other.hd) && this.tl.equals(other.tl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.hd, this.tl);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.nonempty.NonEmpty(%s, %s)", this.hd, this.tl);
  }
}

package com.digitalasset.damlpoc.model.da.map.map;

import com.daml.ledger.javaapi.data.DamlList;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.map.Map;
import com.digitalasset.damlpoc.model.da.types.Tuple2;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map_internal<k, v> extends Map<k, v> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final List<Tuple2<k, v>> listValue;

  public Map_internal(List<Tuple2<k, v>> listValue) {
    this.listValue = listValue;
  }

  public Variant toValue(Function<k, Value> toValuek, Function<v, Value> toValuev) {
    return new Variant("Map_internal", new DamlList(this.listValue.stream().map(v$0 -> v$0.toValue(v$1 -> toValuek.apply(v$1),v$2 -> toValuev.apply(v$2))).collect(Collectors.<Value>toList())));
  }

  public static <k, v> Map_internal<k, v> fromValue(Value value$, Function<Value, k> fromValuek,
      Function<Value, v> fromValuev) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Map_internal".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Map_internal. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    List<Tuple2<k, v>> body = variantValue$.asList().map(v$0 -> v$0.getValues().stream().map(v$1 -> Tuple2.<k, v>fromValue(v$1, v$2 -> fromValuek.apply(v$2), v$3 -> fromValuev.apply(v$3))).collect(Collectors.<com.digitalasset.damlpoc.model.da.types.Tuple2<k, v>>toList())).orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.DamlList"));
    return new Map_internal<k, v>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Map_internal)) {
      return false;
    }
    Map_internal other = (Map_internal) object;
    return this.listValue.equals(other.listValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.listValue);
  }

  @Override
  public String toString() {
    return String.format("Map_internal(%s)", this.listValue);
  }
}

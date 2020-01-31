package com.digitalasset.damlpoc.model.da.set.set;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.map.Map;
import com.digitalasset.damlpoc.model.da.set.Set;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Set_internal<a> extends Set<a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Map<a, Unit> mapValue;

  public Set_internal(Map<a, Unit> mapValue) {
    this.mapValue = mapValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Set_internal", this.mapValue.toValue(v$0 -> toValuea.apply(v$0),v$1 -> Unit.getInstance()));
  }

  public static <a> Set_internal<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Set_internal".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Set_internal. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Map<a, Unit> body = Map.<a, com.daml.ledger.javaapi.data.Unit>fromValue(variantValue$, v$0 -> fromValuea.apply(v$0), v$1 -> v$1.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit")));
    return new Set_internal<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Set_internal)) {
      return false;
    }
    Set_internal other = (Set_internal) object;
    return this.mapValue.equals(other.mapValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.mapValue);
  }

  @Override
  public String toString() {
    return String.format("Set_internal(%s)", this.mapValue);
  }
}

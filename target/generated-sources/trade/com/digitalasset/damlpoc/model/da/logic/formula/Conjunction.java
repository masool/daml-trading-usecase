package com.digitalasset.damlpoc.model.da.logic.formula;

import com.daml.ledger.javaapi.data.DamlList;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.logic.Formula;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Conjunction<t> extends Formula<t> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final List<Formula<t>> listValue;

  public Conjunction(List<Formula<t>> listValue) {
    this.listValue = listValue;
  }

  public Variant toValue(Function<t, Value> toValuet) {
    return new Variant("Conjunction", new DamlList(this.listValue.stream().map(v$0 -> v$0.toValue(v$1 -> toValuet.apply(v$1))).collect(Collectors.<Value>toList())));
  }

  public static <t> Conjunction<t> fromValue(Value value$, Function<Value, t> fromValuet) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Conjunction".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Conjunction. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    List<Formula<t>> body = variantValue$.asList().map(v$0 -> v$0.getValues().stream().map(v$1 -> Formula.<t>fromValue(v$1, v$2 -> fromValuet.apply(v$2))).collect(Collectors.<com.digitalasset.damlpoc.model.da.logic.Formula<t>>toList())).orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.DamlList"));
    return new Conjunction<t>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Conjunction)) {
      return false;
    }
    Conjunction other = (Conjunction) object;
    return this.listValue.equals(other.listValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.listValue);
  }

  @Override
  public String toString() {
    return String.format("Conjunction(%s)", this.listValue);
  }
}

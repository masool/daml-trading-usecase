package com.digitalasset.damlpoc.model.da.logic.formula;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.logic.Formula;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Proposition<t> extends Formula<t> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final t tValue;

  public Proposition(t tValue) {
    this.tValue = tValue;
  }

  public Variant toValue(Function<t, Value> toValuet) {
    return new Variant("Proposition", toValuet.apply(this.tValue));
  }

  public static <t> Proposition<t> fromValue(Value value$, Function<Value, t> fromValuet) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Proposition".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Proposition. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    t body = fromValuet.apply(variantValue$);
    return new Proposition<t>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Proposition)) {
      return false;
    }
    Proposition other = (Proposition) object;
    return this.tValue.equals(other.tValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tValue);
  }

  @Override
  public String toString() {
    return String.format("Proposition(%s)", this.tValue);
  }
}

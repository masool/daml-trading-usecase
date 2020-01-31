package com.digitalasset.damlpoc.model.da.internal.prelude.optional;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.internal.prelude.Optional;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Some<a> extends Optional<a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final a aValue;

  public Some(a aValue) {
    this.aValue = aValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Some", toValuea.apply(this.aValue));
  }

  public static <a> Some<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Some".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Some. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Some<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Some)) {
      return false;
    }
    Some other = (Some) object;
    return this.aValue.equals(other.aValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.aValue);
  }

  @Override
  public String toString() {
    return String.format("Some(%s)", this.aValue);
  }
}

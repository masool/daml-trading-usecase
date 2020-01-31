package com.digitalasset.damlpoc.model.da.internal.prelude.optional;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.internal.prelude.Optional;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class None<a> extends Optional<a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Unit unitValue;

  public None(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("None", Unit.getInstance());
  }

  public static <a> None<a> fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"None".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: None. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new None<a>(body);
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("None", Unit.getInstance());
  }

  public static <a> None<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"None".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: None. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new None<a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof None)) {
      return false;
    }
    None other = (None) object;
    return this.unitValue.equals(other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("None(%s)", this.unitValue);
  }
}

package com.digitalasset.damlpoc.model.da.validation.validation;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.validation.Validation;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Success<err, a> extends Validation<err, a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final a aValue;

  public Success(a aValue) {
    this.aValue = aValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Success", toValuea.apply(this.aValue));
  }

  public static <err, a> Success<err, a> fromValue(Value value$, Function<Value, a> fromValuea)
      throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Success".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Success. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Success<err, a>(body);
  }

  public Variant toValue(Function<err, Value> toValueerr, Function<a, Value> toValuea) {
    return new Variant("Success", toValuea.apply(this.aValue));
  }

  public static <err, a> Success<err, a> fromValue(Value value$, Function<Value, err> fromValueerr,
      Function<Value, a> fromValuea) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Success".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Success. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Success<err, a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Success)) {
      return false;
    }
    Success other = (Success) object;
    return this.aValue.equals(other.aValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.aValue);
  }

  @Override
  public String toString() {
    return String.format("Success(%s)", this.aValue);
  }
}

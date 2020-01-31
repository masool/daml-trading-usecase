package com.digitalasset.damlpoc.model.da.validation.validation;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.nonempty.NonEmpty;
import com.digitalasset.damlpoc.model.da.validation.Validation;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Errors<err, a> extends Validation<err, a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final NonEmpty<err> nonEmptyValue;

  public Errors(NonEmpty<err> nonEmptyValue) {
    this.nonEmptyValue = nonEmptyValue;
  }

  public Variant toValue(Function<err, Value> toValueerr) {
    return new Variant("Errors", this.nonEmptyValue.toValue(v$0 -> toValueerr.apply(v$0)));
  }

  public static <err, a> Errors<err, a> fromValue(Value value$, Function<Value, err> fromValueerr)
      throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Errors".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Errors. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    NonEmpty<err> body = NonEmpty.<err>fromValue(variantValue$, v$0 -> fromValueerr.apply(v$0));
    return new Errors<err, a>(body);
  }

  public Variant toValue(Function<err, Value> toValueerr, Function<a, Value> toValuea) {
    return new Variant("Errors", this.nonEmptyValue.toValue(v$0 -> toValueerr.apply(v$0)));
  }

  public static <err, a> Errors<err, a> fromValue(Value value$, Function<Value, err> fromValueerr,
      Function<Value, a> fromValuea) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Errors".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Errors. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    NonEmpty<err> body = NonEmpty.<err>fromValue(variantValue$, v$0 -> fromValueerr.apply(v$0));
    return new Errors<err, a>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Errors)) {
      return false;
    }
    Errors other = (Errors) object;
    return this.nonEmptyValue.equals(other.nonEmptyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nonEmptyValue);
  }

  @Override
  public String toString() {
    return String.format("Errors(%s)", this.nonEmptyValue);
  }
}

package com.digitalasset.damlpoc.model.da.types.either;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.types.Either;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Left<a, b> extends Either<a, b> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final a aValue;

  public Left(a aValue) {
    this.aValue = aValue;
  }

  public Variant toValue(Function<a, Value> toValuea) {
    return new Variant("Left", toValuea.apply(this.aValue));
  }

  public static <a, b> Left<a, b> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Left".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Left. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Left<a, b>(body);
  }

  public Variant toValue(Function<a, Value> toValuea, Function<b, Value> toValueb) {
    return new Variant("Left", toValuea.apply(this.aValue));
  }

  public static <a, b> Left<a, b> fromValue(Value value$, Function<Value, a> fromValuea,
      Function<Value, b> fromValueb) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Left".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Left. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    a body = fromValuea.apply(variantValue$);
    return new Left<a, b>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Left)) {
      return false;
    }
    Left other = (Left) object;
    return this.aValue.equals(other.aValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.aValue);
  }

  @Override
  public String toString() {
    return String.format("Left(%s)", this.aValue);
  }
}

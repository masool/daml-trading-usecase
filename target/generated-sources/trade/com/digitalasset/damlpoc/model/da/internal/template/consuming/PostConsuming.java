package com.digitalasset.damlpoc.model.da.internal.template.consuming;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.da.internal.template.Consuming;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class PostConsuming extends Consuming {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Unit unitValue;

  public PostConsuming(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("PostConsuming", Unit.getInstance());
  }

  public static PostConsuming fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"PostConsuming".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: PostConsuming. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new PostConsuming(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof PostConsuming)) {
      return false;
    }
    PostConsuming other = (PostConsuming) object;
    return this.unitValue.equals(other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("PostConsuming(%s)", this.unitValue);
  }
}

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

public class Negation<t> extends Formula<t> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Formula<t> formulaValue;

  public Negation(Formula<t> formulaValue) {
    this.formulaValue = formulaValue;
  }

  public Variant toValue(Function<t, Value> toValuet) {
    return new Variant("Negation", this.formulaValue.toValue(v$0 -> toValuet.apply(v$0)));
  }

  public static <t> Negation<t> fromValue(Value value$, Function<Value, t> fromValuet) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Negation".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Negation. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Formula<t> body = Formula.<t>fromValue(variantValue$, v$0 -> fromValuet.apply(v$0));
    return new Negation<t>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Negation)) {
      return false;
    }
    Negation other = (Negation) object;
    return this.formulaValue.equals(other.formulaValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.formulaValue);
  }

  @Override
  public String toString() {
    return String.format("Negation(%s)", this.formulaValue);
  }
}

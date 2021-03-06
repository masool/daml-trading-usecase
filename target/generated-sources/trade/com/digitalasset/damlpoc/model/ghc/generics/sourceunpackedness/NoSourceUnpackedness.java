package com.digitalasset.damlpoc.model.ghc.generics.sourceunpackedness;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.ghc.generics.SourceUnpackedness;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class NoSourceUnpackedness extends SourceUnpackedness {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final Unit unitValue;

  public NoSourceUnpackedness(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("NoSourceUnpackedness", Unit.getInstance());
  }

  public static NoSourceUnpackedness fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"NoSourceUnpackedness".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: NoSourceUnpackedness. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new NoSourceUnpackedness(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof NoSourceUnpackedness)) {
      return false;
    }
    NoSourceUnpackedness other = (NoSourceUnpackedness) object;
    return this.unitValue.equals(other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("NoSourceUnpackedness(%s)", this.unitValue);
  }
}

package com.digitalasset.damlpoc.model.ghc.generics.decidedstrictness;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.digitalasset.damlpoc.model.ghc.generics.DecidedStrictness;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class DecidedStrict extends DecidedStrictness {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final Unit unitValue;

  public DecidedStrict(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("DecidedStrict", Unit.getInstance());
  }

  public static DecidedStrict fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"DecidedStrict".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: DecidedStrict. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Unit body = variantValue$.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Unit"));
    return new DecidedStrict(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof DecidedStrict)) {
      return false;
    }
    DecidedStrict other = (DecidedStrict) object;
    return this.unitValue.equals(other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("DecidedStrict(%s)", this.unitValue);
  }
}

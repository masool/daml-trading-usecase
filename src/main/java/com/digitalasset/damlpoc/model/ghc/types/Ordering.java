package com.digitalasset.damlpoc.model.ghc.types;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Ordering {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public Ordering() {
  }

  public abstract Value toValue();

  public static Ordering fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.ghc.types.Ordering"));
    if ("LT".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.types.ordering.LT.fromValue(variant$);
    }
    if ("EQ".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.types.ordering.EQ.fromValue(variant$);
    }
    if ("GT".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.types.ordering.GT.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.ghc.types.Ordering, expected one of [LT, EQ, GT]");
  }
}

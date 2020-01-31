package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class DecidedStrictness {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public DecidedStrictness() {
  }

  public abstract Value toValue();

  public static DecidedStrictness fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.ghc.generics.DecidedStrictness"));
    if ("DecidedLazy".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.decidedstrictness.DecidedLazy.fromValue(variant$);
    }
    if ("DecidedStrict".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.decidedstrictness.DecidedStrict.fromValue(variant$);
    }
    if ("DecidedUnpack".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.decidedstrictness.DecidedUnpack.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.ghc.generics.DecidedStrictness, expected one of [DecidedLazy, DecidedStrict, DecidedUnpack]");
  }
}

package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Fixity {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public Fixity() {
  }

  public abstract Value toValue();

  public static Fixity fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.ghc.generics.Fixity"));
    if ("Prefix".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.fixity.Prefix.fromValue(variant$);
    }
    if ("Infix".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.fixity.Infix.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.ghc.generics.Fixity, expected one of [Prefix, Infix]");
  }
}

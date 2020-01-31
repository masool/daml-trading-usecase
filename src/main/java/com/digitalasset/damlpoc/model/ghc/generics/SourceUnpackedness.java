package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class SourceUnpackedness {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public SourceUnpackedness() {
  }

  public abstract Value toValue();

  public static SourceUnpackedness fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.ghc.generics.SourceUnpackedness"));
    if ("NoSourceUnpackedness".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.sourceunpackedness.NoSourceUnpackedness.fromValue(variant$);
    }
    if ("SourceNoUnpack".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.sourceunpackedness.SourceNoUnpack.fromValue(variant$);
    }
    if ("SourceUnpack".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.sourceunpackedness.SourceUnpack.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.ghc.generics.SourceUnpackedness, expected one of [NoSourceUnpackedness, SourceNoUnpack, SourceUnpack]");
  }
}

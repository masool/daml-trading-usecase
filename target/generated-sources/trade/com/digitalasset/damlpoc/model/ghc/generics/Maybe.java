package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;
import java.util.function.Function;

public abstract class Maybe<a> {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public Maybe() {
  }

  public abstract Value toValue(Function<a, Value> toValuea);

  public static <a> Maybe<a> fromValue(Value value$, Function<Value, a> fromValuea) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.ghc.generics.Maybe"));
    if ("Just".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.maybe.Just.fromValue(variant$, fromValuea);
    }
    if ("Nothing".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.ghc.generics.maybe.Nothing.fromValue(variant$, fromValuea);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.ghc.generics.Maybe, expected one of [Just, Nothing]");
  }
}

package com.digitalasset.damlpoc.model.da.random;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Minstd {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public Minstd() {
  }

  public abstract Value toValue();

  public static Minstd fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.da.random.Minstd"));
    if ("Minstd".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.random.minstd.Minstd.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.da.random.Minstd, expected one of [Minstd]");
  }
}

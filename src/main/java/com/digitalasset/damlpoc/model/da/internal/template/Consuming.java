package com.digitalasset.damlpoc.model.da.internal.template;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Consuming {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public Consuming() {
  }

  public abstract Value toValue();

  public static Consuming fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.da.internal.template.Consuming"));
    if ("PreConsuming".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.internal.template.consuming.PreConsuming.fromValue(variant$);
    }
    if ("PostConsuming".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.internal.template.consuming.PostConsuming.fromValue(variant$);
    }
    if ("NonConsuming".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.internal.template.consuming.NonConsuming.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.da.internal.template.Consuming, expected one of [PreConsuming, PostConsuming, NonConsuming]");
  }
}

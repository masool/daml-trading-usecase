package com.digitalasset.damlpoc.model.da.logic;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;
import java.util.function.Function;

public abstract class Formula<t> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public Formula() {
  }

  public abstract Value toValue(Function<t, Value> toValuet);

  public static <t> Formula<t> fromValue(Value value$, Function<Value, t> fromValuet) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.da.logic.Formula"));
    if ("Proposition".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.logic.formula.Proposition.fromValue(variant$, fromValuet);
    }
    if ("Negation".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.logic.formula.Negation.fromValue(variant$, fromValuet);
    }
    if ("Conjunction".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.logic.formula.Conjunction.fromValue(variant$, fromValuet);
    }
    if ("Disjunction".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.logic.formula.Disjunction.fromValue(variant$, fromValuet);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.da.logic.Formula, expected one of [Proposition, Negation, Conjunction, Disjunction]");
  }
}

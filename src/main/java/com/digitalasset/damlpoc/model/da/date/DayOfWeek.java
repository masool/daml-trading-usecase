package com.digitalasset.damlpoc.model.da.date;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class DayOfWeek {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public DayOfWeek() {
  }

  public abstract Value toValue();

  public static DayOfWeek fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.da.date.DayOfWeek"));
    if ("Monday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Monday.fromValue(variant$);
    }
    if ("Tuesday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Tuesday.fromValue(variant$);
    }
    if ("Wednesday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Wednesday.fromValue(variant$);
    }
    if ("Thursday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Thursday.fromValue(variant$);
    }
    if ("Friday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Friday.fromValue(variant$);
    }
    if ("Saturday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Saturday.fromValue(variant$);
    }
    if ("Sunday".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.dayofweek.Sunday.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.da.date.DayOfWeek, expected one of [Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday]");
  }
}

package com.digitalasset.damlpoc.model.da.date;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Month {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public Month() {
  }

  public abstract Value toValue();

  public static Month fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant com.digitalasset.damlpoc.model.da.date.Month"));
    if ("Jan".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Jan.fromValue(variant$);
    }
    if ("Feb".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Feb.fromValue(variant$);
    }
    if ("Mar".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Mar.fromValue(variant$);
    }
    if ("Apr".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Apr.fromValue(variant$);
    }
    if ("May".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.May.fromValue(variant$);
    }
    if ("Jun".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Jun.fromValue(variant$);
    }
    if ("Jul".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Jul.fromValue(variant$);
    }
    if ("Aug".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Aug.fromValue(variant$);
    }
    if ("Sep".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Sep.fromValue(variant$);
    }
    if ("Oct".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Oct.fromValue(variant$);
    }
    if ("Nov".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Nov.fromValue(variant$);
    }
    if ("Dec".equals(variant$.getConstructor())) {
      return com.digitalasset.damlpoc.model.da.date.month.Dec.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant com.digitalasset.damlpoc.model.da.date.Month, expected one of [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec]");
  }
}

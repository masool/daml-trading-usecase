package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetaData0 {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final Unit name;

  public final Unit module_;

  public final Unit package$;

  public final Boolean isNewType;

  public MetaData0(Unit name, Unit module_, Unit package$, Boolean isNewType) {
    this.name = name;
    this.module_ = module_;
    this.package$ = package$;
    this.isNewType = isNewType;
  }

  public static MetaData0 fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    Unit name = fields$.get(0).getValue().asUnit().orElseThrow(() -> new IllegalArgumentException("Expected name to be of type com.daml.ledger.javaapi.data.Unit"));
    Unit module_ = fields$.get(1).getValue().asUnit().orElseThrow(() -> new IllegalArgumentException("Expected module_ to be of type com.daml.ledger.javaapi.data.Unit"));
    Unit package$ = fields$.get(2).getValue().asUnit().orElseThrow(() -> new IllegalArgumentException("Expected package$ to be of type com.daml.ledger.javaapi.data.Unit"));
    Boolean isNewType = fields$.get(3).getValue().asBool().orElseThrow(() -> new IllegalArgumentException("Expected isNewType to be of type com.daml.ledger.javaapi.data.Bool")).getValue();
    return new com.digitalasset.damlpoc.model.ghc.generics.MetaData0(name, module_, package$, isNewType);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("name", Unit.getInstance()));
    fields.add(new Record.Field("module_", Unit.getInstance()));
    fields.add(new Record.Field("package", Unit.getInstance()));
    fields.add(new Record.Field("isNewType", new Bool(this.isNewType)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof MetaData0)) {
      return false;
    }
    MetaData0 other = (MetaData0) object;
    return this.name.equals(other.name) && this.module_.equals(other.module_) && this.package$.equals(other.package$) && this.isNewType.equals(other.isNewType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.module_, this.package$, this.isNewType);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.ghc.generics.MetaData0(%s, %s, %s, %s)", this.name, this.module_, this.package$, this.isNewType);
  }
}

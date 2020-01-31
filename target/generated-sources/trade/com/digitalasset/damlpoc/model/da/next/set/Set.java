package com.digitalasset.damlpoc.model.da.next.set;

import com.daml.ledger.javaapi.data.DamlMap;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Set<a> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final Map<String, Unit> textMap;

  public Set(Map<String, Unit> textMap) {
    this.textMap = textMap;
  }

  public static <a> Set<a> fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Map<String, Unit> textMap = fields$.get(0).getValue().asMap().map(v$0 -> v$0.getMap().entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,Value>,String,com.daml.ledger.javaapi.data.Unit>toMap(java.util.Map.Entry::getKey,v$1 -> v$1.getValue().asUnit().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Unit"))))).orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlMap"));
    return new com.digitalasset.damlpoc.model.da.next.set.Set<a>(textMap);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", new DamlMap(this.textMap.entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,com.daml.ledger.javaapi.data.Unit>,String,Value>toMap(java.util.Map.Entry::getKey, v$0 -> Unit.getInstance())))));
    return new Record(fields);
  }

  public static <a> Set<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    Map<String, Unit> textMap = fields$.get(0).getValue().asMap().map(v$0 -> v$0.getMap().entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,Value>,String,com.daml.ledger.javaapi.data.Unit>toMap(java.util.Map.Entry::getKey,v$1 -> v$1.getValue().asUnit().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Unit"))))).orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlMap"));
    return new com.digitalasset.damlpoc.model.da.next.set.Set<a>(textMap);
  }

  public Record toValue(Function<a, Value> toValuea) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", new DamlMap(this.textMap.entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,com.daml.ledger.javaapi.data.Unit>,String,Value>toMap(java.util.Map.Entry::getKey, v$0 -> Unit.getInstance())))));
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
    if (!(object instanceof Set)) {
      return false;
    }
    Set other = (Set) object;
    return this.textMap.equals(other.textMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.textMap);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.next.set.Set(%s)", this.textMap);
  }
}

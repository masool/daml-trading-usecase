package com.digitalasset.damlpoc.model.da.next.map;

import com.daml.ledger.javaapi.data.DamlMap;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map<k, v> {
  public static final String _packageId = "ce909f848477104ac487c187bd43f770ff71f8fbcbcb96c46f01cca856a6767c";

  public final java.util.Map<String, v> textMap;

  public Map(java.util.Map<String, v> textMap) {
    this.textMap = textMap;
  }

  public static <k, v> Map<k, v> fromValue(Value value$, Function<Value, v> fromValuev) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    java.util.Map<String, v> textMap = fields$.get(0).getValue().asMap().map(v$0 -> v$0.getMap().entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,Value>,String,v>toMap(java.util.Map.Entry::getKey,v$1 -> fromValuev.apply(v$1.getValue())))).orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlMap"));
    return new com.digitalasset.damlpoc.model.da.next.map.Map<k, v>(textMap);
  }

  public Record toValue(Function<v, Value> toValuev) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", new DamlMap(this.textMap.entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,v>,String,Value>toMap(java.util.Map.Entry::getKey, v$0 -> toValuev.apply(v$0.getValue()))))));
    return new Record(fields);
  }

  public static <k, v> Map<k, v> fromValue(Value value$, Function<Value, k> fromValuek,
      Function<Value, v> fromValuev) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    java.util.Map<String, v> textMap = fields$.get(0).getValue().asMap().map(v$0 -> v$0.getMap().entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,Value>,String,v>toMap(java.util.Map.Entry::getKey,v$1 -> fromValuev.apply(v$1.getValue())))).orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlMap"));
    return new com.digitalasset.damlpoc.model.da.next.map.Map<k, v>(textMap);
  }

  public Record toValue(Function<k, Value> toValuek, Function<v, Value> toValuev) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", new DamlMap(this.textMap.entrySet().stream().collect(Collectors.<java.util.Map.Entry<String,v>,String,Value>toMap(java.util.Map.Entry::getKey, v$0 -> toValuev.apply(v$0.getValue()))))));
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
    if (!(object instanceof Map)) {
      return false;
    }
    Map other = (Map) object;
    return this.textMap.equals(other.textMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.textMap);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.next.map.Map(%s)", this.textMap);
  }
}

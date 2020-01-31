package com.digitalasset.damlpoc.model.ghc.generics;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetaSel0 {
  public static final String _packageId = "0df561c71f6575c5571c002343632060c55c73226b6d42b694afd92c24867d18";

  public final Maybe<Unit> mbRecordName;

  public final SourceUnpackedness sourceUnpackedness;

  public final SourceStrictness sourceStrictness;

  public final DecidedStrictness decidedStrictness;

  public MetaSel0(Maybe<Unit> mbRecordName, SourceUnpackedness sourceUnpackedness,
      SourceStrictness sourceStrictness, DecidedStrictness decidedStrictness) {
    this.mbRecordName = mbRecordName;
    this.sourceUnpackedness = sourceUnpackedness;
    this.sourceStrictness = sourceStrictness;
    this.decidedStrictness = decidedStrictness;
  }

  public static MetaSel0 fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    Maybe<Unit> mbRecordName = Maybe.<com.daml.ledger.javaapi.data.Unit>fromValue(fields$.get(0).getValue(), v$0 -> v$0.asUnit().orElseThrow(() -> new IllegalArgumentException("Expected mbRecordName to be of type com.daml.ledger.javaapi.data.Unit")));
    SourceUnpackedness sourceUnpackedness = SourceUnpackedness.fromValue(fields$.get(1).getValue());
    SourceStrictness sourceStrictness = SourceStrictness.fromValue(fields$.get(2).getValue());
    DecidedStrictness decidedStrictness = DecidedStrictness.fromValue(fields$.get(3).getValue());
    return new com.digitalasset.damlpoc.model.ghc.generics.MetaSel0(mbRecordName, sourceUnpackedness, sourceStrictness, decidedStrictness);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("mbRecordName", this.mbRecordName.toValue(v$0 -> Unit.getInstance())));
    fields.add(new Record.Field("sourceUnpackedness", this.sourceUnpackedness.toValue()));
    fields.add(new Record.Field("sourceStrictness", this.sourceStrictness.toValue()));
    fields.add(new Record.Field("decidedStrictness", this.decidedStrictness.toValue()));
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
    if (!(object instanceof MetaSel0)) {
      return false;
    }
    MetaSel0 other = (MetaSel0) object;
    return this.mbRecordName.equals(other.mbRecordName) && this.sourceUnpackedness.equals(other.sourceUnpackedness) && this.sourceStrictness.equals(other.sourceStrictness) && this.decidedStrictness.equals(other.decidedStrictness);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.mbRecordName, this.sourceUnpackedness, this.sourceStrictness, this.decidedStrictness);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.ghc.generics.MetaSel0(%s, %s, %s, %s)", this.mbRecordName, this.sourceUnpackedness, this.sourceStrictness, this.decidedStrictness);
  }
}

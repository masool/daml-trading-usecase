package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class TradeIssueProposal extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04", "DA.Tectoro.C2BTrade", "TradeIssueProposal");

  public final TradeIssueAgreement tradeAgreement;

  public TradeIssueProposal(TradeIssueAgreement tradeAgreement) {
    this.tradeAgreement = tradeAgreement;
  }

  public CreateCommand create() {
    return new CreateCommand(TradeIssueProposal.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Unit arg) {
    return new CreateAndExerciseCommand(TradeIssueProposal.TEMPLATE_ID, this.toValue(), "Archive", arg);
  }

  public CreateAndExerciseCommand createAndExerciseAcceptTradeProposal(AcceptTradeProposal arg) {
    return new CreateAndExerciseCommand(TradeIssueProposal.TEMPLATE_ID, this.toValue(), "AcceptTradeProposal", arg.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseAcceptTradeProposal() {
    return createAndExerciseAcceptTradeProposal(new AcceptTradeProposal());
  }

  public static CreateCommand create(TradeIssueAgreement tradeAgreement) {
    return new TradeIssueProposal(tradeAgreement).create();
  }

  public static TradeIssueProposal fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    TradeIssueAgreement tradeAgreement = TradeIssueAgreement.fromValue(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueProposal(tradeAgreement);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("tradeAgreement", this.tradeAgreement.toValue()));
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
    if (!(object instanceof TradeIssueProposal)) {
      return false;
    }
    TradeIssueProposal other = (TradeIssueProposal) object;
    return this.tradeAgreement.equals(other.tradeAgreement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tradeAgreement);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueProposal(%s)", this.tradeAgreement);
  }

  public static final class ContractId {
    public final String contractId;

    public ContractId(String contractId) {
      this.contractId = contractId;
    }

    public ExerciseCommand exerciseArchive(Unit arg) {
      return new ExerciseCommand(TradeIssueProposal.TEMPLATE_ID, this.contractId, "Archive", arg);
    }

    public ExerciseCommand exerciseAcceptTradeProposal(AcceptTradeProposal arg) {
      return new ExerciseCommand(TradeIssueProposal.TEMPLATE_ID, this.contractId, "AcceptTradeProposal", arg.toValue());
    }

    public ExerciseCommand exerciseAcceptTradeProposal() {
      return exerciseAcceptTradeProposal(new AcceptTradeProposal());
    }

    public Value toValue() {
      return new com.daml.ledger.javaapi.data.ContractId(this.contractId);
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof ContractId)) {
        return false;
      }
      ContractId other = (ContractId) object;
      return this.contractId.equals(other.contractId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.contractId);
    }

    @Override
    public String toString() {
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueProposal.ContractId(%s)", this.contractId);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final TradeIssueProposal data;

    public final Optional<String> agreementText;

    public Contract(ContractId id, TradeIssueProposal data, Optional<String> agreementText) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText) {
      ContractId id = new ContractId(contractId);
      TradeIssueProposal data = TradeIssueProposal.fromValue(record$);
      return new Contract(id, data, agreementText);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      TradeIssueProposal data = TradeIssueProposal.fromValue(record$);
      return new Contract(id, data, Optional.empty());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText());
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof Contract)) {
        return false;
      }
      Contract other = (Contract) object;
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText);
    }

    @Override
    public String toString() {
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeIssueProposal.Contract(%s, %s, %s)", this.id, this.data, this.agreementText);
    }
  }
}

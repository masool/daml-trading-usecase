package com.digitalasset.damlpoc.model.da.tectoro.b2eagree;

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

public final class BrokerTradeIssueProposal extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04", "DA.Tectoro.B2EAgree", "BrokerTradeIssueProposal");

  public final BrokerTradeIssueAgreement brokertradeAgreement;

  public BrokerTradeIssueProposal(BrokerTradeIssueAgreement brokertradeAgreement) {
    this.brokertradeAgreement = brokertradeAgreement;
  }

  public CreateCommand create() {
    return new CreateCommand(BrokerTradeIssueProposal.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Unit arg) {
    return new CreateAndExerciseCommand(BrokerTradeIssueProposal.TEMPLATE_ID, this.toValue(), "Archive", arg);
  }

  public CreateAndExerciseCommand createAndExerciseAcceptExchangeTradeProposal(
      AcceptExchangeTradeProposal arg) {
    return new CreateAndExerciseCommand(BrokerTradeIssueProposal.TEMPLATE_ID, this.toValue(), "AcceptExchangeTradeProposal", arg.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseAcceptExchangeTradeProposal() {
    return createAndExerciseAcceptExchangeTradeProposal(new AcceptExchangeTradeProposal());
  }

  public static CreateCommand create(BrokerTradeIssueAgreement brokertradeAgreement) {
    return new BrokerTradeIssueProposal(brokertradeAgreement).create();
  }

  public static BrokerTradeIssueProposal fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    BrokerTradeIssueAgreement brokertradeAgreement = BrokerTradeIssueAgreement.fromValue(fields$.get(0).getValue());
    return new com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueProposal(brokertradeAgreement);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("brokertradeAgreement", this.brokertradeAgreement.toValue()));
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
    if (!(object instanceof BrokerTradeIssueProposal)) {
      return false;
    }
    BrokerTradeIssueProposal other = (BrokerTradeIssueProposal) object;
    return this.brokertradeAgreement.equals(other.brokertradeAgreement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.brokertradeAgreement);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueProposal(%s)", this.brokertradeAgreement);
  }

  public static final class ContractId {
    public final String contractId;

    public ContractId(String contractId) {
      this.contractId = contractId;
    }

    public ExerciseCommand exerciseArchive(Unit arg) {
      return new ExerciseCommand(BrokerTradeIssueProposal.TEMPLATE_ID, this.contractId, "Archive", arg);
    }

    public ExerciseCommand exerciseAcceptExchangeTradeProposal(AcceptExchangeTradeProposal arg) {
      return new ExerciseCommand(BrokerTradeIssueProposal.TEMPLATE_ID, this.contractId, "AcceptExchangeTradeProposal", arg.toValue());
    }

    public ExerciseCommand exerciseAcceptExchangeTradeProposal() {
      return exerciseAcceptExchangeTradeProposal(new AcceptExchangeTradeProposal());
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueProposal.ContractId(%s)", this.contractId);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final BrokerTradeIssueProposal data;

    public final Optional<String> agreementText;

    public Contract(ContractId id, BrokerTradeIssueProposal data, Optional<String> agreementText) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText) {
      ContractId id = new ContractId(contractId);
      BrokerTradeIssueProposal data = BrokerTradeIssueProposal.fromValue(record$);
      return new Contract(id, data, agreementText);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      BrokerTradeIssueProposal data = BrokerTradeIssueProposal.fromValue(record$);
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.b2eagree.BrokerTradeIssueProposal.Contract(%s, %s, %s)", this.id, this.data, this.agreementText);
    }
  }
}

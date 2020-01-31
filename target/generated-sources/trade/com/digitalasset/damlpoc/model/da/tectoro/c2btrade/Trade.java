package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.digitalasset.damlpoc.model.da.tectoro.facts.OrderTerms;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Trade extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04", "DA.Tectoro.C2BTrade", "Trade");

  public final String broker;

  public final String client;

  public final String regulator;

  public final OrderTerms terms;

  public Trade(String broker, String client, String regulator, OrderTerms terms) {
    this.broker = broker;
    this.client = client;
    this.regulator = regulator;
    this.terms = terms;
  }

  public CreateCommand create() {
    return new CreateCommand(Trade.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Unit arg) {
    return new CreateAndExerciseCommand(Trade.TEMPLATE_ID, this.toValue(), "Archive", arg);
  }

  public CreateAndExerciseCommand createAndExerciseExecute(Execute arg) {
    return new CreateAndExerciseCommand(Trade.TEMPLATE_ID, this.toValue(), "Execute", arg.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseExecute(String executionId) {
    return createAndExerciseExecute(new Execute(executionId));
  }

  public static CreateCommand create(String broker, String client, String regulator,
      OrderTerms terms) {
    return new Trade(broker, client, regulator, terms).create();
  }

  public static Trade fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    String broker = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected broker to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String client = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected client to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String regulator = fields$.get(2).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected regulator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    OrderTerms terms = OrderTerms.fromValue(fields$.get(3).getValue());
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Trade(broker, client, regulator, terms);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("broker", new Party(this.broker)));
    fields.add(new Record.Field("client", new Party(this.client)));
    fields.add(new Record.Field("regulator", new Party(this.regulator)));
    fields.add(new Record.Field("terms", this.terms.toValue()));
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
    if (!(object instanceof Trade)) {
      return false;
    }
    Trade other = (Trade) object;
    return this.broker.equals(other.broker) && this.client.equals(other.client) && this.regulator.equals(other.regulator) && this.terms.equals(other.terms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.broker, this.client, this.regulator, this.terms);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Trade(%s, %s, %s, %s)", this.broker, this.client, this.regulator, this.terms);
  }

  public static final class ContractId {
    public final String contractId;

    public ContractId(String contractId) {
      this.contractId = contractId;
    }

    public ExerciseCommand exerciseArchive(Unit arg) {
      return new ExerciseCommand(Trade.TEMPLATE_ID, this.contractId, "Archive", arg);
    }

    public ExerciseCommand exerciseExecute(Execute arg) {
      return new ExerciseCommand(Trade.TEMPLATE_ID, this.contractId, "Execute", arg.toValue());
    }

    public ExerciseCommand exerciseExecute(String executionId) {
      return exerciseExecute(new Execute(executionId));
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Trade.ContractId(%s)", this.contractId);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final Trade data;

    public final Optional<String> agreementText;

    public Contract(ContractId id, Trade data, Optional<String> agreementText) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText) {
      ContractId id = new ContractId(contractId);
      Trade data = Trade.fromValue(record$);
      return new Contract(id, data, agreementText);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      Trade data = Trade.fromValue(record$);
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.Trade.Contract(%s, %s, %s)", this.id, this.data, this.agreementText);
    }
  }
}

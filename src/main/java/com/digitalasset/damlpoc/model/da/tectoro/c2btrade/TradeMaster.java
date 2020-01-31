package com.digitalasset.damlpoc.model.da.tectoro.c2btrade;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Decimal;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class TradeMaster extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7f1d1cc5342a54361d5be947329e87b6bf0a8f6b90d001080e36656d681e1c04", "DA.Tectoro.C2BTrade", "TradeMaster");

  public final String broker;

  public final BigDecimal commissionRate;

  public final String typeOfTrade;

  public final LocalDate agreement_date;

  public TradeMaster(String broker, BigDecimal commissionRate, String typeOfTrade,
      LocalDate agreement_date) {
    this.broker = broker;
    this.commissionRate = commissionRate;
    this.typeOfTrade = typeOfTrade;
    this.agreement_date = agreement_date;
  }

  public CreateCommand create() {
    return new CreateCommand(TradeMaster.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Unit arg) {
    return new CreateAndExerciseCommand(TradeMaster.TEMPLATE_ID, this.toValue(), "Archive", arg);
  }

  public CreateAndExerciseCommand createAndExerciseInvite(Invite arg) {
    return new CreateAndExerciseCommand(TradeMaster.TEMPLATE_ID, this.toValue(), "Invite", arg.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseInvite(String client) {
    return createAndExerciseInvite(new Invite(client));
  }

  public static CreateCommand create(String broker, BigDecimal commissionRate, String typeOfTrade,
      LocalDate agreement_date) {
    return new TradeMaster(broker, commissionRate, typeOfTrade, agreement_date).create();
  }

  public static TradeMaster fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    String broker = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected broker to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    BigDecimal commissionRate = fields$.get(1).getValue().asDecimal().orElseThrow(() -> new IllegalArgumentException("Expected commissionRate to be of type com.daml.ledger.javaapi.data.Decimal")).getValue();
    String typeOfTrade = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected typeOfTrade to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    LocalDate agreement_date = fields$.get(3).getValue().asDate().orElseThrow(() -> new IllegalArgumentException("Expected agreement_date to be of type com.daml.ledger.javaapi.data.Date")).getValue();
    return new com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeMaster(broker, commissionRate, typeOfTrade, agreement_date);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("broker", new Party(this.broker)));
    fields.add(new Record.Field("commissionRate", new Decimal(this.commissionRate)));
    fields.add(new Record.Field("typeOfTrade", new Text(this.typeOfTrade)));
    fields.add(new Record.Field("agreement_date", new Date((int) this.agreement_date.toEpochDay())));
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
    if (!(object instanceof TradeMaster)) {
      return false;
    }
    TradeMaster other = (TradeMaster) object;
    return this.broker.equals(other.broker) && this.commissionRate.equals(other.commissionRate) && this.typeOfTrade.equals(other.typeOfTrade) && this.agreement_date.equals(other.agreement_date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.broker, this.commissionRate, this.typeOfTrade, this.agreement_date);
  }

  @Override
  public String toString() {
    return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeMaster(%s, %s, %s, %s)", this.broker, this.commissionRate, this.typeOfTrade, this.agreement_date);
  }

  public static final class ContractId {
    public final String contractId;

    public ContractId(String contractId) {
      this.contractId = contractId;
    }

    public ExerciseCommand exerciseArchive(Unit arg) {
      return new ExerciseCommand(TradeMaster.TEMPLATE_ID, this.contractId, "Archive", arg);
    }

    public ExerciseCommand exerciseInvite(Invite arg) {
      return new ExerciseCommand(TradeMaster.TEMPLATE_ID, this.contractId, "Invite", arg.toValue());
    }

    public ExerciseCommand exerciseInvite(String client) {
      return exerciseInvite(new Invite(client));
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeMaster.ContractId(%s)", this.contractId);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final TradeMaster data;

    public final Optional<String> agreementText;

    public Contract(ContractId id, TradeMaster data, Optional<String> agreementText) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText) {
      ContractId id = new ContractId(contractId);
      TradeMaster data = TradeMaster.fromValue(record$);
      return new Contract(id, data, agreementText);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      TradeMaster data = TradeMaster.fromValue(record$);
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
      return String.format("com.digitalasset.damlpoc.model.da.tectoro.c2btrade.TradeMaster.Contract(%s, %s, %s)", this.id, this.data, this.agreementText);
    }
  }
}

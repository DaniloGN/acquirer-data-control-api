package com.example.acquirerdatacontrol.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Contract {

    @EmbeddedId
    private ContractKey id;

    @ManyToOne
    @MapsId("client_id")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("acquirer_id")
    @JoinColumn(name = "acquirer_id")
    private Acquirer acquirer;

    private String establishment;
    private Timestamp create_at;

    public Contract(Client client, Acquirer acquirer, String establishment) {
        this.id = new ContractKey(client.getId(), acquirer.getId());
        this.client = client;
        this.acquirer = acquirer;
        this.establishment = establishment;
    }

    public Contract(){}

    public ContractKey getId() {
        return id;
    }

    public String getClient() {
        return client.getName();
    }

    public String getAcquirer() {
        return acquirer.getName();
    }

    public String getEstablishment() {
        return establishment;
    }

    public LocalDateTime getCreate_at(){
        return create_at.toLocalDateTime();
    }
}

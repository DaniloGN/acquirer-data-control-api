package com.example.acquirerdatacontrol.model;

import javax.persistence.*;

@Entity
public class Contract {

    @EmbeddedId
    ContractKey id;

    @ManyToOne
    @MapsId("client_id")
    @JoinColumn(name = "Client_id")
    Client client;

    @ManyToOne
    @MapsId("acquirer_id")
    @JoinColumn(name = "Acquirer_id")
    Acquirer acquirer;

    String establishment;

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

    public Client getClient() {
        return client;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public String getEstablishment() {
        return establishment;
    }
}

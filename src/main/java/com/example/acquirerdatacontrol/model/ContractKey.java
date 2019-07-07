package com.example.acquirerdatacontrol.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContractKey implements Serializable {

    @Column(name = "client_id")
    Long clientId;

    @Column(name = "acquirer_id")
    Long acquirerId;

    public ContractKey(Long clientId, Long acquirerId) {
        this.clientId = clientId;
        this.acquirerId = acquirerId;
    }

    public ContractKey(){}

    public Long getClientId() {
        return clientId;
    }

    public Long getAcquirerId() {
        return acquirerId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

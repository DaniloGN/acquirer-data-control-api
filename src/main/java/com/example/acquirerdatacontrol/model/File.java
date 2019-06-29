package com.example.acquirerdatacontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char registry_type;
    private String establishment;
    private String processing_date;
    private String initial_period;
    private String final_period;
    private String sequence;
    private String acquirer_name;
    private String status;

    public File(char registry_type, String establishment, String processing_date, String initial_period, String final_period, String sequence, String acquirer_name) {
        this.registry_type = registry_type;
        this.establishment = establishment;
        this.processing_date = processing_date;
        this.initial_period = initial_period;
        this.final_period = final_period;
        this.sequence = sequence;
        this.acquirer_name = acquirer_name;
        this.status = "Esperando";
    }

    public File(char registry_type, String processing_date, String establishment, String acquirer_name, String sequence){
        this.registry_type =registry_type;
        this.establishment =establishment;
        this.processing_date =processing_date;
        this.initial_period = null;
        this.final_period = null;
        this.sequence =sequence;
        this.acquirer_name =acquirer_name;
        this.status = "Esperando";
    }

    public File(){}

    public Long getId() { return id; }

    public char getRegistry_type() {
        return registry_type;
    }

    public void setRegistry_type(char registry_type) {
        this.registry_type = registry_type;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getProcessing_date() {
        return processing_date;
    }

    public void setProcessing_date(String processing_date) {
        this.processing_date = processing_date;
    }

    public String getInitial_period() {
        return initial_period;
    }

    public void setInitial_period(String initial_period) {
        this.initial_period = initial_period;
    }

    public String getFinal_period() {
        return final_period;
    }

    public void setFinal_period(String final_period) {
        this.final_period = final_period;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getAcquirer_name() {
        return acquirer_name;
    }

    public void setAcquirer_name(String acquirer_name) {
        this.acquirer_name = acquirer_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String faggamonCard() {
        return getRegistry_type()+getProcessing_date()+getEstablishment()+getAcquirer_name()+getSequence();
    }

    public String uflaCard() {
        return getRegistry_type()+getEstablishment()+getProcessing_date()+ getInitial_period()+getFinal_period()+getSequence()+getAcquirer_name();
    }
}

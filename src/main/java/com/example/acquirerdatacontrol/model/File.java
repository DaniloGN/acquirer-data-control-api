package com.example.acquirerdatacontrol.model;

import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private char registry_type;
    private String establishment;
    private String processing_date;
    private String inicial_period;
    private String final_period;
    private String sequence;
    private String acquirer_name;

    //uflacard
    public File(char registry_type, String establishment, String processing_date, String inicial_period, String final_period, String sequence, String acquirer_name) {
        this.registry_type = registry_type;
        this.establishment = establishment;
        this.processing_date = processing_date;
        this.inicial_period = inicial_period;
        this.final_period = final_period;
        this.sequence = sequence;
        this.acquirer_name = acquirer_name;
    }
    //faggamonCard
    public File(char registry_type, String processing_date, String establishment, String acquirer_name, String sequence){
        this.registry_type = registry_type;
        this.processing_date = processing_date;
        this.establishment = establishment;
        this.acquirer_name = acquirer_name;
        this.sequence = sequence;
        this.inicial_period = null;
        this.final_period = null;
    }
    public File(){}

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

    public String getInicial_period() {
        return inicial_period;
    }

    public void setInicial_period(String inicial_period) {
        this.inicial_period = inicial_period;
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
}

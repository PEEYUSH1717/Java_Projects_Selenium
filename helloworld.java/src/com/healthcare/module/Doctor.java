package com.healthcare.module;

public abstract class Doctor {
    protected String name;
    protected String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public abstract void diagnose(Patient patient);
}

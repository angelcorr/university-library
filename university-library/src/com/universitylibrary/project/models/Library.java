package com.universitylibrary.project.models;

import java.util.ArrayList;

public class Library {
  private static Library instance;

  private final String name;
  private final String address;
  private final String schedule;
  private double penaltyPercentage;

  private Library(Builder builder) {
    this.name = builder.name;
    this.address = builder.address;
    this.schedule = builder.schedule;
    this.penaltyPercentage = builder.penaltyPercentage;
  }

  public static Library getInstance() {
    if (instance == null) {
      instance = new Library.Builder()
          .name("University Library")
          .address("Campus Central")
          .schedule("8:00 AM - 8:00 PM")
          .penaltyPercentage(20.0)
          .build();
    }
    return instance;
  }

  public String getName() { return name; }
  public String getAddress() { return address; }
  public String getSchedule() { return schedule; }
  public double getPenaltyPercentage() { return penaltyPercentage; }

  public void changePenaltyValue(double newPenaltyValue) {
    this.penaltyPercentage = newPenaltyValue;
  }

  public static class Builder {
    private String name;
    private String address;
    private String schedule;
    private double penaltyPercentage = 20.000;

    public Builder name(String name) { this.name = name; return this; }
    public Builder address(String address) { this.address = address; return this; }
    public Builder schedule(String schedule) { this.schedule = schedule; return this; }
    public Builder penaltyPercentage(double penaltyPercentage) { this.penaltyPercentage = penaltyPercentage; return this; }

    public Library build() {
      if (name == null || address == null || schedule == null) {
        throw new IllegalStateException("Name, address and schedule are mandatory");
      }
      return new Library(this);
    }
  }
}

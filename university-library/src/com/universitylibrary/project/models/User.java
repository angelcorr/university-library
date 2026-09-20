package com.universitylibrary.project.models;

import java.util.ArrayList;

public class User {
    private String id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> bookListLoaned;
    private boolean isPenalted;
    private int activeLoans;

    private User(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.bookListLoaned = builder.bookListLoaned;
        this.isPenalted = builder.isPenalted;
        this.activeLoans = 0;
    }

    public String getFullName() { return fullName; }

    public String getAddress() { return address; }

    public String getPhoneNumber() { return phoneNumber; }

    public ArrayList<Book> getBookListLoaned() { return bookListLoaned; }

    public boolean isPenalted() { return isPenalted; }

    public void addActiveLoans() {
      activeLoans++;
    }

    public void subtractActiveLoans() {
      if (activeLoans > 0) activeLoans--;
    }

    public String getId() {
      return id;
    }

    @Override
    public String toString() {
      return "User called " + fullName + "and lives in " + address + "and has the active loans: " + activeLoans;
    }

    public static class Builder {
      private String id;
      private String fullName;
      private String address;
      private String phoneNumber;
      private ArrayList<Book> bookListLoaned;
      private boolean isPenalted;

      public Builder id(String id) {
        this.id = id;
        return this;
      }

      public Builder fullName(String fullName) {
          this.fullName = fullName;
          return this;
      }

      public Builder address(String address) {
          this.address = address;
          return this;
      }
      public Builder phoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
          return this;
      }
      public Builder bookListLoaned(ArrayList<Book> bookListLoaned) {
          this.bookListLoaned = bookListLoaned;
          return this;
      }
      public Builder isPenalted(boolean isPenalted) {
          this.isPenalted = isPenalted;
          return this;
      }
      public User build() { return new User(this); }

    }
}

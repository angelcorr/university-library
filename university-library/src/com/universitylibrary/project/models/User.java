package com.universitylibrary.project.models;

import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> bookListLoaned;
    private boolean isPenalted;

    private User(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.bookListLoaned = builder.bookListLoaned;
        this.isPenalted = builder.isPenalted;
    }

    public UUID id() { return id; }

    public String getFullName() { return fullName; }

    public String getAddress() { return address; }

    public String getPhoneNumber() { return phoneNumber; }

    public ArrayList<Book> getBookListLoaned() { return bookListLoaned; }

    public boolean isPenalted() { return isPenalted; }

    public static class Builder {
      private UUID id;
      private String fullName;
      private String address;
      private String phoneNumber;
      private ArrayList<Book> bookListLoaned;
      private boolean isPenalted;

      public Builder id(UUID id) {
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

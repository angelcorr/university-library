package com.universitylibrary.project.models;

import java.util.ArrayList;
import java.util.Locale;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> bookListLoaned;
    private boolean isPenalted;

    private User(Builder builder) {
        this.fullName = builder.fullName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.bookListLoaned = builder.bookListLoaned;
        this.isPenalted = builder.isPenalted;
    }
    public String getFullName() { return fullName; }

    public String getAddress() { return address; }

    public String getPhoneNumber() { return phoneNumber; }

    public ArrayList<Book> getBookListLoaned() { return bookListLoaned; }

    public boolean isPenalted() { return isPenalted; }

    public static class Builder {
      private String fullName;
      private String address;
      private String phoneNumber;
      private ArrayList<Book> bookListLoaned;
      private boolean isPenalted;

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

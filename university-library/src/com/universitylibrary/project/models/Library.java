package com.universitylibrary.project.models;

import java.util.ArrayList;

public class Library {
  private String name;
  private String address;
  private String schedule;
  private double penaltyPercentage; // This attribute may change
  private ArrayList<User> userList;
  private ArrayList<Book> bookList;

  private Library(Builder builder) {
   this.name = builder.name;
   this.address = builder.address;
   this.schedule = builder.schedule;
   this.penaltyPercentage = builder.penaltyPercentage;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getSchedule() {
    return schedule;
  }

  public double getPenaltyPercentage() {
    return penaltyPercentage;
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  public ArrayList<Book> getBookList() {
    return bookList;
  }

  public void changePenaltyValue (double newPenaltyValue) {
    this.penaltyPercentage = newPenaltyValue;
  }

  public void addBook (Book book) {
    this.bookList.add(book) ;
  }

  public static class Builder {
    private String name;
    private String address;
    private String schedule;
    private double penaltyPercentage = 20.000;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder schedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    public Builder penaltyPercentage(double penaltyPercentage) {
      this.penaltyPercentage = penaltyPercentage;
      return this;
    }

    public Library build() {
      if (name == null || address == null || schedule == null) {
        throw new IllegalStateException("Name, address, schedule, userList and book list are mandatory");
      }


      return new Library(this);
    }
  }
}

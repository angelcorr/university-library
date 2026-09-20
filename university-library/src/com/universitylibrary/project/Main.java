package com.universitylibrary.project;

import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.models.Loan;
import com.universitylibrary.project.models.User;
import com.universitylibrary.project.services.LibraryManager;
import com.universitylibrary.project.services.LoanService;
import com.universitylibrary.project.services.UserManager;

public class Main {
  public static void main(String args[]) {
    LibraryManager manager = LibraryManager.getInstance();
    UserManager userManager = UserManager.getInstance();
    LoanService loanService = new LoanService(manager);

    Book littleWomanBook = manager.addBook("1234", "Little Women", "Alma Clasicos Ilustrados", 350);
    User userOne = userManager.addUser("55412", "Angeles Emiliana", "Quimbaya", "312123456");
    Loan loanLittleWoman = loanService.loanBook(littleWomanBook.getIsbn(), userOne.getId());
    System.out.println(littleWomanBook.toString());
    System.out.println(userOne.toString());
    System.out.println(loanLittleWoman.toString());
  }
}

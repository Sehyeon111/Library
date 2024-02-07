package library_service;

import library_vo.Book;
import java.util.ArrayList;

import library_vo.Customer;

public class LibServiceImpl implements LibService{

   private ArrayList<Customer> customerList = new ArrayList<>(); 
   private ArrayList<Book> bookList = new ArrayList<>(); 

   @Override
   public boolean insert(Customer customer) {
      customerList.add(customer);   
      return true;
   }

   @Override
   public Customer searchCustomer(String id) {
      int i = searchIndex(id);
      if(i == -1) return null;

      return customerList.get(i);
   }

   @Override
   public boolean update(Customer customer) {
      int i = searchIndex(customer.getId());
      customerList.set(i, customer);
      return true;
   }

   @Override
   public boolean delete(String id) {
      int i = searchIndex(id);
      if(i == -1) return false;
      customerList.remove(i);
      return true;
   }

   @Override
   public int searchIndex(String id) {
      int searchindex = -1;
      for(int i=0; i<customerList.size();++i)
         if(customerList.get(i).getId().equals(id)) 
            searchindex = i;
      return searchindex;
   }

   public ArrayList<Customer> bestReader() {
      ArrayList<Customer> newList = new ArrayList<>();
      double w = 0;
      for(int i=0;i<customerList.size();++i) {
         if(customerList.get(i).getborrowCount() > w) {
            w = customerList.get(i).getborrowCount();
            newList.clear();
            newList.add(customerList.get(i));
         }
         else if(customerList.get(i).getborrowCount() == w) 
            newList.add(customerList.get(i));
      }
      return newList;
   }
   @Override
   public int searchBookIndex(String bookid) {
      int searchindex = -1;
      for(int i=0; i<bookList.size();++i)
         if(bookList.get(i).getBookID().equals(bookid)) 
            searchindex = i;
      return searchindex;
   }

   @Override
   public boolean insertBook(Book book) {
      bookList.add(book);
      return true;
   }

   @Override
   public Book searchBook(String booktitle) {
      int searchindex = -1;
      for(int i=0; i<bookList.size();++i)
         if(bookList.get(i).getBookTitle().equals(booktitle)) 
            searchindex = i;
      if(searchindex == -1) return null;
      return bookList.get(searchindex);
   }

   @Override
   public void borrowBook(Customer c, Book book) {
      book.setBookAvalible('N');
      book.setBorrowCount(book.getBorrowCount()+1);
      c.setBorringBook(book.getBookTitle());
      c.setborrowCount(c.getborrowCount()+1);
      return;
   }

   @Override
   public void returnBook(Customer c, Book book) {
      book.setBookAvalible('Y');
      c.setBorringBook(null);
      return;
   }
   
   @Override
   public ArrayList<Book> bestSeller() {
      ArrayList<Book> newList = new ArrayList<>();
      double w = 0;
      for(int i=0;i<bookList.size();++i) {
         if(bookList.get(i).getBorrowCount() > w) {
            w = bookList.get(i).getBorrowCount();
            newList.clear();
            newList.add(bookList.get(i));
         }
         else if(bookList.get(i).getBorrowCount() == w) 
            newList.add(bookList.get(i));
      }
      return newList;
   }
   
}
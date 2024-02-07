package library_service;

import java.util.ArrayList;

import library_vo.Book;

import library_vo.Customer;

public interface LibService {
   // 회원 가입
   public boolean insert(Customer customer);
   // 회원 정보 조회
   public Customer searchCustomer(String id);
   // 회원 정보 수정
   public boolean update(Customer customer);
   // 회원 삭제
   public boolean delete(String id);
   
   // 회원 id 조회
   public int searchIndex(String id);
   // 책 id 조회
   public int searchBookIndex(String bookid);
   
   // 도서 추가
   public boolean insertBook(Book book);
   // 책 정보 조회
   public Book searchBook(String bookTitle);
   // 책 대출
   public void borrowBook(Customer c, Book book);
   // 책 반답
   public void returnBook(Customer c, Book bookid);
   public ArrayList<Customer> bestReader();
   public ArrayList<Book> bestSeller();
   
   
}
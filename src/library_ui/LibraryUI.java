package library_ui;
import java.util.ArrayList;
import java.util.Scanner;

import library_service.LibService;
import library_service.LibServiceImpl;
/**
 * 사용자 인터페이스
 */
import library_vo.Book;
import library_vo.Customer;

public class LibraryUI {
   Scanner scanner = new Scanner(System.in);
   LibService service = new LibServiceImpl();
   Customer c = new Customer();
   Book b = new Book();
   public LibraryUI() {
      int menu = 0;
      
      while(true) {
         mainmenu();
         menu = scanner.nextInt();
         
         switch(menu) {
         case 1: add();
               break;
         case 2: update();
               break;
         case 3: delete();
               break;
         case 4: search();
               break;
         case 5: bestseller();
               break;
         case 6: bestreader();
               break;
         case 7: bookcare();
               break;
         case 8: close();
               return;
         
         }
         
      }
   }
   
   private void add() {
      String id, name;
      System.out.println("회원 ID를 입력하세요 >");
      id = scanner.next();
      int i = service.searchIndex(id);
      if(i!=-1) {
         System.out.println("이미 존재하는 ID 입니다.");
         return;
      }
      System.out.println("이름을 입력하세요");
      name = scanner.next();
      Customer customer = new Customer(name, id);
      service.insert(customer);
      System.out.println("회원가입이 완료되었습니다");
      System.out.println();
   }

   private void update() {
      String id, name;
      System.out.println("수정하실 회원 ID를 입력하세요 >");
      id = scanner.next();
      Customer c = service.searchCustomer(id);
      if(c==null) {System.out.println("해당 ID는 존재하지 않습니다.");
                return;
      }
      System.out.println("수정하실 이름을 입력하세요");
      name = scanner.next();
      c.setName(name);
      service.update(c);
      System.out.println("수정이 완료되었습니다.");
   }
   
   private void delete() {
      String id;
      System.out.println("삭제하실 회원 ID를 입력하세요 >");
      id = scanner.next();
      int i = service.searchIndex(id);
      if(i==-1) {System.out.println("해당 ID는 존재하지 않습니다.");
                return;
      }
      service.delete(id);
      System.out.println("삭제되었습니다");
      System.out.println();
   }
   
   private void search() {
      String id;
      System.out.println("조회하실 회원 ID를 입력하세요 >");
      id = scanner.next();
      Customer c = service.searchCustomer(id);
      if(c==null) {System.out.println("해당 ID는 존재하지 않습니다.");
                return;
      }
      System.out.println(c);
      System.out.println();
   }
   
   private void bestreader() {
      ArrayList<Customer> br = service.bestReader();
      System.out.println(br);
      System.out.println();
   }

   private void bestseller() {
      ArrayList<Book> b = service.bestSeller();
      System.out.println(b);
      System.out.println();
      
   }


   private void bookcare() {
      int num;
      String id, title, author, genre, cus_id; 
      System.out.println("*** 도서관리 ***");
      System.out.println("1) 신규 도서 추가");
      System.out.println("2) 도서 정보 조회");
      System.out.println("3) 도서 대출");
      System.out.println("4) 도서 반납");
      System.out.println("==================");
      System.out.print("선택 > ");
      num = scanner.nextInt();
      if(num==1) {
         System.out.print("책 ID를 입력하세요 > ");
         id = scanner.next();
         int i = service.searchBookIndex(id);
         if(i!=-1) {
            System.out.println("해당 ID는 이미 존재합니다");
            System.out.println();
            return;
         }
         System.out.print("책 제목을 입력하세요 >"); title = scanner.next();
         System.out.print("책 저자를 입력하세요 >"); author = scanner.next();
         System.out.print("책 장르를 입력하세요 >"); genre = scanner.next();
         Book b = new Book(id, title, author, genre);
         if(service.insertBook(b))
            System.out.println("추가되었습니다.");
            System.out.println();
      }
      else if(num==2) {
         System.out.print("조회하실 책 제목을 입력하세요 > ");
         title = scanner.next();
         Book b = service.searchBook(title);
         if(b==null) {
            System.out.println("해당 책은 존재하지 않습니다.");
            System.out.println();
            return;
         }
         System.out.println(b);
         System.out.println();
      }
      else if(num==3) {
         System.out.println("대출하실 회원 ID를 입력하세요 > ");
         cus_id = scanner.next();
         Customer c = service.searchCustomer(cus_id);
         if(c==null) {System.out.println("해당 ID는 존재하지 않습니다.");
                   return;
         }
         System.out.print("대출하실 책 제목을 입력하세요 > ");
         title = scanner.next();
         Book b = service.searchBook(title);
         if(b==null) {
            System.out.println("해당 책은 존재하지 않습니다.");
            System.out.println();
            return;
         }
         if(b.getBookAvalible()=='N') {
            System.out.println("해당 책은 대출중입니다.");
            return;
         }
         System.out.println(b);
         service.borrowBook(c, b);
         System.out.println("대출이 완료되었습니다.");
      }
      else if(num==4) {
         System.out.println("반납하실 회원 ID를 입력하세요 > ");
         cus_id = scanner.next();
         Customer c = service.searchCustomer(cus_id);
         if(c==null) {System.out.println("해당 ID는 존재하지 않습니다.");
                   return;
         }
         System.out.print("반납하실 책 제목을 입력하세요 > ");
         title = scanner.next();
         Book b = service.searchBook(title);
         if(b==null) {
            System.out.println("해당 책은 존재하지 않습니다.");
            System.out.println();
            return;
         }
         if(b.getBookAvalible()=='Y') {
            System.out.println("해당 책은 대출중인 책이 아닙니다.");
            return;
         }
         if(b.getBookTitle().equals(c.getBorringBook())) {
            System.out.println(b);
            service.returnBook(c, b);
            System.out.println("반납이 완료되었습니다.");
            System.out.println();
         }
         else {
            System.out.println("회원님이 대출중인 책이 아닙니다.");
            System.out.println();
            return;
         }
      }
   }

   private void close() {
      System.out.println("프로그램을 종료합니다!");
      System.exit(0);
   }

   public void mainmenu() {
      System.out.println("*** 디마도서관 ***");
      System.out.println("1) 신규 회원 등록");
      System.out.println("2) 회원 정보 수정");
      System.out.println("3) 회원 정보 삭제");
      System.out.println("4) 회원 정보 조회");
      System.out.println("5) 베스트셀러 조회");
      System.out.println("6) 우수회원 조회");
      System.out.println("7) 도서관리");
      System.out.println("8) 프로그램 종료");
      System.out.println("=====================");
      System.out.print("선택 > ");
   }
   
}
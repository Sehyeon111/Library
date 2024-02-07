package library_vo;

public class Customer {
   // 회원 이름
   private String name;
   
   // 회원 아이디
   private String id;
   
   // 대출중인 책
   private String borringBook;
   
   // 대출 횟수
   private int borrowCount = 0;

   public Customer() {
      super();
   }

   public Customer(String name, String id) {
      super();
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getBorringBook() {
      return borringBook;
   }

   public void setBorringBook(String borringBook) {
      this.borringBook = borringBook;
   }

   public int getborrowCount() {
      return borrowCount;
   }

   public void setborrowCount(int borrowCount) {
      this.borrowCount = borrowCount;
   }

   @Override
   public String toString() {
      return "Customer [name=" + name + ", id=" + id + ", borringBook=" + borringBook + ", borrowCount=" + borrowCount
            + "]";
   }
   
   
   
}
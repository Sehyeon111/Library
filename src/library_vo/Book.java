package library_vo;

public class Book {
   // 책 아이디
   private String bookID;
   // 책 제목
   private String bookTitle;
   // 책 저자
   private String Author;
   // 대출가능 여부
   private char bookAvalible;
   // 대출 횟수
   private int borrowCount;
   // 책 장르
   private String genre;
   
   public Book() {
      super();
   }
   public Book(String bookID, String bookTitle, String author, String genre) {
      super();
      this.bookID = bookID;
      this.bookTitle = bookTitle;
      Author = author;
      this.bookAvalible = 'Y';
      this.borrowCount = 0;
      this.genre = genre;
   }
   public String getBookID() {
      return bookID;
   }
   public void setBookID(String bookID) {
      this.bookID = bookID;
   }
   public String getBookTitle() {
      return bookTitle;
   }
   public void setBookTitle(String bookTitle) {
      this.bookTitle = bookTitle;
   }
   public String getAuthor() {
      return Author;
   }
   public void setAuthor(String author) {
      Author = author;
   }
   public char getBookAvalible() {
      return bookAvalible;
   }
   public void setBookAvalible(char bookAvalible) {
      this.bookAvalible = bookAvalible;
   }
   public int getBorrowCount() {
      return borrowCount;
   }
   public void setBorrowCount(int borrowCount) {
      this.borrowCount = borrowCount;
   }
   public String getGenre() {
      return genre;
   }
   public void setGenre(String genre) {
      this.genre = genre;
   }
   @Override
   public String toString() {
      return "Book [bookID=" + bookID + ", bookTitle=" + bookTitle + ", Author=" + Author + ", bookAvalible="
            + bookAvalible + ", borrowCount=" + borrowCount + ", genre=" + genre + "]";
   }
   
   
   
}
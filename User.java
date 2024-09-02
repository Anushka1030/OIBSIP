import java.util.HashMap;
import java.util.Map;

class User {
    private String name;
    private Map<String,Book1>borrowedBooks;
    public User(String name){
        this.name=name;
        this.borrowedBooks=new HashMap<>();
    }    
    public String getName()
    {
        return name;
    }
    public void borrowBook(Book1 book)
    {
        borrowedBooks.put(book.getTitle(),book);
    }
    public Book1 returnBook(String title)
    {
        return borrowedBooks.remove(title);
    }
}

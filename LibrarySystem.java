import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private List<Book1> books;
    private List<User> users;

    public LibrarySystem()
    {
        books=new ArrayList<>();
        users=new ArrayList<>();

    }
    public void addBook(Book1 book)
    {
        books.add(book);
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public Book1 findBook1ByTitle(String title)
    {
        for(Book1 book : books)
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                return book;
            }
        }
        return null;
    }
    public User findUserByName(String name)
    {
        for(User user : users)
        {
            if(user.getName().equalsIgnoreCase(name))
            {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(String userName,String bookTitle)
    {
        Book1 book=findBook1ByTitle(bookTitle);
        User user=findUserByName(userName);
        if(book == null)
        {
            System.out.println("----Book not found.----\n ");
        }else if(book.isBorrowed())
        {
            System.out.println("----Book is already borrowed.----\n ");
        }else{
            book.setBorrowed(true);
            user.borrowBook(book);
            System.out.println("----Book borrowed successfully----\n");

        }
        
    }
    public void returnBook(String userName,String bookTitle)
    {
        User user=findUserByName(userName);
        if(user == null)
        {
            System.out.println("----User not found.----\n ");
            return;
        }
        Book1 book=user.returnBook(bookTitle);
        if(book == null)
        {
            System.out.println("----Book was not borrowed by the user.----\n ");
        }
        else{
            book.setBorrowed(false);
            System.out.println("----Book returned successfully----\n");
        }
    }
    public void showAvailableBooks()
    {
        for(Book1 book : books)
        {
            if(!book.isBorrowed())
            {
                System.out.println(book);
            }
        }
    }
    public static void main(String args[])
    {
        LibrarySystem library=new LibrarySystem();
        library.addBook(new Book1("The great gatsby","F.Scott Fitzgerld"));
        library.addBook(new Book1("To kill a Mockingbird","Harper Lee"));
        library.addBook(new Book1("To kill a Mockingbird","Harper Lee"));
        library.addUser(new User("Alice"));
        library.addUser(new User("Bob"));

        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("1.BORROW BOOK\n");
            System.out.println("2.RETURN BOOK\n");
            System.out.println("3.SHOW AVAILABLE BOOKS\n");
            System.out.println("4.EXIT\n");
            System.out.println("Choose an option: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                System.out.println("Enter your name: ");
                String borrowName=sc.nextLine();

                System.out.println("Enter book title: ");
                String borrowTitle=sc.nextLine();

                library.borrowBook(borrowName,borrowTitle);
                break;

                case 2:
                System.out.println("Enter your name: ");
                String returnName=sc.nextLine();

                System.out.println("Enter book title: ");
                String returnTitle=sc.nextLine();

                library.returnBook(returnName,returnTitle);
                break;

                case 3:
                library.showAvailableBooks();
                break;

                case 4:
                System.out.println("Exiting...");
                sc.close();
                return;
                
                default:
                System.out.println("Invalid option.Try again. ");

            }


        }

    }


    
}

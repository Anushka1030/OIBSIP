
public class Book1 {
    private String title;
    private String author;
    private boolean borrowed;
    
    public Book1(String title,String author)
    {
        this.title=title;
        this.author=author;
        this.borrowed=false;
    }
    public String getTitle()
    {
        return title;
    }
    public boolean isBorrowed()
    {
        return borrowed;
    }
    public void setBorrowed(boolean borrowed)
    {
        this.borrowed=borrowed;
    }
    public String toString()
    {
        return "Title:" +title + ",Author:"+author +(borrowed? "(Borrowed)":"");
    }
}

/**
 * Created by Andrey on 13.10.2016.
 */

class Author {
    String name;
    String email;
    char gender;

    public String getInfo() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    Book(String _name, Author[] _authors, double _price) {
        name = _name;
        authors = _authors;
        price = _price;
    }

    Book(String _name, Author[] _authors, double _price, int _qty) {
        name = _name;
        authors = _authors;
        price = _price;
        qty = _qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        String s = null;
        for (int i = 0; i < authors.length; i++) {
            if (i == 0) s += authors[i].getInfo();
            else s += (" " + authors[i].getInfo());
        }

        return ("Book[name=" + name + ",authors={" + s + "},price=" + price + ",qty=" + qty +"]");
    }

    public String getAuthorNames() {
        String s = null;
        for (int i = 0; i < authors.length; i++) {
            if(i == 0) s += authors[i].name;
            else s+= ("," + authors[i].name);
        }
        return s;
    }
}

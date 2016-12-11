package first.a;

/**
 * Created by Andrey on 11.12.2016.
 */

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String _name, Author[] _authors, double _price) {
        name = _name;
        authors = _authors;
        price = _price;
    }

    public Book(String _name, Author[] _authors, double _price, int _qty) {
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

        return ("first.a.Book[name=" + name + ",authors={" + s + "},price=" + price + ",qty=" + qty +"]");
    }

    public String getAuthorNames() {
        String s = null;
        for (int i = 0; i < authors.length; i++) {
            if(i == 0) s += authors[i].name;
            else s+= ("," + authors[i].name);
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book)o;
        return book.name.equals(this.name) &&
                book.authors.equals(this.authors) &&
                book.price == this.price &&
                book.qty == this.qty;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.authors.hashCode();
        result = 31 * result + (int)price;
        result = 31 * result + qty;
        return result;
    }
}


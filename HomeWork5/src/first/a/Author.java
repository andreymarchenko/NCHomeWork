package first.a;

/**
 * Created by Andrey on 11.12.2016.
 */
public class Author {
    String name;
    String email;
    char gender;

    public Author() {

    }

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getInfo() {
        return "first.a.Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return author.name.equals(this.name) &&
                author.email.equals(this.email) &&
                author.gender == this.gender;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.email.hashCode();
        result = 31 * result + (int) gender;
        return result;
    }
}

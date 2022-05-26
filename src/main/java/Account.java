import java.util.regex.*;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return  Pattern.compile("^\\S+ \\S+$")
                .matcher(name)
                .matches()
                && name.length()>=3 && name.length()<=19;
    }

}
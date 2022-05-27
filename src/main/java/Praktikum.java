public class Praktikum {

    public static void main(String[] args) {
        for (String name : args) {
            Account account = new Account(name);
            account.checkNameToEmboss();
        }
    }
}
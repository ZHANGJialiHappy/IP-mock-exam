public class Person {
    private String name, idNumber;

    public Person(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String toString() {
        String strWithHiddenEnding = idNumber.substring(0, idNumber.length() - 4) + "XXXX";
        // Caution! '' for char, "" for String.
        // StringBuilder strWithHiddenEnding = new StringBuilder(idNumber);
        // strWithHiddenEnding.setCharAt(strWithHiddenEnding.length() - 4, 'X');
        // strWithHiddenEnding.setCharAt(strWithHiddenEnding.length() - 3, 'X');
        // strWithHiddenEnding.setCharAt(strWithHiddenEnding.length() - 2, 'X');
        // strWithHiddenEnding.setCharAt(strWithHiddenEnding.length() - 1, 'X');

        return String.format("Name: %s, Id number: %s", name, strWithHiddenEnding);
    }
}
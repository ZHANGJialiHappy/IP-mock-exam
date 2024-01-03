public class Student extends Person {
    private String studyProgram;

    public Student(String idNumber, String name, String studyProgram) {
        super(name, idNumber);
        this.studyProgram = studyProgram;
    }

    public String toString() {
        return String.format(super.toString() + ", Study program: %s", studyProgram);
    }
}

package enums;

public enum PersonType {
    TEACHER(1),
    STUDENT(2),
    JUNIOR(4),
    SENIOR(3);

    private int priority;
    PersonType(int priority){
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

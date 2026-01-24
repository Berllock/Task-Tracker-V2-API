public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("inprogress"),
    DONE("done");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TaskStatus fromString(String text) {
        if (text == null) return null;

        for (TaskStatus status : TaskStatus.values()) {
            if (status.value.equalsIgnoreCase(text.trim())) {
                return status;
            }
        }

        return TODO;
    }

    @Override
    public String toString() {
        return value;
    }


}

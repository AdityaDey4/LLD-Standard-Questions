package OnlineMeeting.Enum;

public enum Interval {
    TEN_ELEVEN("10 am to 11 am"),
    ELEVEN_TWELVE("11 am to 12 pm"),
    TWELVE_ONE("12 pm to 1 pm"),
    ONE_TWO("1 pm to 2 pm"),
    TWO_THREE("2 pm to 3 pm"),
    THREE_FOUR("3 pm to 5 pm"),
    FOUR_FIVE("4 pm to 5 pm");

    String time;
    Interval(String ti) {
        this.time = ti;
    }

    public String getTime() {
        return this.time;
    }
}

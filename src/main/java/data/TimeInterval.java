package data;

public enum TimeInterval {
   THREE_SECONDS(3000),
   FIVE_SECONDS(5000),
   TEN_SECONDS(10000),
   FIFTEEN_SECONDS(15000),
   TWENTY_SECONDS(20000),
   TWENTYFIVE_SECONDS(25000),
   THIRTY_SECONDS(30000),
   THIRTYFIVE_SECONDS(35000),
   FORTY_SECONDS(40000);

    public final long interval;

    private TimeInterval(long interval) {
        this.interval = interval;
    }
}

package data;

public enum Iterations {
   ITE_3(3),
   ITE_10(10),
   ITE_20(20),
   ITE_50(50),
   ITE_100(100),
   ITE_150(150),
   ITE_200(200),
   ITE_400(400),
   ITE_700(700);

    public final int iterations;

    private Iterations(int iterations) {

        this.iterations = iterations;
    }
}

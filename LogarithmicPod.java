public class LogarithmicPod extends Pod {
    public LogarithmicPod(String name, double aValue, double constant) {
        super(name, t -> aValue * Math.log(t + constant));
    }
}

public class LogarithmicPod extends Pod {
    public LogarithmicPod(String name, double aValue, double bValue) {
        super(name, t -> aValue * Math.log(bValue * (t + 1)));
    }
}

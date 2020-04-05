public class SinePod extends Pod {
    public SinePod(String name, double amplitude, double freq, double offset) {
        super(name, t -> amplitude * Math.sin(freq * t) + offset);
    }
}

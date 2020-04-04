import java.util.function.Function;

public class Pod {
    private String name;
    private Function<Double, Double> velocityFunction;

    public Pod(String name, Function<Double, Double> velocityFunction) {
        this.name = name;
        this.velocityFunction = velocityFunction;
    }

    public String getName() {
        return name;
    }

    public double v(double t) {
        return velocityFunction.apply(t);
    }

    public double distanceTraveled(double startTime, double endTime, int slices) {
        // Complete this method. It estimates the distance traveled between the
        // given start and end times by slicing up the time periods into a certain
        // number of slices, as will be described in class. If this method is not
        // passed at least one slice, throw an IllegalArgumentException with the
        // message "At least one slice required".
        if (slices < 1) {
          throw new IllegalArgumentException("At least one slice required");
        }

        double interLength = (endTime - startTime) / slices;
        double totalDistance = 0;
        for (int i = 0; i < slices; i++) {
          double t = startTime + (i * interLength); // changes the starting time
          totalDistance += v(t) * interLength; // adds the slice distance to total distance
        }
        return totalDistance;
        // return 0.0;
    }
}

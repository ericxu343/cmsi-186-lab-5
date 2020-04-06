import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        // IMPLEMENT THIS METHOD
        // first I will create pods (looks like 3)
        // Then I will calculate the distance of each pod
        // Determine a winner
        double precision;
        boolean noWinner = true;
        double distanceTraveled;
        double currentTime = timeSlice;
        int slices = (int) (timeLimit/timeSlice);
        if (timeLimit > slices * timeSlice) {
          slices += 1;
        }
        if (distance <= 0) { // is there a variable for precision
          throw new IllegalArgumentException("Distance and precision must be greater than 0");
        }

        var winners = new HashSet<Pod>();
        while (noWinner && currentTime <= timeLimit) {
          for (Pod racer : racers) {
            double d = racer.distanceTraveled(0, currentTime, slices);
            if (d >= distance) {
              noWinner = false;
              winners.add(racer);
            }
          }
          currentTime += timeSlice;
        }
        return winners;
    }
}

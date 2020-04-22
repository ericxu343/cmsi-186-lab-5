import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {

        boolean noWinner = true;
        double distanceTraveled;
        double startTime = 0;
        double endTime = timeSlice;
        double[] racerDistance = new double[racers.size()];


        if (distance <= 0) {
            throw new IllegalArgumentException("Distance and precision must be greater than 0");
        }

        var winners = new HashSet<Pod>();
        while (noWinner && startTime < timeLimit) {
            if (endTime > timeLimit) {
                endTime = timeLimit;
            }
            int j = 0;
            for (Pod racer : racers) {
                double d = racer.distanceTraveled(startTime, endTime, 1);
                racerDistance[j]+= d;
                if (racerDistance[j] >= distance) {
                    noWinner = false;
                    winners.add(racer);
                }
                j += 1;
            }
            startTime += timeSlice;
            endTime += timeSlice;
          }
          return winners;
    }
}

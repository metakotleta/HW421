import java.util.ArrayDeque;
import java.util.Deque;



public class Elevator {

    private final double TIME_TO_MOVE = 2.5;
    private final int TIME_TO_STOP = 10;

    private Deque<Integer> floorQueue = new ArrayDeque<>();
    private StringBuilder elevatorPath = new StringBuilder();
    double timeToReturn;
    private double totalTime = 0;
    private int prevFloor = 1;

    private double countTime (int prevFloor, int floor) {
        totalTime += Math.abs(floor - prevFloor) * TIME_TO_MOVE + TIME_TO_STOP;
        return totalTime;
    }

    public double goTo (int floor) {
        if (floorQueue.isEmpty() || floor != floorQueue.peekLast()) {
            floorQueue.offer(floor);
            timeToReturn = countTime(prevFloor, floorQueue.peekLast());
            prevFloor = floorQueue.peekLast();
            return timeToReturn;
        } else {
            System.out.println("Мы на этом этаже");
            return timeToReturn;
        }
    }

    public StringBuilder elevatorPath() {
        while(!floorQueue.isEmpty()) {
            int floor = floorQueue.poll();
            if (floorQueue.peek() != null) {
                elevatorPath.append("Этаж " + floor + " --> ");
            } else {
                elevatorPath.append("Этаж " + floor);
            }
        }
        return elevatorPath;
    }
}

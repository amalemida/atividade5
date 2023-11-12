import java.util.Arrays;

public class LastBusTime {
    public static void main(String[] args) throws Exception {

        // int[] buses = { 10, 20 };
        // int[] passengers = { 2, 17, 18, 19 };

        
        int[] buses = { 30, 20, 10 };
        int[] passengers = {19, 13, 26, 4, 25, 11, 21 };
        int capacity = 2;

        System.out.println(lastBusTime(buses, passengers, capacity));

    }

    public static int lastBusTime(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int lastPossibleTime = -1;
        int passengersTaken = 0;
        int lastPassegenrsTaken = 0;

        for (int i = 0; i < buses.length; i++) {

            for (int j = 0; j < passengers.length; j++) {
                if (passengers[j] >= lastPassegenrsTaken && passengers[j] < buses[i]) {
                    passengersTaken++;
                    if (passengers[j] > lastPassegenrsTaken) {
                        lastPassegenrsTaken = passengers[j];
                    }
                }
                if (buses[i] == buses[buses.length - 1] && passengersTaken == capacity) {
                    lastPossibleTime = lastPassegenrsTaken - 1;
                    break;

                }
                if (passengers[j] >= buses[i] || passengersTaken == capacity) {
                    passengersTaken = 0;

                }

            }

        }

        return lastPossibleTime;
    }

}

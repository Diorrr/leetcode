package problems.medium.design;


import java.util.PriorityQueue;

/**
 * Problem: <a href="https://leetcode.com/problems/seat-reservation-manager">
 * seat-reservation-manager</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1845 {
    class SeatManager {
        PriorityQueue<Integer> queue;
        int last;

        public SeatManager(int n) {
            queue = new PriorityQueue<>(n);
            last = 0;
        }

        public int reserve() {
            return queue.isEmpty() ? ++last : queue.poll();
        }

        public void unreserve(int seatNumber) {
            if (seatNumber == last) {
                last--;
            } else {
                queue.add(seatNumber);
            }
        }
    }

    class SeatManager2 {
        PriorityQueue<Integer> queue;

        public SeatManager2(int n) {
            queue = new PriorityQueue<>(n);
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }

    class SeatManager1 {
        boolean[] reservation;
        int startReserv = 0;

        public SeatManager1(int n) {
            reservation = new boolean[n];
        }

        public int reserve() {
            for (int i = startReserv; i < reservation.length; i++) {
                if (!reservation[i]) {
                    reservation[i] = true;
                    startReserv = i + 1;
                    return i + 1;
                }
            }
            return 0;
        }

        public void unreserve(int seatNumber) {
            startReserv = Math.min(seatNumber - 1, startReserv);
            reservation[seatNumber - 1] = false;
        }
    }
}

package array;

/**
 * https://leetcode.com/problems/watering-plants-ii/description/
 * <p>
 * Alice and Bob want to water n plants in their garden. The plants are arranged in a row and are labeled from 0 to n - 1 from left to right where the ith plant is located at x = i.
 * <p>
 * Each plant needs a specific amount of water. Alice and Bob have a watering can each, initially full. They water the plants in the following way:
 * <p>
 * Alice waters the plants in order from left to right, starting from the 0th plant. Bob waters the plants in order from right to left, starting from the (n - 1)th plant. They begin watering the plants simultaneously.
 * It takes the same amount of time to water each plant regardless of how much water it needs.
 * Alice/Bob must water the plant if they have enough in their can to fully water it. Otherwise, they first refill their can (instantaneously) then water the plant.
 * In case both Alice and Bob reach the same plant, the one with more water currently in his/her watering can should water this plant. If they have the same amount of water, then Alice should water this plant.
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs, and two integers capacityA and capacityB representing the capacities of Alice's and Bob's watering cans respectively, return the number of times they have to refill to water all the plants.
 */
public class WateringPlantsII {

    public static void main(String[] args) {
//        System.out.println(new WateringPlantsII().minimumRefill(new int[]{2, 2, 3, 3}, 5, 5)); //1
//        System.out.println(new WateringPlantsII().minimumRefill(new int[]{2, 2, 3, 3}, 3, 4)); //2
//        System.out.println(new WateringPlantsII().minimumRefill(new int[]{2, 1, 1}, 2, 2)); //0
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int cA = capacityA, cB = capacityB;

        for (int l = 0, r = plants.length - 1; l <= r; l++, r--) {
            if (l == r) {
                if (plants[l] > cA && plants[r] > cB) {
                    res++;
                }
                break;
            }

            if (plants[l] <= cA) {
                cA = cA - plants[l];
            } else {
                cA = capacityA - plants[l];
                res++;
            }

            if (plants[r] <= cB) {
                cB = cB - plants[r];
            } else {
                cB = capacityB - plants[r];
                res++;
            }
        }
        return res;
    }
}

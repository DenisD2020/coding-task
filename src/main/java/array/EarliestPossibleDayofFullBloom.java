package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EarliestPossibleDayofFullBloom {

    public static void main(String[] args) {
        System.out.println(new EarliestPossibleDayofFullBloom().earliestFullBloom(new int[]{1, 4, 3}, new int[]{2, 3, 1})); // 9
        System.out.println(new EarliestPossibleDayofFullBloom().earliestFullBloom(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 1})); // 9
        System.out.println(new EarliestPossibleDayofFullBloom().earliestFullBloom(new int[]{1}, new int[]{1})); // 2
    }


    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int res = 0;
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            plants.add(new Plant(plantTime[i], growTime[i]));
        }

        plants.sort(Comparator.comparingInt(p -> -p.growTime));

        int currentTime = 0;
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            currentTime += plant.plantTime;
            res = Math.max(res, currentTime + plant.growTime);
        }

        return res;
    }

    static class Plant {
        int plantTime = 0;
        int growTime = 0;

        public Plant(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}

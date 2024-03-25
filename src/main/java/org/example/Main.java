package org.example;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int rounds = 1000;
        int winsSwitch = 0;
        int winsStay = 0;
        HashMap<Integer, Integer> winSwitch = new HashMap<>();
        HashMap<Integer, Integer> winStay = new HashMap<>();

        Random rand = new Random();

        for (int i = 0; i < rounds; i++) {
            int prizeDoor = rand.nextInt(3) + 1;
            int chosenDoor = rand.nextInt(3) + 1;

            int remainingDoor;
            do {
                remainingDoor = rand.nextInt(3) + 1;
            } while (remainingDoor == prizeDoor || remainingDoor == chosenDoor);

            int switchDoor;
            do {
                switchDoor = rand.nextInt(3) + 1;
            } while (switchDoor == chosenDoor || switchDoor == remainingDoor);

            if (switchDoor == prizeDoor) {
                winSwitch.put(i, 1);
                winsSwitch++;
            }else{
                winSwitch.put(i, 0);
            }

            if (chosenDoor == prizeDoor) {
                winStay.put(i, 1);
                winsStay++;
            }else{
                winStay.put(i, 0);
            }
        }

        System.out.println("При смене двери выигрыш произошел " + winsSwitch + " раз из " + rounds + " попыток.");
        System.out.println("При оставлении выбора без изменений выигрыш произошел " + winsStay + " раз из " + rounds + " попыток.");

        System.out.println("Вероятность выигрыша при смене двери: " + (double) winsSwitch / rounds);
        System.out.println("Вероятность выигрыша при оставлении выбора без изменений: " + (double) winsStay / rounds);

        System.out.println(winSwitch);
        System.out.println(winStay);
    }
}

package codewars.dynamicprogramming;

import java.math.BigInteger;

/**
 * https://www.codewars.com/kata/54cb771c9b30e8b5250011d4/train/java
 */
public class FabergeEasterEggsCrushTest {

    public static void main(String[] args) {
        System.out.println(FabergeEasterEggsCrushTest.height(BigInteger.valueOf(2), BigInteger.valueOf(14))); //105
        System.out.println(FabergeEasterEggsCrushTest.height(BigInteger.valueOf(13), BigInteger.valueOf(550))); //60113767426276772744951355
        System.out.println(FabergeEasterEggsCrushTest.height(BigInteger.valueOf(271), BigInteger.valueOf(550))); //1410385042520538326622498273346382708200418583791594039531058458108130216985983794998105636900856496701928202738750818606797013840207721579523618137220278767326000095
        System.out.println(FabergeEasterEggsCrushTest.height(BigInteger.valueOf(531), BigInteger.valueOf(550))); //3685510180489786476798393145496356338786055879312930105836138965083617346086082863365358130056307390177215209990980317284932211552658342317904346433026688858140133147
    }

    public static BigInteger height(BigInteger n, BigInteger m) {


        return BigInteger.ZERO; // TODO replace with your solution
    }
}

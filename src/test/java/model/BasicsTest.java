package model;

import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.math3.util.Precision;

public abstract class BasicsTest {

    protected static List<Integer> randomInts() {
        return Collections.singletonList(RandomUtils.nextInt(1, 10000));
    }

    protected static List<Double> randomDoubles() {
        return Collections.singletonList(Precision.round(RandomUtils.nextDouble(1, 1000), 2));
    }


    protected static List<String> randomStrings() {
        return Collections.singletonList(
                RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(1, 100)));
    }


    protected static int randomInt() {
        return randomInts().get(0);
    }

    protected static double randomDouble() {
        return randomDoubles().get(0);
    }

    protected static String randomString() {
        return randomStrings().get(0);
    }
}

class RtriangleProvider implements Rtriangle {

    int getApexX1() { return getRandomNumberInRange(-2, 2) }

    int getApexY1() { return getRandomNumberInRange(-2, 2) }

    int getApexX2() { return getRandomNumberInRange(-2, 2) }

    int getApexY2() { return getRandomNumberInRange(-2, 2) }

    int getApexX3() { return getRandomNumberInRange(-2, 2) }

    int getApexY3() { return getRandomNumberInRange(-2, 2) }

    static Rtriangle getRtriangle() {

        new RtriangleProvider()

    }

    private static int getRandomNumberInRange(int min, int max) {

        new Random().nextInt(max - min + 1) + min

    }

}

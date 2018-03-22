package javase02.t07;

@Info(
        author = "Sergey Sarvarov",
        date = "3/22/2018"
)
public class NuclearSubmarine {

    private double speed;
    private double depth;
    private EngineOfNuclearSubmarine engine;

    public NuclearSubmarine() {
        speed = 0.0;
        depth = 0.0;
        engine = new EngineOfNuclearSubmarine();
    }

    public void startSubmarine(double speed) {
        this.speed = speed;
        double K = 2;
        double depthOfLoweringControlRods = speed / K;
        engine.startTheEngine(depthOfLoweringControlRods);
    }

    public void changeSpeed(double speed) {
        startSubmarine(speed);
    }

    public void stopSubmarine() {
        engine.stopTheEngine();
        this.speed = 0;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void printStatusOfSubmarine() {
        System.out.println(
                "Подводная лодка:" + "\n" +
                        "   Скорость : " + speed + "\n" +
                        "   Глубина: " + depth);

        engine.printStatusOfEngine();
    }

    class EngineOfNuclearSubmarine {
        private double coolantTemperature;
        private double depthOfLoweringControlRods;
        private double rotationalSpeedOfTurbines;

        public EngineOfNuclearSubmarine() {
            coolantTemperature = 0;
            depthOfLoweringControlRods = 0;
            rotationalSpeedOfTurbines = 0;
        }

        public void startTheEngine(double depth) {
            changeDepthOfLoweringControlRods(depth);
        }

        public void stopTheEngine() {
            changeDepthOfLoweringControlRods(0);
        }

        public void changeDepthOfLoweringControlRods(double depthOfLoweringControlRods) {
            this.depthOfLoweringControlRods = depthOfLoweringControlRods;

            double K1 = 2;
            coolantTemperature = K1 * depthOfLoweringControlRods;

            double K2 = 3;
            rotationalSpeedOfTurbines = K2 * coolantTemperature;
        }

        public double getRotationalSpeedOfTurbines() {
            return rotationalSpeedOfTurbines;
        }

        public void printStatusOfEngine() {
            System.out.println(
                    "Двигатель: " + "\n" +
                            "   Глубина погружения стержней: " + depthOfLoweringControlRods + "\n" +
                            "   Температура теплоносителя: " + coolantTemperature + "\n" +
                            "   Скорость вращения турбин: " + rotationalSpeedOfTurbines + "\n");
        }
    }
}
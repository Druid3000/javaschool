package javase02.t06;

public class nuclearSubmarine {

    private double speed;
    private double depth;
    private double voltage;
    private EngineOfNuclearSubmarine engine;

    class EngineOfNuclearSubmarine {
        private double coolantTemperature;
        private double depthOfLoweringControlRods;
        private double rotationalSpeedOfTurbines;

        public EngineOfNuclearSubmarine() {
            coolantTemperature = 0;
            depthOfLoweringControlRods = 0;
            rotationalSpeedOfTurbines = 0;
        }

        public void startTheEngine(){

        }

        public void stopTheEngine(){

        }

        public void setDepthOfLoweringControlRods(double depthOfLoweringControlRods) {
            this.depthOfLoweringControlRods = depthOfLoweringControlRods;
        }
    }
}

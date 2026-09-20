public class Computer {
    private final String cpu;
    private final String motherboard;
    private final int ramGb;
    private final int powerSupplyWattage;

    private final String gpu;
    private final Storage storage;
    private final boolean hasWaterCooling;
    private final boolean hasWifi;
    private final boolean hasRgbLighting;
    private final int cpuCores;

    public Computer(String cpu, String motherboard, int ramGb, int powerSupplyWattage,
                    String gpu, Storage storage, boolean hasWaterCooling,
                    boolean hasWifi, boolean hasRgbLighting, int cpuCores) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ramGb = ramGb;
        this.powerSupplyWattage = powerSupplyWattage;
        this.gpu = gpu;
        this.storage = storage;
        this.hasWaterCooling = hasWaterCooling;
        this.hasWifi = hasWifi;
        this.hasRgbLighting = hasRgbLighting;
        this.cpuCores = cpuCores;
    }

    public String getCpu() { return cpu; }
    public String getMotherboard() { return motherboard; }
    public int getRamGb() { return ramGb; }
    public int getPowerSupplyWattage() { return powerSupplyWattage; }
    public String getGpu() { return gpu; }
    public Storage getStorage() { return storage; }
    public boolean isHasWaterCooling() { return hasWaterCooling; }
    public boolean isHasWifi() { return hasWifi; }
    public boolean isHasRgbLighting() { return hasRgbLighting; }
    public int getCpuCores() { return cpuCores; }
}
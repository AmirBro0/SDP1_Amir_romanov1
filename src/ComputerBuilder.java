public class ComputerBuilder {
    private final String cpu;
    private final String motherboard;
    private final int ramGb;
    private final int powerSupplyWattage;

    private String gpu = "Integrated Graphics";
    private Storage storage = new Storage("SSD", 256);
    private boolean hasWaterCooling = false;
    private boolean hasWifi = false;
    private boolean hasRgbLighting = false;
    private int cpuCores = 4;

    public ComputerBuilder(String cpu, String motherboard, int ramGb, int powerSupplyWattage) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ramGb = ramGb;
        this.powerSupplyWattage = powerSupplyWattage;
    }

    public ComputerBuilder withGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder withStorage(String type, int capacityGb) {
        this.storage = new Storage(type, capacityGb);
        return this;
    }

    public ComputerBuilder enableWaterCooling() {
        this.hasWaterCooling = true;
        return this;
    }

    public ComputerBuilder enableWifi() {
        this.hasWifi = true;
        return this;
    }

    public ComputerBuilder enableRgbLighting() {
        this.hasRgbLighting = true;
        return this;
    }

    public ComputerBuilder withCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
        return this;
    }

    public Computer build() {
        validateSingleFields();
        validateCrossFields();
        return new Computer(
                cpu, motherboard, ramGb, powerSupplyWattage,
                gpu, storage, hasWaterCooling, hasWifi, hasRgbLighting, cpuCores
        );
    }

    private void validateSingleFields() {
        if (ramGb < 4) {
            throw new IllegalArgumentException("RAM must be at least 4GB");
        }
        if (powerSupplyWattage < 300) {
            throw new IllegalArgumentException("Power supply must be at least 300W");
        }
        if (cpuCores <= 0) {
            throw new IllegalArgumentException("CPU cores must be positive");
        }
    }

    private void validateCrossFields() {
        if (cpuCores >= 8 && !hasWaterCooling) {
            throw new IllegalStateException("High performance CPU (8+ cores) requires water cooling");
        }
        if (cpuCores >= 8 && powerSupplyWattage < 750) {
            throw new IllegalStateException("High performance CPU requires at least 750W power supply");
        }
    }
}
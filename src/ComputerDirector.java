public class ComputerDirector {

    public Computer constructOfficePc() {
        return new ComputerBuilder("Intel i3", "B660", 8, 400)
                .withCpuCores(4)
                .build();
    }

    public Computer constructGamingPc() {
        return new ComputerBuilder("Intel i7", "Z790", 16, 750)
                .withGpu("NVIDIA RTX 4070")
                .withStorage("NVMe SSD", 1000)
                .enableWifi()
                .enableRgbLighting()
                .withCpuCores(8)
                .enableWaterCooling()
                .build();
    }

    public Computer constructWorkstationPc() {
        return new ComputerBuilder("AMD Threadripper", "TRX40", 64, 1000)
                .withGpu("NVIDIA RTX 4090")
                .withStorage("NVMe SSD", 2000)
                .enableWaterCooling()
                .withCpuCores(16)
                .build();
    }
}
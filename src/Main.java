    public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Custom PC Build via Builder ===");
        Computer customPc = new ComputerBuilder("AMD Ryzen 5 5600", "B550", 16, 600)
                .withGpu("NVIDIA RTX 3060")
                .withStorage("NVMe SSD", 512)
                .enableWifi()
                .withCpuCores(6)
                .build();

        System.out.println("CPU: " + customPc.getCpu());
        System.out.println("GPU: " + customPc.getGpu());
        System.out.println("RAM: " + customPc.getRamGb() + "GB");
        System.out.println("Storage: " + customPc.getStorage().type() + " " + customPc.getStorage().capacityGb() + "GB");
        System.out.println("Wi-Fi Enabled: " + customPc.isHasWifi());

        System.out.println("\n=== 2. Preset Configurations via Director ===");
        ComputerDirector director = new ComputerDirector();

        Computer officePc = director.constructOfficePc();
        System.out.println("Office PC CPU: " + officePc.getCpu() + " | Cores: " + officePc.getCpuCores());

        Computer gamingPc = director.constructGamingPc();
        System.out.println("Gaming PC GPU: " + gamingPc.getGpu() + " | Water Cooling: " + gamingPc.isHasWaterCooling() + " 🍌");

        Computer workstation = director.constructWorkstationPc();
        System.out.println("Workstation RAM: " + workstation.getRamGb() + "GB | PSU: " + workstation.getPowerSupplyWattage() + "W");
    }
}
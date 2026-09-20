import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ComputerBuilderTest {

    @Test
    void testValidBasicBuild() {
        Computer computer = new ComputerBuilder("Intel i5", "B660", 16, 500).build();
        assertNotNull(computer);
        assertEquals("Intel i5", computer.getCpu());
    }

    @Test
    void testValidGamingBuildWithBanana() {
        ComputerDirector director = new ComputerDirector();
        Computer gamingPc = director.constructGamingPc();
        assertNotNull(gamingPc);
        System.out.println("Gaming PC Built Successfully 🍌");
    }

    @Test
    void testValidWorkstationBuild() {
        ComputerDirector director = new ComputerDirector();
        Computer workstation = director.constructWorkstationPc();
        assertEquals(64, workstation.getRamGb());
    }

    @Test
    void testInvalidRam() {
        assertThrows(IllegalArgumentException.class, () ->
                new ComputerBuilder("Intel i3", "H610", 2, 400).build()
        );
    }

    @Test
    void testInvalidPowerSupply() {
        assertThrows(IllegalArgumentException.class, () ->
                new ComputerBuilder("Intel i3", "H610", 8, 200).build()
        );
    }

    @Test
    void testInvalidCpuCores() {
        assertThrows(IllegalArgumentException.class, () ->
                new ComputerBuilder("Intel i3", "H610", 8, 400).withCpuCores(0).build()
        );
    }

    @Test
    void testBoundaryRamValue() {
        Computer computer = new ComputerBuilder("Intel i3", "H610", 4, 300).build();
        assertEquals(4, computer.getRamGb());
    }

    @Test
    void testBoundaryPowerValue() {
        Computer computer = new ComputerBuilder("Intel i3", "H610", 8, 300).build();
        assertEquals(300, computer.getPowerSupplyWattage());
    }

    @Test
    void testIndividualConstraintHighCpuRequiresWaterCooling() {
        assertThrows(IllegalStateException.class, () ->
                new ComputerBuilder("Intel i9", "Z790", 32, 850)
                        .withCpuCores(8)
                        .build()
        );
    }

    @Test
    void testBuilderReuseIndependence() {
        ComputerBuilder builder = new ComputerBuilder("Intel i5", "B660", 16, 500);
        Computer pc1 = builder.build();

        builder.enableWifi();
        Computer pc2 = builder.build();

        assertFalse(pc1.isHasWifi());
        assertTrue(pc2.isHasWifi());
    }
}
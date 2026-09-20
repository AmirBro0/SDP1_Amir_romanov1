```markdown
# Assignment 1 - Builder Pattern: Design Under Changing Requirements

**Student:** Amir Romanov (AmirBro0)
**Course:** Software Design Patterns
**Domain:** Computer Configuration
**Constraint:** High-performance CPUs (8+ cores) require water cooling and a power supply of at least 750W.
**Presets:** OFFICE, GAMING, WORKSTATION

---

## 1. Problem Description (Part A)
Initially, constructing a complex `Computer` object required a direct multi-argument constructor:

```java
Computer pc = new Computer("Intel i7", "Z790", 16, 750, "NVIDIA RTX 4070", new Storage("NVMe SSD", 1000), true, true, true, 8);

```

### Identified Design Problems:

1. **Telescoping Constructor & Low Readability:** Passing 10 parameters (including multiple boolean flags and integers) makes the constructor difficult to read and error-prone.
2. **Positional Arguments Risk:** It is extremely easy to swap parameters of the same type (e.g., swapping `ramGb` and `powerSupplyWattage`), leading to silent bugs.
3. **Lack of Validation at Construction Time:** Conventional constructors allow invalid object instances to be instantiated before validation rules can run.

---

## 2. Builder Solution & Participants (Part B)

The Builder Pattern separates object construction from representation.

* **Product (`Computer`):** Represents the target complex object with immutable fields.
* **Builder (`ComputerBuilder`):** Provides step-by-step construction using fluent methods and encapsulates validation logic.
* **Director (`ComputerDirector`):** Defines reusable predefined configurations (Presets).
* **Client (`Main` / `ComputerBuilderTest`):** Initiates the construction process.

---

## 3. Validation Rules (Part C)

### Single-Field Rules:

1. `ramGb >= 4`: Ensures minimum RAM requirements.
2. `powerSupplyWattage >= 300`: Ensures sufficient power unit.
3. `cpuCores > 0`: CPU cores count must be positive.

### Cross-Field Rules:

1. `cpuCores >= 8 -> hasWaterCooling == true`: Powerful processors require liquid cooling.
2. `cpuCores >= 8 -> powerSupplyWattage >= 750`: High performance requires a stronger power supply.

---

## 4. Preset Configurations (Part D)

Implemented via `ComputerDirector`:

* **OFFICE:** Standard 4-core CPU, 8GB RAM, integrated graphics.
* **GAMING:** 8-core CPU, RTX 4070 GPU, water cooling, RGB lighting, 750W PSU.
* **WORKSTATION:** 16-core CPU, RTX 4090 GPU, 64GB RAM, 1000W PSU.

---

## 5. Clean Code: Before -> After (Part E)

### Fragment 1: Avoiding Flag Arguments

* **BEFORE:** `.setWaterCooling(true)`
* **AFTER:** `.enableWaterCooling()`
* **Reasoning:** Clean Code Chapter 3 advises avoiding boolean flag arguments. Intent-revealing domain methods improve readability.

### Fragment 2: Single Responsibility Principle (SRP)

* **BEFORE:** `build()` method performed construction, string formatting, and validation mixed together.
* **AFTER:** Validation extracted into private helper methods (`validateSingleFields()`, `validateCrossFields()`).
* **Reasoning:** Functions should do one thing and do it well.

### Fragment 3: Descriptive Naming

* **BEFORE:** `public Computer make(String c, String m, int r, int p)`
* **AFTER:** `public ComputerBuilder(String cpu, String motherboard, int ramGb, int powerSupplyWattage)`
* **Reasoning:** Use descriptive and unambiguous domain terms for parameters.

---

## 6. Design Decision (Part F)

* **Decision:** Perform validation inside `ComputerBuilder.build()` right before `Computer` instantiation.
* **Alternative:** Place validation logic inside the `Computer` constructor itself.
* **Reasoning:** Performing validation inside the Builder prevents invalid objects from being instantiated altogether, keeping the Product class clean and focused strictly on holding state.

---

## 7. Traceability Table (Part G)

| Builder Role | Project Class | Responsibility |
| --- | --- | --- |
| Product | `Computer` | Holds state for the built computer configuration |
| Builder | `ComputerBuilder` | Handles step-by-step assembly and validation |
| Director | `ComputerDirector` | Provides pre-configured builds (OFFICE, GAMING, WORKSTATION) |
| Client | `Main` / `ComputerBuilderTest` | Invokes Builder/Director to create instances |

---

## 8. Automated Testing (Part H)

10 unit tests in `ComputerBuilderTest` verify:

* Valid basic, gaming, and workstation constructions.
* Edge/boundary cases for RAM and PSU wattage.
* Single-field validation exceptions.
* Individual constraint rule enforcement.
* Builder reuse independence.
* Verification output includes `🍌` console marker.

```

```
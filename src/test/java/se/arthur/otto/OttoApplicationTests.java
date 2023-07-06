package se.arthur.otto;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class OttoApplicationTests {

    private final ApplicationModules modules = ApplicationModules.of(OttoApplication.class);

    @Test
    void verifyModularStructure() {
        this.modules.verify();
    }

    @Test
    void printApplicationModuleStructure() {
        this.modules.forEach(System.out::println);
    }

    @Test
    void documentApplicationModuleStructure() {
        new Documenter(this.modules).writeDocumentation();
    }
}

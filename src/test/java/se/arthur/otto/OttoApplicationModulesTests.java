package se.arthur.otto;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class OttoApplicationModulesTests {

    private final ApplicationModules modules = ApplicationModules.of(OttoApplication.class);

    @Test
    void verify_module_structure() {
        this.modules.verify();
    }

    @Test
    void print_application_module_structure() {
        this.modules.forEach(System.out::println);
    }

    @Test
    void document_application_module_structure() {
        new Documenter(this.modules).writeDocumentation();
    }
}

package com.raj.modulith.modular_monolith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ModularMonolithApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createApplicationModuleModel() {
	    ApplicationModules modules = ApplicationModules.of(ModularMonolithApplication.class);
	    modules.forEach(System.out::println);
	}
	
	@Test
	void verifiesModularStructure() {
	    ApplicationModules modules = ApplicationModules.of(ModularMonolithApplication.class);
	    modules.verify();
	}
	
	@Test
	void createModuleDocumentation() {
	    ApplicationModules modules = ApplicationModules.of(ModularMonolithApplication.class);
	    new Documenter(modules)
	      .writeDocumentation()
	      .writeIndividualModulesAsPlantUml();
	}
}

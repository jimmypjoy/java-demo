package com.demo.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsProgrammaticExample {

	public static void main(String[] args) {
		// This example is used when there is an issue with drools class loader
		
		KieServices ks = KieServices.Factory.get();

		KieFileSystem kfs = ks.newKieFileSystem();

		// Add your DRL file content
		String drlContent = "package com.example.rules\n" + "\n" + "rule \"Hello World\"\n" + "    when\n"
				+ "        $message : String( this == \"hello\" )\n" + "    then\n"
				+ "        System.out.println(\"Rule Fired: \" + $message);\n" + "end";

		// Add the DRL to the KieFileSystem with a path
		kfs.write(ResourceFactory.newByteArrayResource(drlContent.getBytes())
				.setSourcePath("src/main/resources/rules/hello.drl"));

		KieBuilder kb = ks.newKieBuilder(kfs).buildAll();

		Results results = kb.getResults();
		if (results.hasMessages(Message.Level.ERROR)) {
			System.err.println(results.getMessages());
			throw new IllegalStateException("KieBuilding errors");
		}

		KieContainer kContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());

		System.out.println("Available KieBases: " + kContainer.getKieBaseNames());
//		System.out.println("Available KieSessions: " + kContainer.getKieSessionNames());

		KieSession kSession = kContainer.newKieSession();
		kSession.insert("hello");
		kSession.fireAllRules();
		kSession.dispose();
	}

}

package com.demo.drools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsDemo1 {
	public static void main(String[] args) {
		try {

			String filePath = "rules/DemoRule.drl";

			InputStream inputStream = DroolsDemo1.class.getClassLoader().getResourceAsStream(filePath);
			if (inputStream == null) {
				System.out.println("File not found: " + filePath);
				return;
			}

			String content = new BufferedReader(new InputStreamReader(inputStream)).lines()
					.collect(Collectors.joining("\n"));

			System.out.println("Rule file content:\n" + content);

			KieServices ks = KieServices.Factory.get();

			KieFileSystem kfs = ks.newKieFileSystem();

			// Add the DRL to the KieFileSystem with a path
			kfs.write(ResourceFactory.newByteArrayResource(content.getBytes())
					.setSourcePath("src/main/resources/rules/hello.drl"));

			KieBuilder kb = ks.newKieBuilder(kfs).buildAll();

			Results results = kb.getResults();
			if (results.hasMessages(Message.Level.ERROR)) {
				System.err.println(results.getMessages());
				throw new IllegalStateException("KieBuilding errors");
			}

			KieContainer kContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());

			System.out.println("Available KieBases: " + kContainer.getKieBaseNames());
//			System.out.println("Available KieSessions: " + kContainer.getKieSessionNames());

			KieSession kSession = kContainer.newKieSession();
			Person p1 = new Person("John", 25);
			kSession.insert(p1);
			kSession.fireAllRules();
			kSession.dispose();

			System.out.println("#####################");
			System.out.println(p1.getMessages());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

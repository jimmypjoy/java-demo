package com.demo.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsDemo {
	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();

			System.out.println("Available KieBases: " + kContainer.getKieBaseNames());

			KieSession kSession = kContainer.newKieSession("ksession-rules");

			Person p1 = new Person("John", 25);
			kSession.insert(p1);
			kSession.fireAllRules();
			kSession.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

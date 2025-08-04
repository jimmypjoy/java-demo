package com.demo.springboot.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class DemoServerSideEventPushController {

	private final ExecutorService executor = Executors.newCachedThreadPool();
	private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

	// Code for Server Side Event push of data back to browser via open http
	// connection
	@PostMapping("/start-process")
	public Map<String, String> startProcess() {

		System.out.println("Inside startProcess of Server Side Event(SSE) push...");
		String taskId = UUID.randomUUID().toString();
		SseEmitter emitter = new SseEmitter(0L); // No timeout
		emitters.put(taskId, emitter);

		executor.submit(() -> {
			try {
				// Simulate long-running task (3-4 minutes)
				Thread.sleep(20 * 1000);

				// Simulate success or failure randomly
				boolean isSuccess = Math.random() > 0.3;

				System.out.println("Before sending Server Side Event(SSE) push status: " + isSuccess);

				if (isSuccess) {
					emitter.send("Process completed successfully.");
				} else {
					emitter.send("Process failed with error code 123ABC.");
				}

				emitter.complete();
			} catch (Exception e) {
				try {
					emitter.send("Process failed with unexpected error.");
					emitter.completeWithError(e);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} finally {
				emitters.remove(taskId);
			}
		});

		System.out.println("Finished startProcess of Server Side Event(SSE) push...");

		return Map.of("taskId", taskId);
	}

	// SSE endpoint to listen for completion message
	@GetMapping("/subscribe/{taskId}")
	public SseEmitter subscribe(@PathVariable String taskId) {
		System.out.println("Inside subscribe of Server Side Event(SSE) push...");
		return emitters.getOrDefault(taskId, new SseEmitter(0L));
	}

}

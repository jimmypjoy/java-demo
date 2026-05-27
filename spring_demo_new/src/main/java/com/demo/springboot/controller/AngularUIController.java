package com.demo.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AngularUIController {

	// In-memory todo storage
	private static List<Todo> todos = new ArrayList<>();
	private static AtomicLong idCounter = new AtomicLong(3);

	// Initialize with 3 sample todos
	static {
		todos.add(new Todo(1L, "in28minutes", "Learn Angular", new Date(), false));
		todos.add(new Todo(2L, "in28minutes", "Learn Spring Boot", new Date(), false));
		todos.add(new Todo(3L, "in28minutes", "Build Full Stack App", new Date(), false));
	}

	// ========== Authentication Endpoint ==========
	@PostMapping("/angular/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

		// Validate credentials (hardcoded for demo purposes)
		if ("in28minutes".equals(authenticationRequest.getUsername())
				&& "dummy".equals(authenticationRequest.getPassword())) {

			// Generate a dummy JWT token (in real app, use proper JWT library)
			String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJpbjI4bWludXRlcyJ9.dummy";

			return ResponseEntity.ok(new JwtResponse(token));
		}

		return ResponseEntity.status(401).body("Invalid credentials");
	}

	// ========== Todo Endpoints ==========

	// Get all todos for a user
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		List<Todo> userTodos = new ArrayList<>();
		for (Todo todo : todos) {
			if (todo.getUsername().equals(username)) {
				userTodos.add(todo);
			}
		}
		return userTodos;
	}

	// Get a single todo by id
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable String username, @PathVariable Long id) {
		for (Todo todo : todos) {
			if (todo.getId().equals(id) && todo.getUsername().equals(username)) {
				return ResponseEntity.ok(todo);
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Delete a todo
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
		todos.removeIf(todo -> todo.getId().equals(id) && todo.getUsername().equals(username));
		return ResponseEntity.noContent().build();
	}

	// Update a todo
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id,
			@RequestBody Todo updatedTodo) {
		for (int i = 0; i < todos.size(); i++) {
			Todo todo = todos.get(i);
			if (todo.getId().equals(id) && todo.getUsername().equals(username)) {
				updatedTodo.setId(id);
				updatedTodo.setUsername(username);
				todos.set(i, updatedTodo);
				return ResponseEntity.ok(updatedTodo);
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Create a new todo
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo newTodo) {
		Long newId = idCounter.incrementAndGet();
		newTodo.setId(newId);
		newTodo.setUsername(username);
		todos.add(newTodo);
		return ResponseEntity.ok(newTodo);
	}
}

// ========== DTOs ==========

// Authentication Request DTO
class JwtRequest {
	private String username;
	private String password;

	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

// Authentication Response DTO
class JwtResponse {
	private String token;

	public JwtResponse() {
	}

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

// Todo DTO
class Todo {
	private Long id;
	private String username;
	private String description;
	private Date targetDate;
	private boolean done;

	public Todo() {
	}

	public Todo(Long id, String username, String description, Date targetDate, boolean done) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}

package com.samples.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTaskDemo extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611187395038591793L;
	private long workLoad = 0;

	public ForkJoinPoolTaskDemo(long workLoad) {
		this.workLoad = workLoad;
	}

	protected Long compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<ForkJoinPoolTaskDemo> subtasks = new ArrayList<ForkJoinPoolTaskDemo>();
			subtasks.addAll(createSubtasks());

			for (ForkJoinPoolTaskDemo subtask : subtasks) {
				subtask.fork();
			}

			long result = 0;
			for (ForkJoinPoolTaskDemo subtask : subtasks) {
				result += subtask.join();
			}
			return result;

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
			return workLoad * 3;
		}
	}

	private List<ForkJoinPoolTaskDemo> createSubtasks() {
		List<ForkJoinPoolTaskDemo> subtasks = new ArrayList<ForkJoinPoolTaskDemo>();

		ForkJoinPoolTaskDemo subtask1 = new ForkJoinPoolTaskDemo(this.workLoad / 2);
		ForkJoinPoolTaskDemo subtask2 = new ForkJoinPoolTaskDemo(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);

		ForkJoinPoolTaskDemo forkJoinPoolTaskDemo = new ForkJoinPoolTaskDemo(125);

		long mergedResult = forkJoinPool.invoke(forkJoinPoolTaskDemo);

		System.out.println("mergedResult = " + mergedResult);

	}
}

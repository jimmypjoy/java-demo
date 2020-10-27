package com.samples.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolActionDemo extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4398151463075766731L;
	// In reality this could be a list of tasks
	private long workLoad = 0;

	public ForkJoinPoolActionDemo(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<ForkJoinPoolActionDemo> subtasks = new ArrayList<ForkJoinPoolActionDemo>();

			subtasks.addAll(createSubtasks());

			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
	}

	private List<ForkJoinPoolActionDemo> createSubtasks() {
		List<ForkJoinPoolActionDemo> subtasks = new ArrayList<ForkJoinPoolActionDemo>();

		ForkJoinPoolActionDemo subtask1 = new ForkJoinPoolActionDemo(this.workLoad / 2);
		ForkJoinPoolActionDemo subtask2 = new ForkJoinPoolActionDemo(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);

		ForkJoinPoolActionDemo forkJoinPoolActionDemo = new ForkJoinPoolActionDemo(203);

		forkJoinPool.invoke(forkJoinPoolActionDemo);

	}
}

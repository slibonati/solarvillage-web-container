package com.solarvillage.permit.model;

import java.util.Random;

public enum Status {
	APPROVED, DENIED, IN_PROGRESS;

	public static Status getRandomStatus() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}

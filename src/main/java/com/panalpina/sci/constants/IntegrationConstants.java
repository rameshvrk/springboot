package com.panalpina.sci.constants;

public interface IntegrationConstants {

	public static final String REGEX = "^HKG[^u]\\d";
	public static final String PREFIX = "HKG";

	public enum IntegrationQueueStatus {
		NEW, READYFORPROCESS, PROCESSING, PASS, FAIL
	}

	public enum IntegrationFileTypes {
		HKG
	}
}

package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Automation Exception
 */
@SuppressWarnings("serial")
public class D2E2ESparkMobileFrameworkException extends Exception {

	/** The message. */
	private String message = null;

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(D2E2ESparkMobileFrameworkException.class);

	/**
	 * Instantiates a new Automation exception.
	 */
	public D2E2ESparkMobileFrameworkException() {
		super();
	}

	/**
	 * Instantiates a new Automation exception.
	 *
	 * @param message
	 *            the message
	 */
	public D2E2ESparkMobileFrameworkException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Instantiates a new Automation exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public D2E2ESparkMobileFrameworkException(Throwable cause) {
		super(cause);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
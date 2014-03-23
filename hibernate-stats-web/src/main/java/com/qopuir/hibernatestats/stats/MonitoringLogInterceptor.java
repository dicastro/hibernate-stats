package com.qopuir.hibernatestats.stats;

import org.aopalliance.intercept.MethodInvocation;
import org.javasimon.Manager;
import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.source.MonitorSource;
import org.javasimon.source.StopwatchSource;
import org.javasimon.spring.BasicMonitoringInterceptor;
import org.javasimon.spring.SpringStopwatchSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitoringLogInterceptor extends BasicMonitoringInterceptor {
	private static final long serialVersionUID = -6641852701448495825L;

	private static Logger log = LoggerFactory.getLogger(MonitoringLogInterceptor.class);

	public static final String EXCEPTION_TAG = "failed";

	private boolean tagByExceptionType;

	/**
	 * Constructor with specified {@link MonitorSource}.
	 *
	 * @param stopwatchSource stopwatch provider for method invocation
	 */
	public MonitoringLogInterceptor(StopwatchSource<MethodInvocation> stopwatchSource) {
		super(stopwatchSource);
	}

	/**
	 * Constructor with specified {@link Manager}.
	 */
	public MonitoringLogInterceptor(Manager manager) {
		super(new SpringStopwatchSource(manager).cache());
	}

	/**
	 * Default constructor using {@link SimonManager#manager}.
	 */
	public MonitoringLogInterceptor() {
		super(new SpringStopwatchSource(SimonManager.manager()).cache());
	}

	/**
	 * Sets whether all exceptions should report to {@link #EXCEPTION_TAG} sub-simon or sub-simon for each
	 * exception type should be introduced (based on exception's simple name).
	 *
	 * @param tagByExceptionType {@code true} for fine grained exception-class-name-based sub-simons
	 */
	public void setTagByExceptionType(boolean tagByExceptionType) {
		this.tagByExceptionType = tagByExceptionType;
	}

	/**
	 * Method stops the split
	 *
	 * @param invocation method invocation
	 * @param split running split for this monitored action
	 * @return return object from the method
	 * @throws Throwable
	 */
	@Override
	protected Object processInvoke(MethodInvocation invocation, Split split) throws Throwable {
		try {
			return invocation.proceed();
		} catch (Throwable t) {
			split.stop(tagByExceptionType ? t.getClass().getSimpleName() : EXCEPTION_TAG);
			throw t;
		} finally {
			log.debug(split.getStopwatch().toString());
		}
	}
}
package com.hzn.search.aop;

import com.hzn.search.exception.ExceptionLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Component
@Aspect
@Slf4j
@Order (Integer.MIN_VALUE)
public class CommonLog {

	@Around ("execution(public * com.hzn.search.api..service..*(..))")
	public Object serviceLog (ProceedingJoinPoint point) {
		Signature signature = point.getSignature ();
		Logger logger = LoggerFactory.getLogger (signature.getDeclaringTypeName ());
		String className = signature.getDeclaringType ().getSimpleName ();
		String methodName = signature.getName ();
		logger.info ("[{}.{}] start.", className, methodName);

		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		Object object = null;
		try {
			object = point.proceed ();
		} catch (Throwable t) {
			ExceptionLog.print (t, logger);
		} finally {
			stopWatch.stop ();
		}

		logger.info ("[{}.{}] end. elapsed time : {} sec", className, methodName, (double) stopWatch.getLastTaskTimeMillis () / 1000);
		return object;
	}
}

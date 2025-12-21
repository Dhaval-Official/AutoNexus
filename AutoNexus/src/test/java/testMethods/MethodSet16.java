package testMethods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class MethodSet16 implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
//		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);			//Default Stuff
		annotation.setRetryAnalyzer(testMethods.MethodSet14.class);
		
	}

	
	 	
}

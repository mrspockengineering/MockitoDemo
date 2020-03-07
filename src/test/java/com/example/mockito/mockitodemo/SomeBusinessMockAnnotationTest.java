package com.example.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;		// kein Auto-Import: Ctrl +1
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationTest {

	@Mock		// = mock(DataService.class)
	DataService dataServiceMock;
	
	@InjectMocks	// injects with Mock: = new SomeBusinessImpl(dataServiceMock)
	SomeBusinessImpl businessImpl;
	
	@Test
	public void findTheGreatestFromAllData() {
		// instead of DataServiceStub
		// mock: here for interface		(also: for classes)		
		// dataServiceMock.retrieveAllData() => new int[] {24, 15, 10};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 10});
		assertEquals(24 , businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	public void findTheGreatestFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15 , result);
	}
	
	@Test
	public void findTheGreatestFromAllData_NoValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE , businessImpl.findTheGreatestFromAllData());
	}


}



package com.example.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;		// kein Auto-Import: Ctrl +1
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SomeBusinessMockTest {

	@Test
	public void findTheGreatestFromAllData() {
		// instead of DataServiceStub
		// mock: here for interface		(also: for classes)		
		DataService dataServiceMock = mock(DataService.class);
		// dataServiceMock.retrieveAllData() => new int[] {24, 15, 10};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 10});
		
		// 
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);	// constructor to use mock
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24 , result);
	}
	
	@Test
	public void findTheGreatestFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15 , result);
	}

}



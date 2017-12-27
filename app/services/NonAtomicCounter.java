package services;

import javax.inject.Singleton;

@Singleton
public class NonAtomicCounter implements Counter{

	static int count;
	
	@Override
	public int nextCount() {
		return count;
	}

}

package de.schandera.jenkins_tryout;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FunctionNoGuiTest {

	@Test
	public void testReturn42() {
		assertThat(FunctionNoGui.return42()).isEqualTo(42);
	}

	@Test
	public void testFail() {
		fail();
	}
}

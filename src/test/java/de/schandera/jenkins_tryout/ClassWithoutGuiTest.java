package de.schandera.jenkins_tryout;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ClassWithoutGuiTest {

	@Test
	public void testReturn42() {
		assertThat(ClassWithoutGui.return42()).isEqualTo(42);
	}

	@Test
	public void testAdd1and1() {
		assertThat(ClassWithoutGui.sum1and1()).isEqualTo(2);
	}

}

package de.schandera.jenkins_tryout;

import static org.fest.swing.edt.GuiActionRunner.execute;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.edt.GuiTask;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassWithGuiTest {
	private ClassWithGui _frame;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws AWTException {
		_frame = GuiActionRunner.execute(new GuiQuery<ClassWithGui>() {
			@Override
			protected ClassWithGui executeInEDT() {
				return new ClassWithGui();
			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ClassWithGui ex = new ClassWithGui();
				ex.setVisible(true);
			}
		});
	}

	@Test
	public void testChangebuttonIsClickable() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(500);
	}

	@After
	public void destroyGUI() {
		execute(new GuiTask() {
			@Override
			public void executeInEDT() {
				_frame.dispose();
			}
		});
	}
}

package frc.robot;

import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Launcher.class, PowerDistributionPanel.class, VictorSP.class, Encoder.class, Notifier.class })
public class TestLauncherController {
    public Launcher launcher;
    public PowerDistributionPanel pdp = PowerMockito.mock(PowerDistributionPanel.class);
    public VictorSP mockMotor = PowerMockito.mock(VictorSP.class);
    public Encoder mockEncoder = PowerMockito.mock(Encoder.class);
    public Notifier mockNotifier = PowerMockito.mock(Notifier.class);

    @Test
    public void testInput() throws Exception {
        PowerMockito.whenNew(VictorSP.class).withAnyArguments().thenReturn(this.mockMotor);
        PowerMockito.whenNew(Encoder.class).withAnyArguments().thenReturn(this.mockEncoder);
        PowerMockito.whenNew(Notifier.class).withAnyArguments().thenReturn(this.mockNotifier);
        this.launcher = new Launcher(this.pdp);

        launcher.setDisabled(false);
        assertEquals(false, launcher.isDisabled());

    }

    @Test
    public void testCalculate() throws Exception {
        PowerMockito.whenNew(VictorSP.class).withAnyArguments().thenReturn(this.mockMotor);
        PowerMockito.whenNew(Encoder.class).withAnyArguments().thenReturn(this.mockEncoder);
        PowerMockito.whenNew(Notifier.class).withAnyArguments().thenReturn(this.mockNotifier);
        this.launcher = new Launcher(this.pdp);

        this.launcher.setDisabled(false);
        this.launcher.setTargetVelocity(200.0);

        PowerMockito.when(this.mockEncoder.getRate()).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) {
                double rotationalVelocity = launcher.getStateSpaceController().y_est.get(0, 0);
                double tangentialVelocity = rotationalVelocity * launcher.getWheelRadius();
                return tangentialVelocity;
            }
        });

        // controller should converge to desired velocity within 4 seconds
        for(int i = 0; i < 200; i++) {
            assertEquals(200.0, launcher.getTargetVelocity(), 0.1);
            launcher.calculate();
        }

        double expectedRotationalVelocity = 200.0 / launcher.getWheelRadius();
        assertEquals(expectedRotationalVelocity, launcher.getStateSpaceController().x_prev.get(0, 0), 1.0);

    }

}
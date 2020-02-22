package frc.robot;

import  frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareEverythingForTest;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Launcher.class, PowerDistributionPanel.class, VictorSP.class, Encoder.class, Notifier.class})
@PrepareEverythingForTest

public class TestLauncherController {
    public Launcher launcher;
    public PowerDistributionPanel pdp = PowerMockito.mock(PowerDistributionPanel.class);
    public VictorSP mockMotor = PowerMockito.mock(VictorSP.class);
    public Encoder mockEncoder = PowerMockito.mock(Encoder.class);
    public Notifier mockNotifier = PowerMockito.mock(Notifier.class);


    @Test
    public void testInput() throws Exception {
       /* PowerMockito.whenNew(VictorSP.class).withAnyArguments().thenReturn(this.mockMotor);
        PowerMockito.whenNew(Encoder.class).withAnyArguments().thenReturn(this.mockEncoder);
        PowerMockito.whenNew(Notifier.class).withAnyArguments().thenReturn(this.mockNotifier);
*/
       this.launcher = new Launcher(this.pdp);

       launcher.setDisabled(false);
       assertEquals(false, launcher.isDisabled());

    }


}
package org.jointheleague.iaroc;

import android.os.SystemClock;
import android.provider.Settings;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    int dist = 0;
    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?




    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        driveDirect(300,300);
        /*SystemClock.sleep(2000);
        driveDirect(0,0);
        SystemClock.sleep(1000);*/
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
        if (isBumpRight()) {
            driveDirect(-100,-100);
            SystemClock.sleep(3000);
            driveDirect(-100,100);
            SystemClock.sleep(2000);
        }
    }
}
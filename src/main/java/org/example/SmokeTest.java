package org.example;

import com.physmo.garnet.Garnet;
import com.physmo.garnet.GarnetApp;
import com.physmo.garnettoolkit.StringIdBroker;

/**
 * NOTE: This project is used to test maven central deployment of the Garnet project
 */
// NOTE: on MacOS we need to add a vm argument: -XstartOnFirstThread
public class SmokeTest extends GarnetApp  {
    public SmokeTest(Garnet garnet, String s) {
        super(garnet, s);
    }

    public static void main(String[] args) {
        Garnet garnet = new Garnet(400, 400);
        GarnetApp app = new SmokeTest(garnet, "");

        garnet.setApp(app);

        garnet.init();
        garnet.run();
    }

    @Override
    public void init(Garnet garnet) {
        int id = StringIdBroker.INSTANCE.getId("test");
        System.out.println("test ID: "+id);

    }

    @Override
    public void tick(double delta) {
        garnet.getDebugDrawer().setVisible(true);
    }

    @Override
    public void draw() {
        garnet.getGraphics().drawCircle(100,100,50,50);
        garnet.getGraphics().render();
    }
}
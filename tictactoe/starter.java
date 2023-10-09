// 10/26/22 super ap p5
// 11/29/22 evolution
// have the class test the app, add ai, graphics, and a restart
import pkg.*;

public class starter implements InputControl, InputKeyControl {

	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());

        GameDriver ttt = new GameDriver();
        ttt.play();
	}

	public void onMouseClick(double x, double y) {
		// enter code here

	}

	public void keyPress(String s) {
		// enter code here

	}
}
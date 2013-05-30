package pruebas;

public class Main {
	RobotEngine robot = new RobotEngine();
	ConsoleController consCont = new ConsoleController(robot);
	Vista vista = new Vista(robot);
	MainWindow window = new MainWindow(robot, initPlace);
	robot.addObserver(vista);

}

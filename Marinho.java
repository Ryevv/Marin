package marinho;
import robocode.*;
import java.awt.Color;

public class Marinho extends AdvancedRobot {
  int gunDirection = 1;

  public void run() {
    // ROBÔ MUITO ESTILOSO MESMO!
    setBodyColor(Color.magenta);
    setRadarColor(Color.black);
    setGunColor(Color.lightGray);
    setBulletColor(Color.magenta);

    // Gira a arma infinitamente, procurando inimigos
    while (true) {
      turnGunRight(360);
    }
  }

  public void onScannedRobot(ScannedRobotEvent e) {
    // Vira o robô em direção ao inimigo
    setTurnRight(e.getBearing());
    // Atira sempre que está mirando no inimigo
    setFire(3);
    // Seguir em frente
    setAhead(100);
    // Inverte a direção da arma em cada turno
    gunDirection = -gunDirection;
    // Gira 360 graus (sentido horário ou anti-horário)
    setTurnGunRight(360 * gunDirection);
    // Execute todas as ações pendentes
    execute();
  }
}
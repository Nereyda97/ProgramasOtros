
package threads;
import java.io.*;

public class NoWaitPandC {
  static int produceSpeed = 200;
  static int consumeSpeed = 200;
  public static void main (String args[]) {
    if (args.length > 0)
      produceSpeed = Integer.parseInt (args[0]);
    if (args.length > 1)
      consumeSpeed = Integer.parseInt (args[1]);
    NoWaitMonitor monitor = new NoWaitMonitor();
    new NoWaitProducer (monitor, produceSpeed);
    new NoWaitConsumer (monitor, consumeSpeed);
    try {
      Thread.sleep(1000);
    } catch( InterruptedException e) {}
    System.exit(0);
  }
}
class NoWaitMonitor {
  int token = -1;
  PrintWriter out = new PrintWriter (System.out, true);
    // get toekn value
  synchronized int get () {
    out.println("Got:" + token );
    return token;
  }
    // put toekn value
  synchronized void set (int value) {
    token = value;
    out.println("Set: " + token);
  }
}
class NoWaitProducer implements Runnable {
  NoWaitMonitor monitor;
  int speed;
  NoWaitProducer (NoWaitMonitor monitor, int speed) {
    this.monitor = monitor;
    this.speed = speed;
    new Thread (this, "Producer").start();
  }
  public void run () {
    int i =0;
    while (true) {
      monitor.set(i++);
      try {
        Thread.sleep ((int)(Math.random()*speed));
      } catch(InterruptedException e) {}
    }
  }
}
class NoWaitConsumer implements Runnable {
  NoWaitMonitor monitor;
  int speed;
  NoWaitConsumer (NoWaitMonitor monitor, int speed) {
    this.monitor = monitor;
    this.speed = speed;
    new Thread (this, "Consumer").start();
  }
  public void run () {
    while (true) {
      monitor.get();
      try {
        Thread.sleep ((int)(Math.random()*speed));
      } catch(InterruptedException e) {}
    }
  }
}
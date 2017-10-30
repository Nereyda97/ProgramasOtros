
package threads;
import java.io.*;
public class PandC {
  static int produceSpeed = 200;
  static int consumeSpeed = 200;
  public static void main (String args[]) {
    if (args.length > 0)
      produceSpeed = Integer.parseInt (args[0]);
    if (args.length > 1)
      consumeSpeed = Integer.parseInt (args[1]);
    Monitor monitor = new Monitor();
    new Producer(monitor, produceSpeed);
    new Consumer(monitor, consumeSpeed);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.exit(0);
  }
}
class Monitor {
  PrintWriter out = new PrintWriter (System.out, true);
  int token;
  boolean valueSet = false;
    //get token value
  synchronized int get () {
    if (! valueSet)
      try {
        wait();
      } catch (InterruptedException e) {
      }
    out.println ("Got: " + token);
    valueSet = false;
    notify();
    return token;
  }
    //set token value
  synchronized void set (int value) {
    if (valueSet)
      try {
        wait();
      } catch (InterruptedException e) {
      }
    valueSet = true;
    token = value;
    out.println ("Set: " + token);
    notify();
  }
}
class Producer implements Runnable {
  Monitor monitor;
  int speed;
  Producer (Monitor monitor, int speed) {
    this.monitor = monitor;
    this.speed = speed;
    new Thread (this, "Producer").start();
  }
  public void run() {
    int i = 0;
    while (true) {
      monitor.set (i++);
      try {
        Thread.sleep ((int) (Math.random() * speed));
      } catch (InterruptedException e) {
      }
    }
  }
}
class Consumer implements Runnable {
  Monitor monitor;
  int speed;
  Consumer (Monitor monitor, int speed) {
    this.monitor = monitor;
    this.speed = speed;
    new Thread (this, "Consumer").start();
  }
  public void run() {
    while (true) {
      monitor.get();
      try {
        Thread.sleep ((int) (Math.random() * speed));
      } catch (InterruptedException e) {
      }
    }
  }
}

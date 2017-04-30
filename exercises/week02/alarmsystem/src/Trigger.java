public class Trigger {
  private int rate;
  private int state = 1;

  public Trigger(int rate) {
    this.rate = rate;
  }

  public boolean call() {
    changeState();
    return state == 1;
  }

  public void changeState() {
    if (state == rate) {
      state = 1;
    } else {
      state++;
    }
  }

}

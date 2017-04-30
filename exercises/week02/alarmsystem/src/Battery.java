public class Battery {
  private int rate;
  private double state = 100;

  public Battery(int rate) {
    this.rate = rate;
  }

  public double call() {
    decrement();
    return state;
  }

  private void decrement() {
    if (state > 0) {
      state -= rate;
    }
  }

}

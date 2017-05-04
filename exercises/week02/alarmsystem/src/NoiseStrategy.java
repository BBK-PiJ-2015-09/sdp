
public class NoiseStrategy implements AlarmStrategy {
  private boolean active = false;

  @Override
  public void activate() {
    if(!active) { System.out.println("BEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE..."); }
    active = true;
  }

  @Override
  public void deactivate() {
    if(active) { System.out.println("..EEEP."); }
    active = false;
  }

  @Override
  public boolean active() {
    return active;
  }

}

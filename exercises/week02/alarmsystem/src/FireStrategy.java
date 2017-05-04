
public class FireStrategy implements AlarmStrategy {
  private boolean active = false;

  @Override
  public void activate() {
    if(!active) { System.out.println("Calling the fire department!!!"); }
    active = true;
  }

  @Override
  public void deactivate() {
    if(active) { System.out.println("Letting the fire department know that we're OK."); }
    active = false;
  }

  @Override
  public boolean active() {
    return active;
  }

}

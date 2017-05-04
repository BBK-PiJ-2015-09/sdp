
public class OwnerStrategy implements AlarmStrategy {
  private boolean active = false;

  @Override
  public void activate() {
    if(!active) { System.out.println("Calling the owner!!!"); }
    active = true;
  }

  @Override
  public void deactivate() {
    if(active) { System.out.println("Letting the owner know that we're OK."); }
    active = false;
  }

  @Override
  public boolean active() {
    return active;
  }

}

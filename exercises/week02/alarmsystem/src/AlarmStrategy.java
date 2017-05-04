public interface AlarmStrategy {
  void activate();

  void deactivate();

  boolean active();
}

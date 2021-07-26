package deepcode.reactive.taint.test;
import java.util.concurrent.Flow;
public class BadSubscriber implements Flow.Subscriber<String> {
  @Override
  public void onNext(final String data) {
    // this is a sink
    Runtime.getRuntime().exec(data);
  }
}

package deepcode.reactive.taint.test;
import java.util.concurrent.SubmissionPublisher;
import com.sun.rowset.JdbcRowSetImpl;
class Test {
  public static String badSource() {
    JdbcRowSetImpl rs = new JdbcRowSetImpl();
    rs.next();
    return rs.getString(0);
  }
  public void Main() {
    SubmissionPublisher publisher = new SubmissionPublisher();
    BadSubscriber bad_subscriber = new BadSubscriber();
    publisher.subscribe(bad_subscriber);
    publisher.offer(badSource());
  }
}

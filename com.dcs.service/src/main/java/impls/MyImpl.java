package impls;

import utils.MyService;

public class MyImpl implements MyService {
  @Override
  public String getMessage() {
    return "Message from a service";
  }
}

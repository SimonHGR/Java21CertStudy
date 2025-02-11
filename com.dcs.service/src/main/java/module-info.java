import impls.MyImpl;

/*open*/ module com.dcs.service {
//  requires java.base; // implicit
//  exports utils to does.not.exist, com.dcs.client;
  exports utils /*to does.not.exist, com.dcs.client*/;
  provides utils.MyService with MyImpl;
//  opens utils /*to does.not.exist, com.dcs.client*/;
}

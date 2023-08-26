package com.gurucharan.logbacks3rollingpolicy.shutdown;

public interface RollingPolicyShutdownListener {
  /**
   * Shutdown hook that gets called when exiting the application.
   */
  void doShutdown();
}

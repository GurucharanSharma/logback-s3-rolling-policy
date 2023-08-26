package com.gurucharan.logbacks3rollingpolicy.shutdown;

public class RollingPolicyJVMListener implements Runnable {

  private final RollingPolicyShutdownListener listener;

  /**
   * Registers a new shutdown hook.
   *
   * @param listener The shutdown hook to register.
   */
  public RollingPolicyJVMListener(final RollingPolicyShutdownListener listener) {

    this.listener = listener;
  }

  @Override
  public void run() {

    listener.doShutdown();
  }
}

package com.gurucharan.logbacks3rollingpolicy.shutdown;

import com.google.common.collect.Lists;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RollingPolicyContextListener implements ServletContextListener {

  private static final List<RollingPolicyShutdownListener> listeners;

  static {

    listeners = Lists.newArrayList();
  }

  /**
   * Registers a new shutdown hook.
   *
   * @param listener The shutdown hook to register.
   */
  public static void registerShutdownListener(final RollingPolicyShutdownListener listener) {

    if (!listeners.contains(listener)) {

      listeners.add(listener);
    }
  }

  /**
   * Deregisters a previously registered shutdown hook.
   *
   * @param listener The shutdown hook to deregister.
   */
  public static void deregisterShutdownListener(final RollingPolicyShutdownListener listener) {

    if (listeners.contains(listener)) {

      listeners.remove(listener);
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {

    //Empty
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

    //Upload
    for (RollingPolicyShutdownListener listener : listeners) {

      listener.doShutdown();
    }
  }
}

package com.gurucharan.logbacks3rollingpolicy.shutdown;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShutdownHookUtil {

  public static void registerShutdownHook(@NotNull RollingPolicyShutdownListener listener, @Nullable ShutdownHookType shutdownHookType) {

    if (shutdownHookType == null) {

      shutdownHookType = ShutdownHookType.NONE;
    }

    switch (shutdownHookType) {

      case SERVLET_CONTEXT:

        RollingPolicyContextListener.registerShutdownListener(listener);
        break;

      case JVM_SHUTDOWN_HOOK:

        Runtime.getRuntime().addShutdownHook(new Thread(new RollingPolicyJVMListener(listener)));
        break;

      case NONE:
      default:

        //Do nothing
        break;
    }
  }
}

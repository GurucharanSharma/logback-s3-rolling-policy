package com.gurucharan.logbacks3rollingpolicy.data;

import java.util.concurrent.atomic.AtomicReference;

public class CustomData {

  public static final AtomicReference<String> extraS3Folder;

  static {
    extraS3Folder = new AtomicReference<String>(null);
  }
}

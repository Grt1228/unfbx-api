package com.unfbx.common.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取bean实例
 */
@Component
public class SpringUtils implements ApplicationContextAware {
  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public static <T> T getBean(String name) {
    return (T) applicationContext.getBean(name);
  }

  public static <T> T getBean(Class<T> c) {
    return applicationContext.getBean(c);
  }
}

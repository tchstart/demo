package com.tchstart.event;

import com.tchstart.entity.SaveOrderEventMessage;
import org.springframework.context.ApplicationEvent;

public class SaveOrderEvent extends ApplicationEvent {

 public SaveOrderEvent(SaveOrderEventMessage source) {
  super(source);
 }
}
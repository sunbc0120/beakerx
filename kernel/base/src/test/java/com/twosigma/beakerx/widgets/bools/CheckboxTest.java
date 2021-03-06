/*
 *  Copyright 2017 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.twosigma.beakerx.widgets.bools;

import com.twosigma.beakerx.kernel.KernelManager;
import com.twosigma.beakerx.KernelTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static com.twosigma.beakerx.widgets.TestWidgetUtils.verifyMsgForProperty;
import static com.twosigma.beakerx.widgets.TestWidgetUtils.verifyOpenCommMsg;

public class CheckboxTest {

  private KernelTest groovyKernel;

  @Before
  public void setUp() throws Exception {
    groovyKernel = new KernelTest();
    KernelManager.register(groovyKernel);
  }

  @After
  public void tearDown() throws Exception {
    KernelManager.register(null);
  }

  @Test
  public void shouldSendCommOpenWhenCreate() throws Exception {
    //given
    //when
    new Checkbox();
    //then
    verifyOpenCommMsg(groovyKernel.getPublishedMessages(), Checkbox.MODEL_NAME_VALUE, Checkbox.VIEW_NAME_VALUE);
  }

  @Test
  public void shouldSendCommMsgWhenValueChange() throws Exception {
    //given
    Checkbox widget = checkbox();
    //when
    widget.setValue(true);
    //then
    verifyMsgForProperty(groovyKernel, Checkbox.VALUE, true);
  }

  private Checkbox checkbox() throws NoSuchAlgorithmException {
    Checkbox widget = new Checkbox();
    groovyKernel.clearPublishedMessages();
    return widget;
  }

}
/*
 * Copyright (c) 2026. Smart Payment Technologies Limited. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Smart
 * Payment Technologies Limited. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Smart Payment
 * Technologies Limited.
 *
 * SMART PAYMENT TECHNOLOGIES LIMITED MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SMART PAYMENT TECHNOLOGIES LIMITED
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package com.example.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(@Value("${GREETING:Hello from Kubernetes!}") String greeting) {
    return greeting;
  }
}

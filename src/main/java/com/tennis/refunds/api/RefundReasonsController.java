package com.tennis.refunds.api;


import com.tennis.refunds.infrastructure.RefundReasons;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefundReasonsController {


  @PostMapping("/refund-reasons")
  public void getRefundReasons(@RequestBody List<RefundReasons> refundReasons) {

  }
}

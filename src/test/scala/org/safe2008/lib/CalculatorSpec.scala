package org.safe2008.lib

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers {
  "cal.add(10, 100)" should "110" in {
    var cal = new Calculator()
    cal.add(10, 100) shouldEqual 110
  }
}
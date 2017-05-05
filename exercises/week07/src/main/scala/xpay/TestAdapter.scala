package xpay

object TestAdapter extends App {
  // Setup.
  val xpay: Xpay = new XpayImpl()
  xpay.setCreditCardNo("12345678")
  xpay.setCustomerName("Bob")
  xpay.setCardExpMonth("Mar")
  xpay.setCardExpYear("2018")
  xpay.setCardCVVNo(999)
  xpay.setAmount(100)

  // Create adapter.
  val payd: PayD = new XpaytoPayDAdapter(xpay)

  // Test.
  println(payd.getCustCardNo)
  println(payd.getCardOwnerName)
  println(payd.getCardExpMonthDate)
  println(payd.getCVVNo)
  println(payd.getTotalAmount)
}
package xpay

case class XpaytoPayDAdapter(xpay: Xpay) extends PayD {
  def getCustCardNo: String = {
    xpay.getCreditCardNo
  }

  def setCustCardNo(custCardNo: String) : Unit = {
    xpay.setCreditCardNo(custCardNo)
  }

  def getCardOwnerName: String = {
    xpay.getCustomerName
  }

  def setCardOwnerName(cardOwnerName: String) : Unit = {
    xpay.setCustomerName(cardOwnerName)
  }

  def getCardExpMonthDate: String = {
    xpay.getCardExpMonth + "/" + xpay.getCardExpYear
  }

  def setCardExpMonthDate(cardExpMonthDate: String) : Unit = {
    val dates = cardExpMonthDate.split("/")
    xpay.setCardExpMonth(dates(0)) + "/" + xpay.setCardExpYear(dates(1))
  }

  def getCVVNo: Integer = {
    xpay.getCardCVVNo.toInt
  }

  def setCVVNo(cVVNo: Integer): Unit = {
    xpay.setCardCVVNo(cVVNo.toShort)
  }

  def getTotalAmount: Double = {
    xpay.getAmount
  }

  def setTotalAmount(totalAmount: Double) : Unit = {
    xpay.setAmount(totalAmount)
  }
}

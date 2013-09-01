package models

import anorm._
import java.math.{BigDecimal => JBD}

abstract class TwoLegTrade(row: Row) {
  
  val underlier = row[String]("underlier")
  val undLast = BigDecimal(row[JBD]("undLast"))
  
  val longSym = row[String]("longSym")
  val longBid = BigDecimal(row[JBD]("longBid"))
  val longAsk = BigDecimal(row[JBD]("longAsk"))
  val longStrike = BigDecimal(row[JBD]("longStrike"))
  
  val shortSym = row[String]("shortSym")
  val shortBid = BigDecimal(row[JBD]("shortBid"))
  val shortAsk = BigDecimal(row[JBD]("shortAsk"))
  val shortStrike = BigDecimal(row[JBD]("shortStrike"))
  
  val expires = row[Long]("expires")
  val daysToExpire: Int = ((expires - (System.currentTimeMillis / 1000)) / (60 * 60 *24)).toInt
  
  val cost = longAsk - shortBid
  val profitPercent = cost / profitAmount * 100
  val profitPercentPerDay = if (daysToExpire > 0) profitPercent / daysToExpire else profitPercent
  val percentToMaxProfit = amountToMaxProfit / undLast * 100
  val percentToMaxLoss = amountToMaxLoss / undLast * 100
  val percentToBreakeven = amountToBreakeven / undLast * 100
  val percentPerDayToMaxProfit = if (daysToExpire > 0) percentToMaxProfit / daysToExpire else percentToMaxProfit
  val percentPerDayToMaxLoss = if (daysToExpire > 0) percentToMaxLoss / daysToExpire else percentToMaxLoss
  val percentPerDayToBreakeven = if (daysToExpire > 0) percentToBreakeven / daysToExpire else percentToBreakeven
  
  def profitAmount: BigDecimal
  def amountToMaxProfit: BigDecimal
  def amountToMaxLoss: BigDecimal
  def amountToBreakeven: BigDecimal
  
}
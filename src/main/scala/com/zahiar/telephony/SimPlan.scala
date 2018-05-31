package com.zahiar.telephony

import scala.collection.mutable.ArrayBuffer

class SimPlan(name: String, minutes: Int, texts: Int, data: Int) {

  private val addOns = new ArrayBuffer[AddOn]()

  def getName = name
  def getMinutes = minutes
  def getTexts = texts
  def getData = data

  def addAddon(addOn: AddOn): Unit = addOns += addOn
  def getAddons() = addOns

}

package com.zahiar.telephony

import org.scalatest.{BeforeAndAfter, FunSuite}

class SimPlanTests extends FunSuite with BeforeAndAfter {

  var simPlan: SimPlan = _

  before {
    simPlan = new SimPlan("5GEE", 500, 100, 5)
  }

  test("new sim plan should have basic plan details with zero addons") {
    assert(simPlan.getName === "5GEE")
    assert(simPlan.getMinutes === 500)
    assert(simPlan.getTexts === 100)
    assert(simPlan.getData === 5)
    assert(simPlan.getAddons().isEmpty)
  }

  test("Add new AddOn to sim plan") {
    val addOn = AddOn("Free calls in EU")
    simPlan.addAddon(addOn)

    assert(simPlan.getAddons().contains(addOn))
  }

  test("Throw exception if the AddOn being added already exists") {
    val addOn = AddOn("Free calls in EU")
    simPlan.addAddon(addOn)

    assertThrows[IllegalArgumentException] {
      simPlan.addAddon(addOn)
    }
  }

  test("Remove AddOn from sim plan") {
    val addOn = AddOn("Free data in the world")
    simPlan.addAddon(addOn)
    assert(simPlan.getAddons().contains(addOn))

    simPlan.removeAddon(addOn)
    assert(simPlan.getAddons().contains(addOn) === false)
  }

}

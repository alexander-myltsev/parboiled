package org.parboiled.examples.abc

import org.testng.annotations.Test
import org.scalatest.testng.TestNGSuite
import org.parboiled.scala.testing.ParboiledTest
import org.parboiled.scala.parserunners.ReportingParseRunner

class AbcParserInScalaTest extends ParboiledTest with TestNGSuite {
  val parser = new AbcParserInScala() {
    override val buildParseTree = true
  }

  @Test
  def testSimple() {
    val input = "aaabbbccc"
    parse(ReportingParseRunner(parser.S), input) {
      assert(matched)
    }
  }
}
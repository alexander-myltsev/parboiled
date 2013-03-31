package org.parboiled.examples.sql

import org.testng.annotations.Test
import org.scalatest.testng.TestNGSuite
import org.parboiled.scala.testing.ParboiledTest
import org.parboiled.scala.parserunners.ReportingParseRunner

class SqlParserTest extends ParboiledTest with TestNGSuite {
  val parser = new SqlParser() {
    override val buildParseTree = true
  }

  @Test
  def testSelect() {
    val input = "select * from sometable"
    parse(ReportingParseRunner(parser.SelectQuery), input) {
      assert(matched)
    }
  }
}
package codes.seanhenry.mockgenerator.entities

import codes.seanhenry.mockgenerator.ast.OptionalType
import codes.seanhenry.mockgenerator.ast.Type
import junit.framework.TestCase

class TypeFactoryTest: TestCase() {

  fun testShouldBuildFunctionType() {
    val optional = OptionalType.Builder().type().function {}.build()
    assertEquals("(() -> ())?", optional.text)
  }

  fun testShouldBuildOptionalType() {
    val optional = OptionalType.Builder().type().optional { it.type("Type") }.build()
    assertEquals("Type??", optional.text)
  }

  fun testShouldBuildArrayType() {
    val optional = OptionalType.Builder().type().array { it.type("Type") }.build()
    assertEquals("[Type]?", optional.text)
  }

  fun testShouldBuildBracketType() {
    val optional = OptionalType.Builder().type().bracket().type("Type").build()
    assertEquals("(Type)?", optional.text)
  }
}
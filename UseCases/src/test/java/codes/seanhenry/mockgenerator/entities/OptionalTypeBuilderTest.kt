package codes.seanhenry.mockgenerator.entities

import codes.seanhenry.mockgenerator.ast.OptionalType
import junit.framework.TestCase

class OptionalTypeBuilderTest: TestCase() {

  fun testBuildOptionalType() {
    val optional = OptionalType.Builder().type("Type").build()
    assertEquals("Type?", optional.text)
    assertEquals("Type", optional.type.text)
  }

  fun testWrapOptionalFunctionType() {
    val optional = OptionalType.Builder().type().function {}.build()
    assertEquals("(() -> ())?", optional.text)
  }

  fun testBuildOptionalArrayType() {
    val optional = OptionalType.Builder().type().array {}.build()
    assertEquals("[]?", optional.text)
  }

  fun testBuildIUOType() {
    val optional = OptionalType.Builder().type("Type").unwrapped().build()
    assertEquals("Type!", optional.text)
    assertTrue(optional.isImplicitlyUnwrapped)
  }
}

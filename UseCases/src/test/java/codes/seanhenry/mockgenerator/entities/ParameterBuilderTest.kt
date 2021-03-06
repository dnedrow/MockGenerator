package codes.seanhenry.mockgenerator.entities

import junit.framework.TestCase

class ParameterBuilderTest: TestCase() {

  fun testName() {
    val param = Parameter.Builder("name").build()
    assertEquals("name", param.internalName)
    assertNull(param.externalName)
    assertEquals(ResolvedType.IMPLICIT, param.type)
    assertEquals("name: ", param.text)
  }

  fun testInternalExternalLabels() {
    val param = Parameter.Builder("external", "internal").build()
    assertEquals("internal", param.internalName)
    assertEquals("external", param.externalName)
    assertEquals(ResolvedType.IMPLICIT, param.type)
    assertEquals("external internal: ", param.text)
  }

  fun testType() {
    val param = Parameter.Builder("name").type("Type").build()
    assertEquals("Type", param.type.originalType.text)
    assertEquals("Type", param.type.resolvedType.text)
    assertEquals("name: Type", param.text)
  }

  fun testEscaping() {
    val param = Parameter.Builder("name").type("Type").escaping().build()
    assertEquals("Type", param.type.originalType.text)
    assertEquals("Type", param.type.resolvedType.text)
    assertTrue(param.isEscaping)
    assertEquals("name: @escaping Type", param.text)
  }

  fun testInout() {
    val param = Parameter.Builder("name").type("Type").inout().build()
    assertEquals("Type", param.type.originalType.text)
    assertEquals("Type", param.type.resolvedType.text)
    assertEquals("name: inout Type", param.text)
  }

  fun testAnnotation() {
    val param = Parameter.Builder("name").type("Type").annotation("@objc").build()
    assertEquals("Type", param.type.originalType.text)
    assertEquals("Type", param.type.resolvedType.text)
    assertEquals("name: @objc Type", param.text)
  }

  fun testResolvedType() {
    val param = Parameter.Builder("name").type("Type").resolvedType().function { }.build()
    assertEquals("Type", param.type.originalType.text)
    assertEquals("() -> ()", param.type.resolvedType.text)
    assertEquals("name: Type", param.text)
  }
}

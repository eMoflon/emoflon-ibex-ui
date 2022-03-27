/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.gT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Editor Application Condition Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorApplicationConditionType()
 * @model
 * @generated
 */
public enum EditorApplicationConditionType implements Enumerator
{
  /**
   * The '<em><b>POSITIVE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #POSITIVE_VALUE
   * @generated
   * @ordered
   */
  POSITIVE(0, "POSITIVE", "enforce"),

  /**
   * The '<em><b>NEGATIVE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NEGATIVE_VALUE
   * @generated
   * @ordered
   */
  NEGATIVE(1, "NEGATIVE", "forbid");

  /**
   * The '<em><b>POSITIVE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #POSITIVE
   * @model literal="enforce"
   * @generated
   * @ordered
   */
  public static final int POSITIVE_VALUE = 0;

  /**
   * The '<em><b>NEGATIVE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NEGATIVE
   * @model literal="forbid"
   * @generated
   * @ordered
   */
  public static final int NEGATIVE_VALUE = 1;

  /**
   * An array of all the '<em><b>Editor Application Condition Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final EditorApplicationConditionType[] VALUES_ARRAY =
    new EditorApplicationConditionType[]
    {
      POSITIVE,
      NEGATIVE,
    };

  /**
   * A public read-only list of all the '<em><b>Editor Application Condition Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<EditorApplicationConditionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Editor Application Condition Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorApplicationConditionType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      EditorApplicationConditionType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Editor Application Condition Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorApplicationConditionType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      EditorApplicationConditionType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Editor Application Condition Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorApplicationConditionType get(int value)
  {
    switch (value)
    {
      case POSITIVE_VALUE: return POSITIVE;
      case NEGATIVE_VALUE: return NEGATIVE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EditorApplicationConditionType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //EditorApplicationConditionType
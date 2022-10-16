/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Add Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getAddOperator()
 * @model
 * @generated
 */
public enum AddOperator implements Enumerator
{
  /**
   * The '<em><b>ADDITION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADDITION_VALUE
   * @generated
   * @ordered
   */
  ADDITION(0, "ADDITION", "+"),

  /**
   * The '<em><b>SUBTRACTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBTRACTION_VALUE
   * @generated
   * @ordered
   */
  SUBTRACTION(1, "SUBTRACTION", "-");

  /**
   * The '<em><b>ADDITION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADDITION
   * @model literal="+"
   * @generated
   * @ordered
   */
  public static final int ADDITION_VALUE = 0;

  /**
   * The '<em><b>SUBTRACTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBTRACTION
   * @model literal="-"
   * @generated
   * @ordered
   */
  public static final int SUBTRACTION_VALUE = 1;

  /**
   * An array of all the '<em><b>Add Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AddOperator[] VALUES_ARRAY =
    new AddOperator[]
    {
      ADDITION,
      SUBTRACTION,
    };

  /**
   * A public read-only list of all the '<em><b>Add Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AddOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Add Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AddOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AddOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Add Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AddOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AddOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Add Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AddOperator get(int value)
  {
    switch (value)
    {
      case ADDITION_VALUE: return ADDITION;
      case SUBTRACTION_VALUE: return SUBTRACTION;
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
  private AddOperator(int value, String name, String literal)
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
  
} //AddOperator

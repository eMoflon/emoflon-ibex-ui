/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Object Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getName <em>Name</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getAttributeConstraints <em>Attribute Constraints</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getLinkVariablePatterns <em>Link Variable Patterns</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextObjectVariablePattern()
 * @model
 * @generated
 */
public interface ContextObjectVariablePattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextObjectVariablePattern_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextObjectVariablePattern_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>Attribute Constraints</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttributeConstraint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Constraints</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextObjectVariablePattern_AttributeConstraints()
   * @model containment="true"
   * @generated
   */
  EList<AttributeConstraint> getAttributeConstraints();

  /**
   * Returns the value of the '<em><b>Link Variable Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Variable Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getContextObjectVariablePattern_LinkVariablePatterns()
   * @model containment="true"
   * @generated
   */
  EList<ContextLinkVariablePattern> getLinkVariablePatterns();

} // ContextObjectVariablePattern

/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Variable Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeAssignments <em>Attribute Assignments</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeConstraints <em>Attribute Constraints</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getLinkVariablePatterns <em>Link Variable Patterns</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getObjectVariablePattern()
 * @model
 * @generated
 */
public interface ObjectVariablePattern extends NamePattern
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getObjectVariablePattern_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>Attribute Assignments</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttributeAssignment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Assignments</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getObjectVariablePattern_AttributeAssignments()
   * @model containment="true"
   * @generated
   */
  EList<AttributeAssignment> getAttributeAssignments();

  /**
   * Returns the value of the '<em><b>Attribute Constraints</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttributeConstraint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Constraints</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getObjectVariablePattern_AttributeConstraints()
   * @model containment="true"
   * @generated
   */
  EList<AttributeConstraint> getAttributeConstraints();

  /**
   * Returns the value of the '<em><b>Link Variable Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.LinkVariablePattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Variable Patterns</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getObjectVariablePattern_LinkVariablePatterns()
   * @model containment="true"
   * @generated
   */
  EList<LinkVariablePattern> getLinkVariablePatterns();

} // ObjectVariablePattern
/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Attribute Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression#getNode <em>Node</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorAttributeExpression()
 * @model
 * @generated
 */
public interface EditorAttributeExpression extends ArithmeticExpression
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' reference.
   * @see #setNode(EditorNode)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorAttributeExpression_Node()
   * @model
   * @generated
   */
  EditorNode getNode();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(EditorNode value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EAttribute)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorAttributeExpression_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.EditorAttributeExpression#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

} // EditorAttributeExpression

/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Condition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorConditionReference#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorConditionReference()
 * @model
 * @generated
 */
public interface EditorConditionReference extends EditorSimpleCondition
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' reference.
   * @see #setCondition(EditorCondition)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorConditionReference_Condition()
   * @model
   * @generated
   */
  EditorCondition getCondition();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.EditorConditionReference#getCondition <em>Condition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(EditorCondition value);

} // EditorConditionReference

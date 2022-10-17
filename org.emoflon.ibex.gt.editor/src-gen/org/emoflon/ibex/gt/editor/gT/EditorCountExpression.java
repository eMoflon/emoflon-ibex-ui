/**
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.gt.editor.gT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Count Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorCountExpression#getInvokedPatten <em>Invoked Patten</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorCountExpression()
 * @model
 * @generated
 */
public interface EditorCountExpression extends ArithmeticExpression
{
  /**
   * Returns the value of the '<em><b>Invoked Patten</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invoked Patten</em>' reference.
   * @see #setInvokedPatten(EditorPattern)
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorCountExpression_InvokedPatten()
   * @model
   * @generated
   */
  EditorPattern getInvokedPatten();

  /**
   * Sets the value of the '{@link org.emoflon.ibex.gt.editor.gT.EditorCountExpression#getInvokedPatten <em>Invoked Patten</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Invoked Patten</em>' reference.
   * @see #getInvokedPatten()
   * @generated
   */
  void setInvokedPatten(EditorPattern value);

} // EditorCountExpression

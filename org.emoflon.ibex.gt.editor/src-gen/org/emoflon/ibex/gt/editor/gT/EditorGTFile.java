/**
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.gT;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor GT File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorGTFile#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorGTFile#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link org.emoflon.ibex.gt.editor.gT.EditorGTFile#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorGTFile()
 * @model
 * @generated
 */
public interface EditorGTFile extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.emoflon.ibex.gt.editor.gT.EditorImport}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorGTFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<EditorImport> getImports();

  /**
   * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.emoflon.ibex.gt.editor.gT.EditorPattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Patterns</em>' containment reference list.
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorGTFile_Patterns()
   * @model containment="true"
   * @generated
   */
  EList<EditorPattern> getPatterns();

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.emoflon.ibex.gt.editor.gT.EditorCondition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference list.
   * @see org.emoflon.ibex.gt.editor.gT.GTPackage#getEditorGTFile_Conditions()
   * @model containment="true"
   * @generated
   */
  EList<EditorCondition> getConditions();

} // EditorGTFile
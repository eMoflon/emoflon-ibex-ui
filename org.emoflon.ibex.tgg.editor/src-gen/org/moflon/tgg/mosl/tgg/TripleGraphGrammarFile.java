/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triple Graph Grammar File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getImports <em>Imports</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getUsing <em>Using</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getRules <em>Rules</em>}</li>
 *   <li>{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getLibrary <em>Library</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile()
 * @model
 * @generated
 */
public interface TripleGraphGrammarFile extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Import}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Using</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Using}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Using</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile_Using()
   * @model containment="true"
   * @generated
   */
  EList<Using> getUsing();

  /**
   * Returns the value of the '<em><b>Schema</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Schema</em>' containment reference.
   * @see #setSchema(Schema)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile_Schema()
   * @model containment="true"
   * @generated
   */
  Schema getSchema();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getSchema <em>Schema</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Schema</em>' containment reference.
   * @see #getSchema()
   * @generated
   */
  void setSchema(Schema value);

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.Rule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

  /**
   * Returns the value of the '<em><b>Library</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Library</em>' containment reference.
   * @see #setLibrary(AttrCondDefLibrary)
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getTripleGraphGrammarFile_Library()
   * @model containment="true"
   * @generated
   */
  AttrCondDefLibrary getLibrary();

  /**
   * Sets the value of the '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getLibrary <em>Library</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Library</em>' containment reference.
   * @see #getLibrary()
   * @generated
   */
  void setLibrary(AttrCondDefLibrary value);

} // TripleGraphGrammarFile

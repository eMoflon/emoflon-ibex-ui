/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Cond Def Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.moflon.tgg.mosl.tgg.AttrCondDefLibrary#getAttributeCondDefs <em>Attribute Cond Defs</em>}</li>
 * </ul>
 *
 * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDefLibrary()
 * @model
 * @generated
 */
public interface AttrCondDefLibrary extends NamedElements
{
  /**
   * Returns the value of the '<em><b>Attribute Cond Defs</b></em>' containment reference list.
   * The list contents are of type {@link org.moflon.tgg.mosl.tgg.AttrCondDef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Cond Defs</em>' containment reference list.
   * @see org.moflon.tgg.mosl.tgg.TggPackage#getAttrCondDefLibrary_AttributeCondDefs()
   * @model containment="true"
   * @generated
   */
  EList<AttrCondDef> getAttributeCondDefs();

} // AttrCondDefLibrary

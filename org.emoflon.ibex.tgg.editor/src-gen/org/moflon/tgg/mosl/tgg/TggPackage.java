/**
 */
package org.moflon.tgg.mosl.tgg;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.moflon.tgg.mosl.tgg.TggFactory
 * @model kind="package"
 * @generated
 */
public interface TggPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tgg";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.moflon.org/ide/tgg/mosl/TGG";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tgg";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TggPackage eINSTANCE = org.moflon.tgg.mosl.tgg.impl.TggPackageImpl.init();

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl <em>Triple Graph Grammar File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getTripleGraphGrammarFile()
   * @generated
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Using</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE__USING = 1;

  /**
   * The feature id for the '<em><b>Schema</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA = 2;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE__RULES = 3;

  /**
   * The feature id for the '<em><b>Library</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY = 4;

  /**
   * The number of structural features of the '<em>Triple Graph Grammar File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIPLE_GRAPH_GRAMMAR_FILE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.NamedElementsImpl <em>Named Elements</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.NamedElementsImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNamedElements()
   * @generated
   */
  int NAMED_ELEMENTS = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENTS__NAME = 0;

  /**
   * The number of structural features of the '<em>Named Elements</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl <em>Schema</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.SchemaImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getSchema()
   * @generated
   */
  int SCHEMA = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Source Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__SOURCE_TYPES = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__TARGET_TYPES = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Correspondence Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__CORRESPONDENCE_TYPES = NAMED_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attribute Cond Defs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__ATTRIBUTE_COND_DEFS = NAMED_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Schema</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.CorrTypeImpl <em>Corr Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.CorrTypeImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getCorrType()
   * @generated
   */
  int CORR_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_TYPE__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Super</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_TYPE__SUPER = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_TYPE__SOURCE = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_TYPE__TARGET = NAMED_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Corr Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_TYPE_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl <em>Attr Cond Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCondDef()
   * @generated
   */
  int ATTR_COND_DEF = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>User Defined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF__USER_DEFINED = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF__PARAMS = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Allowed Sync Adornments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS = NAMED_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Allowed Gen Adornments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS = NAMED_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Attr Cond Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ParamImpl <em>Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ParamImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getParam()
   * @generated
   */
  int PARAM = 4;

  /**
   * The feature id for the '<em><b>Param Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__PARAM_NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__TYPE = 1;

  /**
   * The number of structural features of the '<em>Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.RuleImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getRule()
   * @generated
   */
  int RULE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Abstract Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__ABSTRACT_RULE = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supertypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__SUPERTYPES = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Schema</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__SCHEMA = NAMED_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Source Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__SOURCE_PATTERNS = NAMED_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Target Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__TARGET_PATTERNS = NAMED_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Correspondence Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__CORRESPONDENCE_PATTERNS = NAMED_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Attr Conditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__ATTR_CONDITIONS = NAMED_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondImpl <em>Attr Cond</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttrCondImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCond()
   * @generated
   */
  int ATTR_COND = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND__NAME = 0;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND__VALUES = 1;

  /**
   * The number of structural features of the '<em>Attr Cond</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefLibraryImpl <em>Attr Cond Def Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttrCondDefLibraryImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCondDefLibrary()
   * @generated
   */
  int ATTR_COND_DEF_LIBRARY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF_LIBRARY__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Attribute Cond Defs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Attr Cond Def Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_COND_DEF_LIBRARY_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AdornmentImpl <em>Adornment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AdornmentImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAdornment()
   * @generated
   */
  int ADORNMENT = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADORNMENT__VALUE = 0;

  /**
   * The number of structural features of the '<em>Adornment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADORNMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ParamValueImpl <em>Param Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ParamValueImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getParamValue()
   * @generated
   */
  int PARAM_VALUE = 9;

  /**
   * The number of structural features of the '<em>Param Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.LocalVariableImpl <em>Local Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.LocalVariableImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLocalVariable()
   * @generated
   */
  int LOCAL_VARIABLE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE__NAME = PARAM_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Local Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_FEATURE_COUNT = PARAM_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.OperatorPatternImpl <em>Operator Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.OperatorPatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getOperatorPattern()
   * @generated
   */
  int OPERATOR_PATTERN = 26;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_PATTERN__OP = 0;

  /**
   * The number of structural features of the '<em>Operator Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_PATTERN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.NamePatternImpl <em>Name Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.NamePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNamePattern()
   * @generated
   */
  int NAME_PATTERN = 28;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_PATTERN__OP = OPERATOR_PATTERN__OP;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_PATTERN__NAME = OPERATOR_PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_PATTERN_FEATURE_COUNT = OPERATOR_PATTERN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.CorrVariablePatternImpl <em>Corr Variable Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.CorrVariablePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getCorrVariablePattern()
   * @generated
   */
  int CORR_VARIABLE_PATTERN = 11;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN__OP = NAME_PATTERN__OP;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN__NAME = NAME_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN__TYPE = NAME_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN__SOURCE = NAME_PATTERN_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN__TARGET = NAME_PATTERN_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Corr Variable Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORR_VARIABLE_PATTERN_FEATURE_COUNT = NAME_PATTERN_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl <em>Object Variable Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getObjectVariablePattern()
   * @generated
   */
  int OBJECT_VARIABLE_PATTERN = 12;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__OP = NAME_PATTERN__OP;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__NAME = NAME_PATTERN__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__TYPE = NAME_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attribute Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS = NAME_PATTERN_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Attribute Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS = NAME_PATTERN_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Link Variable Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS = NAME_PATTERN_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Object Variable Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VARIABLE_PATTERN_FEATURE_COUNT = NAME_PATTERN_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl <em>Context Object Variable Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getContextObjectVariablePattern()
   * @generated
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE = 1;

  /**
   * The feature id for the '<em><b>Attribute Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS = 2;

  /**
   * The feature id for the '<em><b>Link Variable Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS = 3;

  /**
   * The number of structural features of the '<em>Context Object Variable Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OBJECT_VARIABLE_PATTERN_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl <em>Attribute Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeConstraint()
   * @generated
   */
  int ATTRIBUTE_CONSTRAINT = 14;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_CONSTRAINT__ATTRIBUTE = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_CONSTRAINT__OP = 1;

  /**
   * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_CONSTRAINT__VALUE_EXP = 2;

  /**
   * The number of structural features of the '<em>Attribute Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_CONSTRAINT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeAssignmentImpl <em>Attribute Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttributeAssignmentImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeAssignment()
   * @generated
   */
  int ATTRIBUTE_ASSIGNMENT = 15;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ASSIGNMENT__ATTRIBUTE = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ASSIGNMENT__OP = 1;

  /**
   * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ASSIGNMENT__VALUE_EXP = 2;

  /**
   * The number of structural features of the '<em>Attribute Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_ASSIGNMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ExpressionImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 16;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = PARAM_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.EnumExpressionImpl <em>Enum Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.EnumExpressionImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getEnumExpression()
   * @generated
   */
  int ENUM_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Eenum</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_EXPRESSION__EENUM = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_EXPRESSION__LITERAL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl <em>Attribute Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeExpression()
   * @generated
   */
  int ATTRIBUTE_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXPRESSION__DERIVED = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Object Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXPRESSION__OBJECT_VAR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXPRESSION__ATTRIBUTE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attribute Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.LiteralExpressionImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLiteralExpression()
   * @generated
   */
  int LITERAL_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.LinkVariablePatternImpl <em>Link Variable Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.LinkVariablePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLinkVariablePattern()
   * @generated
   */
  int LINK_VARIABLE_PATTERN = 20;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_VARIABLE_PATTERN__OP = OPERATOR_PATTERN__OP;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_VARIABLE_PATTERN__TYPE = OPERATOR_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_VARIABLE_PATTERN__TARGET = OPERATOR_PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Link Variable Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_VARIABLE_PATTERN_FEATURE_COUNT = OPERATOR_PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ContextLinkVariablePatternImpl <em>Context Link Variable Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ContextLinkVariablePatternImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getContextLinkVariablePattern()
   * @generated
   */
  int CONTEXT_LINK_VARIABLE_PATTERN = 21;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_LINK_VARIABLE_PATTERN__TYPE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_LINK_VARIABLE_PATTERN__TARGET = 1;

  /**
   * The number of structural features of the '<em>Context Link Variable Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_LINK_VARIABLE_PATTERN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.OperatorImpl <em>Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.OperatorImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR__VALUE = 0;

  /**
   * The number of structural features of the '<em>Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.NacImpl <em>Nac</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.NacImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNac()
   * @generated
   */
  int NAC = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC__NAME = NAMED_ELEMENTS__NAME;

  /**
   * The feature id for the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC__RULE = NAMED_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC__SOURCE_PATTERNS = NAMED_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC__TARGET_PATTERNS = NAMED_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attr Conditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC__ATTR_CONDITIONS = NAMED_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Nac</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAC_FEATURE_COUNT = NAMED_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.ImportImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__NAME = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.moflon.tgg.mosl.tgg.impl.UsingImpl <em>Using</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.moflon.tgg.mosl.tgg.impl.UsingImpl
   * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getUsing()
   * @generated
   */
  int USING = 25;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USING__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Using</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USING_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile <em>Triple Graph Grammar File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Triple Graph Grammar File</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile
   * @generated
   */
  EClass getTripleGraphGrammarFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getImports()
   * @see #getTripleGraphGrammarFile()
   * @generated
   */
  EReference getTripleGraphGrammarFile_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getUsing <em>Using</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Using</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getUsing()
   * @see #getTripleGraphGrammarFile()
   * @generated
   */
  EReference getTripleGraphGrammarFile_Using();

  /**
   * Returns the meta object for the containment reference '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getSchema <em>Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Schema</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getSchema()
   * @see #getTripleGraphGrammarFile()
   * @generated
   */
  EReference getTripleGraphGrammarFile_Schema();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getRules()
   * @see #getTripleGraphGrammarFile()
   * @generated
   */
  EReference getTripleGraphGrammarFile_Rules();

  /**
   * Returns the meta object for the containment reference '{@link org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Library</em>'.
   * @see org.moflon.tgg.mosl.tgg.TripleGraphGrammarFile#getLibrary()
   * @see #getTripleGraphGrammarFile()
   * @generated
   */
  EReference getTripleGraphGrammarFile_Library();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Schema <em>Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema</em>'.
   * @see org.moflon.tgg.mosl.tgg.Schema
   * @generated
   */
  EClass getSchema();

  /**
   * Returns the meta object for the reference list '{@link org.moflon.tgg.mosl.tgg.Schema#getSourceTypes <em>Source Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Source Types</em>'.
   * @see org.moflon.tgg.mosl.tgg.Schema#getSourceTypes()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_SourceTypes();

  /**
   * Returns the meta object for the reference list '{@link org.moflon.tgg.mosl.tgg.Schema#getTargetTypes <em>Target Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Target Types</em>'.
   * @see org.moflon.tgg.mosl.tgg.Schema#getTargetTypes()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_TargetTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Schema#getCorrespondenceTypes <em>Correspondence Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Correspondence Types</em>'.
   * @see org.moflon.tgg.mosl.tgg.Schema#getCorrespondenceTypes()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_CorrespondenceTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Schema#getAttributeCondDefs <em>Attribute Cond Defs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Cond Defs</em>'.
   * @see org.moflon.tgg.mosl.tgg.Schema#getAttributeCondDefs()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_AttributeCondDefs();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.CorrType <em>Corr Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Corr Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrType
   * @generated
   */
  EClass getCorrType();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrType#getSuper <em>Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrType#getSuper()
   * @see #getCorrType()
   * @generated
   */
  EReference getCorrType_Super();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrType#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrType#getSource()
   * @see #getCorrType()
   * @generated
   */
  EReference getCorrType_Source();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrType#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrType#getTarget()
   * @see #getCorrType()
   * @generated
   */
  EReference getCorrType_Target();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttrCondDef <em>Attr Cond Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Cond Def</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef
   * @generated
   */
  EClass getAttrCondDef();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.AttrCondDef#isUserDefined <em>User Defined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>User Defined</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef#isUserDefined()
   * @see #getAttrCondDef()
   * @generated
   */
  EAttribute getAttrCondDef_UserDefined();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef#getParams()
   * @see #getAttrCondDef()
   * @generated
   */
  EReference getAttrCondDef_Params();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedSyncAdornments <em>Allowed Sync Adornments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Allowed Sync Adornments</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedSyncAdornments()
   * @see #getAttrCondDef()
   * @generated
   */
  EReference getAttrCondDef_AllowedSyncAdornments();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedGenAdornments <em>Allowed Gen Adornments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Allowed Gen Adornments</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDef#getAllowedGenAdornments()
   * @see #getAttrCondDef()
   * @generated
   */
  EReference getAttrCondDef_AllowedGenAdornments();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param</em>'.
   * @see org.moflon.tgg.mosl.tgg.Param
   * @generated
   */
  EClass getParam();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.Param#getParamName <em>Param Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Param Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.Param#getParamName()
   * @see #getParam()
   * @generated
   */
  EAttribute getParam_ParamName();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.Param#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.Param#getType()
   * @see #getParam()
   * @generated
   */
  EReference getParam_Type();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.Rule#isAbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract Rule</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#isAbstractRule()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_AbstractRule();

  /**
   * Returns the meta object for the reference list '{@link org.moflon.tgg.mosl.tgg.Rule#getSupertypes <em>Supertypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supertypes</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getSupertypes()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Supertypes();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.Rule#getSchema <em>Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Schema</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getSchema()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Schema();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Rule#getSourcePatterns <em>Source Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Source Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getSourcePatterns()
   * @see #getRule()
   * @generated
   */
  EReference getRule_SourcePatterns();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Rule#getTargetPatterns <em>Target Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Target Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getTargetPatterns()
   * @see #getRule()
   * @generated
   */
  EReference getRule_TargetPatterns();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Rule#getCorrespondencePatterns <em>Correspondence Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Correspondence Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getCorrespondencePatterns()
   * @see #getRule()
   * @generated
   */
  EReference getRule_CorrespondencePatterns();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Rule#getAttrConditions <em>Attr Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attr Conditions</em>'.
   * @see org.moflon.tgg.mosl.tgg.Rule#getAttrConditions()
   * @see #getRule()
   * @generated
   */
  EReference getRule_AttrConditions();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttrCond <em>Attr Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Cond</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCond
   * @generated
   */
  EClass getAttrCond();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.AttrCond#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCond#getName()
   * @see #getAttrCond()
   * @generated
   */
  EReference getAttrCond_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.AttrCond#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCond#getValues()
   * @see #getAttrCond()
   * @generated
   */
  EReference getAttrCond_Values();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttrCondDefLibrary <em>Attr Cond Def Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Cond Def Library</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDefLibrary
   * @generated
   */
  EClass getAttrCondDefLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.AttrCondDefLibrary#getAttributeCondDefs <em>Attribute Cond Defs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Cond Defs</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttrCondDefLibrary#getAttributeCondDefs()
   * @see #getAttrCondDefLibrary()
   * @generated
   */
  EReference getAttrCondDefLibrary_AttributeCondDefs();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Adornment <em>Adornment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Adornment</em>'.
   * @see org.moflon.tgg.mosl.tgg.Adornment
   * @generated
   */
  EClass getAdornment();

  /**
   * Returns the meta object for the attribute list '{@link org.moflon.tgg.mosl.tgg.Adornment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Value</em>'.
   * @see org.moflon.tgg.mosl.tgg.Adornment#getValue()
   * @see #getAdornment()
   * @generated
   */
  EAttribute getAdornment_Value();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.ParamValue <em>Param Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Value</em>'.
   * @see org.moflon.tgg.mosl.tgg.ParamValue
   * @generated
   */
  EClass getParamValue();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.LocalVariable <em>Local Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Variable</em>'.
   * @see org.moflon.tgg.mosl.tgg.LocalVariable
   * @generated
   */
  EClass getLocalVariable();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.LocalVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.LocalVariable#getName()
   * @see #getLocalVariable()
   * @generated
   */
  EAttribute getLocalVariable_Name();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern <em>Corr Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Corr Variable Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrVariablePattern
   * @generated
   */
  EClass getCorrVariablePattern();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrVariablePattern#getType()
   * @see #getCorrVariablePattern()
   * @generated
   */
  EReference getCorrVariablePattern_Type();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrVariablePattern#getSource()
   * @see #getCorrVariablePattern()
   * @generated
   */
  EReference getCorrVariablePattern_Source();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.CorrVariablePattern#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.moflon.tgg.mosl.tgg.CorrVariablePattern#getTarget()
   * @see #getCorrVariablePattern()
   * @generated
   */
  EReference getCorrVariablePattern_Target();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern <em>Object Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Variable Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern
   * @generated
   */
  EClass getObjectVariablePattern();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getType()
   * @see #getObjectVariablePattern()
   * @generated
   */
  EReference getObjectVariablePattern_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeAssignments <em>Attribute Assignments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Assignments</em>'.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeAssignments()
   * @see #getObjectVariablePattern()
   * @generated
   */
  EReference getObjectVariablePattern_AttributeAssignments();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeConstraints <em>Attribute Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Constraints</em>'.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getAttributeConstraints()
   * @see #getObjectVariablePattern()
   * @generated
   */
  EReference getObjectVariablePattern_AttributeConstraints();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getLinkVariablePatterns <em>Link Variable Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Link Variable Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.ObjectVariablePattern#getLinkVariablePatterns()
   * @see #getObjectVariablePattern()
   * @generated
   */
  EReference getObjectVariablePattern_LinkVariablePatterns();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern <em>Context Object Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Object Variable Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern
   * @generated
   */
  EClass getContextObjectVariablePattern();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getName()
   * @see #getContextObjectVariablePattern()
   * @generated
   */
  EAttribute getContextObjectVariablePattern_Name();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getType()
   * @see #getContextObjectVariablePattern()
   * @generated
   */
  EReference getContextObjectVariablePattern_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getAttributeConstraints <em>Attribute Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute Constraints</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getAttributeConstraints()
   * @see #getContextObjectVariablePattern()
   * @generated
   */
  EReference getContextObjectVariablePattern_AttributeConstraints();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getLinkVariablePatterns <em>Link Variable Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Link Variable Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextObjectVariablePattern#getLinkVariablePatterns()
   * @see #getContextObjectVariablePattern()
   * @generated
   */
  EReference getContextObjectVariablePattern_LinkVariablePatterns();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttributeConstraint <em>Attribute Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Constraint</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeConstraint
   * @generated
   */
  EClass getAttributeConstraint();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.AttributeConstraint#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeConstraint#getAttribute()
   * @see #getAttributeConstraint()
   * @generated
   */
  EReference getAttributeConstraint_Attribute();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.AttributeConstraint#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeConstraint#getOp()
   * @see #getAttributeConstraint()
   * @generated
   */
  EAttribute getAttributeConstraint_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.moflon.tgg.mosl.tgg.AttributeConstraint#getValueExp <em>Value Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Exp</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeConstraint#getValueExp()
   * @see #getAttributeConstraint()
   * @generated
   */
  EReference getAttributeConstraint_ValueExp();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment <em>Attribute Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Assignment</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeAssignment
   * @generated
   */
  EClass getAttributeAssignment();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeAssignment#getAttribute()
   * @see #getAttributeAssignment()
   * @generated
   */
  EReference getAttributeAssignment_Attribute();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeAssignment#getOp()
   * @see #getAttributeAssignment()
   * @generated
   */
  EAttribute getAttributeAssignment_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.moflon.tgg.mosl.tgg.AttributeAssignment#getValueExp <em>Value Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Exp</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeAssignment#getValueExp()
   * @see #getAttributeAssignment()
   * @generated
   */
  EReference getAttributeAssignment_ValueExp();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.moflon.tgg.mosl.tgg.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.EnumExpression <em>Enum Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Expression</em>'.
   * @see org.moflon.tgg.mosl.tgg.EnumExpression
   * @generated
   */
  EClass getEnumExpression();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.EnumExpression#getEenum <em>Eenum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Eenum</em>'.
   * @see org.moflon.tgg.mosl.tgg.EnumExpression#getEenum()
   * @see #getEnumExpression()
   * @generated
   */
  EReference getEnumExpression_Eenum();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.EnumExpression#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Literal</em>'.
   * @see org.moflon.tgg.mosl.tgg.EnumExpression#getLiteral()
   * @see #getEnumExpression()
   * @generated
   */
  EReference getEnumExpression_Literal();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.AttributeExpression <em>Attribute Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Expression</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeExpression
   * @generated
   */
  EClass getAttributeExpression();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#isDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Derived</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeExpression#isDerived()
   * @see #getAttributeExpression()
   * @generated
   */
  EAttribute getAttributeExpression_Derived();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getObjectVar <em>Object Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object Var</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeExpression#getObjectVar()
   * @see #getAttributeExpression()
   * @generated
   */
  EReference getAttributeExpression_ObjectVar();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.AttributeExpression#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.moflon.tgg.mosl.tgg.AttributeExpression#getAttribute()
   * @see #getAttributeExpression()
   * @generated
   */
  EReference getAttributeExpression_Attribute();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Expression</em>'.
   * @see org.moflon.tgg.mosl.tgg.LiteralExpression
   * @generated
   */
  EClass getLiteralExpression();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.LiteralExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.moflon.tgg.mosl.tgg.LiteralExpression#getValue()
   * @see #getLiteralExpression()
   * @generated
   */
  EAttribute getLiteralExpression_Value();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.LinkVariablePattern <em>Link Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link Variable Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.LinkVariablePattern
   * @generated
   */
  EClass getLinkVariablePattern();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.LinkVariablePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.LinkVariablePattern#getType()
   * @see #getLinkVariablePattern()
   * @generated
   */
  EReference getLinkVariablePattern_Type();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.LinkVariablePattern#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.moflon.tgg.mosl.tgg.LinkVariablePattern#getTarget()
   * @see #getLinkVariablePattern()
   * @generated
   */
  EReference getLinkVariablePattern_Target();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern <em>Context Link Variable Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Link Variable Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern
   * @generated
   */
  EClass getContextLinkVariablePattern();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getType()
   * @see #getContextLinkVariablePattern()
   * @generated
   */
  EReference getContextLinkVariablePattern_Type();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.moflon.tgg.mosl.tgg.ContextLinkVariablePattern#getTarget()
   * @see #getContextLinkVariablePattern()
   * @generated
   */
  EReference getContextLinkVariablePattern_Target();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operator</em>'.
   * @see org.moflon.tgg.mosl.tgg.Operator
   * @generated
   */
  EClass getOperator();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.Operator#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.moflon.tgg.mosl.tgg.Operator#getValue()
   * @see #getOperator()
   * @generated
   */
  EAttribute getOperator_Value();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Nac <em>Nac</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nac</em>'.
   * @see org.moflon.tgg.mosl.tgg.Nac
   * @generated
   */
  EClass getNac();

  /**
   * Returns the meta object for the reference '{@link org.moflon.tgg.mosl.tgg.Nac#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule</em>'.
   * @see org.moflon.tgg.mosl.tgg.Nac#getRule()
   * @see #getNac()
   * @generated
   */
  EReference getNac_Rule();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Nac#getSourcePatterns <em>Source Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Source Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.Nac#getSourcePatterns()
   * @see #getNac()
   * @generated
   */
  EReference getNac_SourcePatterns();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Nac#getTargetPatterns <em>Target Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Target Patterns</em>'.
   * @see org.moflon.tgg.mosl.tgg.Nac#getTargetPatterns()
   * @see #getNac()
   * @generated
   */
  EReference getNac_TargetPatterns();

  /**
   * Returns the meta object for the containment reference list '{@link org.moflon.tgg.mosl.tgg.Nac#getAttrConditions <em>Attr Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attr Conditions</em>'.
   * @see org.moflon.tgg.mosl.tgg.Nac#getAttrConditions()
   * @see #getNac()
   * @generated
   */
  EReference getNac_AttrConditions();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.moflon.tgg.mosl.tgg.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.Import#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.Import#getName()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_Name();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.Using <em>Using</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Using</em>'.
   * @see org.moflon.tgg.mosl.tgg.Using
   * @generated
   */
  EClass getUsing();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.Using#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.moflon.tgg.mosl.tgg.Using#getImportedNamespace()
   * @see #getUsing()
   * @generated
   */
  EAttribute getUsing_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.OperatorPattern <em>Operator Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operator Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.OperatorPattern
   * @generated
   */
  EClass getOperatorPattern();

  /**
   * Returns the meta object for the containment reference '{@link org.moflon.tgg.mosl.tgg.OperatorPattern#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.moflon.tgg.mosl.tgg.OperatorPattern#getOp()
   * @see #getOperatorPattern()
   * @generated
   */
  EReference getOperatorPattern_Op();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.NamedElements <em>Named Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Elements</em>'.
   * @see org.moflon.tgg.mosl.tgg.NamedElements
   * @generated
   */
  EClass getNamedElements();

  /**
   * Returns the meta object for the attribute '{@link org.moflon.tgg.mosl.tgg.NamedElements#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.moflon.tgg.mosl.tgg.NamedElements#getName()
   * @see #getNamedElements()
   * @generated
   */
  EAttribute getNamedElements_Name();

  /**
   * Returns the meta object for class '{@link org.moflon.tgg.mosl.tgg.NamePattern <em>Name Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Pattern</em>'.
   * @see org.moflon.tgg.mosl.tgg.NamePattern
   * @generated
   */
  EClass getNamePattern();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TggFactory getTggFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl <em>Triple Graph Grammar File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.TripleGraphGrammarFileImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getTripleGraphGrammarFile()
     * @generated
     */
    EClass TRIPLE_GRAPH_GRAMMAR_FILE = eINSTANCE.getTripleGraphGrammarFile();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIPLE_GRAPH_GRAMMAR_FILE__IMPORTS = eINSTANCE.getTripleGraphGrammarFile_Imports();

    /**
     * The meta object literal for the '<em><b>Using</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIPLE_GRAPH_GRAMMAR_FILE__USING = eINSTANCE.getTripleGraphGrammarFile_Using();

    /**
     * The meta object literal for the '<em><b>Schema</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIPLE_GRAPH_GRAMMAR_FILE__SCHEMA = eINSTANCE.getTripleGraphGrammarFile_Schema();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIPLE_GRAPH_GRAMMAR_FILE__RULES = eINSTANCE.getTripleGraphGrammarFile_Rules();

    /**
     * The meta object literal for the '<em><b>Library</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIPLE_GRAPH_GRAMMAR_FILE__LIBRARY = eINSTANCE.getTripleGraphGrammarFile_Library();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.SchemaImpl <em>Schema</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.SchemaImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getSchema()
     * @generated
     */
    EClass SCHEMA = eINSTANCE.getSchema();

    /**
     * The meta object literal for the '<em><b>Source Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__SOURCE_TYPES = eINSTANCE.getSchema_SourceTypes();

    /**
     * The meta object literal for the '<em><b>Target Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__TARGET_TYPES = eINSTANCE.getSchema_TargetTypes();

    /**
     * The meta object literal for the '<em><b>Correspondence Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__CORRESPONDENCE_TYPES = eINSTANCE.getSchema_CorrespondenceTypes();

    /**
     * The meta object literal for the '<em><b>Attribute Cond Defs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__ATTRIBUTE_COND_DEFS = eINSTANCE.getSchema_AttributeCondDefs();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.CorrTypeImpl <em>Corr Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.CorrTypeImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getCorrType()
     * @generated
     */
    EClass CORR_TYPE = eINSTANCE.getCorrType();

    /**
     * The meta object literal for the '<em><b>Super</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_TYPE__SUPER = eINSTANCE.getCorrType_Super();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_TYPE__SOURCE = eINSTANCE.getCorrType_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_TYPE__TARGET = eINSTANCE.getCorrType_Target();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl <em>Attr Cond Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttrCondDefImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCondDef()
     * @generated
     */
    EClass ATTR_COND_DEF = eINSTANCE.getAttrCondDef();

    /**
     * The meta object literal for the '<em><b>User Defined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR_COND_DEF__USER_DEFINED = eINSTANCE.getAttrCondDef_UserDefined();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND_DEF__PARAMS = eINSTANCE.getAttrCondDef_Params();

    /**
     * The meta object literal for the '<em><b>Allowed Sync Adornments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND_DEF__ALLOWED_SYNC_ADORNMENTS = eINSTANCE.getAttrCondDef_AllowedSyncAdornments();

    /**
     * The meta object literal for the '<em><b>Allowed Gen Adornments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND_DEF__ALLOWED_GEN_ADORNMENTS = eINSTANCE.getAttrCondDef_AllowedGenAdornments();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ParamImpl <em>Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ParamImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getParam()
     * @generated
     */
    EClass PARAM = eINSTANCE.getParam();

    /**
     * The meta object literal for the '<em><b>Param Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM__PARAM_NAME = eINSTANCE.getParam_ParamName();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM__TYPE = eINSTANCE.getParam_Type();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.RuleImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Abstract Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__ABSTRACT_RULE = eINSTANCE.getRule_AbstractRule();

    /**
     * The meta object literal for the '<em><b>Supertypes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__SUPERTYPES = eINSTANCE.getRule_Supertypes();

    /**
     * The meta object literal for the '<em><b>Schema</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__SCHEMA = eINSTANCE.getRule_Schema();

    /**
     * The meta object literal for the '<em><b>Source Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__SOURCE_PATTERNS = eINSTANCE.getRule_SourcePatterns();

    /**
     * The meta object literal for the '<em><b>Target Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__TARGET_PATTERNS = eINSTANCE.getRule_TargetPatterns();

    /**
     * The meta object literal for the '<em><b>Correspondence Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__CORRESPONDENCE_PATTERNS = eINSTANCE.getRule_CorrespondencePatterns();

    /**
     * The meta object literal for the '<em><b>Attr Conditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__ATTR_CONDITIONS = eINSTANCE.getRule_AttrConditions();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondImpl <em>Attr Cond</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttrCondImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCond()
     * @generated
     */
    EClass ATTR_COND = eINSTANCE.getAttrCond();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND__NAME = eINSTANCE.getAttrCond_Name();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND__VALUES = eINSTANCE.getAttrCond_Values();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttrCondDefLibraryImpl <em>Attr Cond Def Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttrCondDefLibraryImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttrCondDefLibrary()
     * @generated
     */
    EClass ATTR_COND_DEF_LIBRARY = eINSTANCE.getAttrCondDefLibrary();

    /**
     * The meta object literal for the '<em><b>Attribute Cond Defs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_COND_DEF_LIBRARY__ATTRIBUTE_COND_DEFS = eINSTANCE.getAttrCondDefLibrary_AttributeCondDefs();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AdornmentImpl <em>Adornment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AdornmentImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAdornment()
     * @generated
     */
    EClass ADORNMENT = eINSTANCE.getAdornment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADORNMENT__VALUE = eINSTANCE.getAdornment_Value();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ParamValueImpl <em>Param Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ParamValueImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getParamValue()
     * @generated
     */
    EClass PARAM_VALUE = eINSTANCE.getParamValue();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.LocalVariableImpl <em>Local Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.LocalVariableImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLocalVariable()
     * @generated
     */
    EClass LOCAL_VARIABLE = eINSTANCE.getLocalVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCAL_VARIABLE__NAME = eINSTANCE.getLocalVariable_Name();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.CorrVariablePatternImpl <em>Corr Variable Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.CorrVariablePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getCorrVariablePattern()
     * @generated
     */
    EClass CORR_VARIABLE_PATTERN = eINSTANCE.getCorrVariablePattern();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_VARIABLE_PATTERN__TYPE = eINSTANCE.getCorrVariablePattern_Type();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_VARIABLE_PATTERN__SOURCE = eINSTANCE.getCorrVariablePattern_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CORR_VARIABLE_PATTERN__TARGET = eINSTANCE.getCorrVariablePattern_Target();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl <em>Object Variable Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ObjectVariablePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getObjectVariablePattern()
     * @generated
     */
    EClass OBJECT_VARIABLE_PATTERN = eINSTANCE.getObjectVariablePattern();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VARIABLE_PATTERN__TYPE = eINSTANCE.getObjectVariablePattern_Type();

    /**
     * The meta object literal for the '<em><b>Attribute Assignments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VARIABLE_PATTERN__ATTRIBUTE_ASSIGNMENTS = eINSTANCE.getObjectVariablePattern_AttributeAssignments();

    /**
     * The meta object literal for the '<em><b>Attribute Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS = eINSTANCE.getObjectVariablePattern_AttributeConstraints();

    /**
     * The meta object literal for the '<em><b>Link Variable Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS = eINSTANCE.getObjectVariablePattern_LinkVariablePatterns();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl <em>Context Object Variable Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ContextObjectVariablePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getContextObjectVariablePattern()
     * @generated
     */
    EClass CONTEXT_OBJECT_VARIABLE_PATTERN = eINSTANCE.getContextObjectVariablePattern();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_OBJECT_VARIABLE_PATTERN__NAME = eINSTANCE.getContextObjectVariablePattern_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_OBJECT_VARIABLE_PATTERN__TYPE = eINSTANCE.getContextObjectVariablePattern_Type();

    /**
     * The meta object literal for the '<em><b>Attribute Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_OBJECT_VARIABLE_PATTERN__ATTRIBUTE_CONSTRAINTS = eINSTANCE.getContextObjectVariablePattern_AttributeConstraints();

    /**
     * The meta object literal for the '<em><b>Link Variable Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_OBJECT_VARIABLE_PATTERN__LINK_VARIABLE_PATTERNS = eINSTANCE.getContextObjectVariablePattern_LinkVariablePatterns();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl <em>Attribute Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttributeConstraintImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeConstraint()
     * @generated
     */
    EClass ATTRIBUTE_CONSTRAINT = eINSTANCE.getAttributeConstraint();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_CONSTRAINT__ATTRIBUTE = eINSTANCE.getAttributeConstraint_Attribute();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_CONSTRAINT__OP = eINSTANCE.getAttributeConstraint_Op();

    /**
     * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_CONSTRAINT__VALUE_EXP = eINSTANCE.getAttributeConstraint_ValueExp();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeAssignmentImpl <em>Attribute Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttributeAssignmentImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeAssignment()
     * @generated
     */
    EClass ATTRIBUTE_ASSIGNMENT = eINSTANCE.getAttributeAssignment();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ASSIGNMENT__ATTRIBUTE = eINSTANCE.getAttributeAssignment_Attribute();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_ASSIGNMENT__OP = eINSTANCE.getAttributeAssignment_Op();

    /**
     * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_ASSIGNMENT__VALUE_EXP = eINSTANCE.getAttributeAssignment_ValueExp();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ExpressionImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.EnumExpressionImpl <em>Enum Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.EnumExpressionImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getEnumExpression()
     * @generated
     */
    EClass ENUM_EXPRESSION = eINSTANCE.getEnumExpression();

    /**
     * The meta object literal for the '<em><b>Eenum</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_EXPRESSION__EENUM = eINSTANCE.getEnumExpression_Eenum();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_EXPRESSION__LITERAL = eINSTANCE.getEnumExpression_Literal();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl <em>Attribute Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.AttributeExpressionImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getAttributeExpression()
     * @generated
     */
    EClass ATTRIBUTE_EXPRESSION = eINSTANCE.getAttributeExpression();

    /**
     * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_EXPRESSION__DERIVED = eINSTANCE.getAttributeExpression_Derived();

    /**
     * The meta object literal for the '<em><b>Object Var</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_EXPRESSION__OBJECT_VAR = eINSTANCE.getAttributeExpression_ObjectVar();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_EXPRESSION__ATTRIBUTE = eINSTANCE.getAttributeExpression_Attribute();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.LiteralExpressionImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLiteralExpression()
     * @generated
     */
    EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_EXPRESSION__VALUE = eINSTANCE.getLiteralExpression_Value();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.LinkVariablePatternImpl <em>Link Variable Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.LinkVariablePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getLinkVariablePattern()
     * @generated
     */
    EClass LINK_VARIABLE_PATTERN = eINSTANCE.getLinkVariablePattern();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK_VARIABLE_PATTERN__TYPE = eINSTANCE.getLinkVariablePattern_Type();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK_VARIABLE_PATTERN__TARGET = eINSTANCE.getLinkVariablePattern_Target();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ContextLinkVariablePatternImpl <em>Context Link Variable Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ContextLinkVariablePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getContextLinkVariablePattern()
     * @generated
     */
    EClass CONTEXT_LINK_VARIABLE_PATTERN = eINSTANCE.getContextLinkVariablePattern();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_LINK_VARIABLE_PATTERN__TYPE = eINSTANCE.getContextLinkVariablePattern_Type();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_LINK_VARIABLE_PATTERN__TARGET = eINSTANCE.getContextLinkVariablePattern_Target();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.OperatorImpl <em>Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.OperatorImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getOperator()
     * @generated
     */
    EClass OPERATOR = eINSTANCE.getOperator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATOR__VALUE = eINSTANCE.getOperator_Value();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.NacImpl <em>Nac</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.NacImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNac()
     * @generated
     */
    EClass NAC = eINSTANCE.getNac();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAC__RULE = eINSTANCE.getNac_Rule();

    /**
     * The meta object literal for the '<em><b>Source Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAC__SOURCE_PATTERNS = eINSTANCE.getNac_SourcePatterns();

    /**
     * The meta object literal for the '<em><b>Target Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAC__TARGET_PATTERNS = eINSTANCE.getNac_TargetPatterns();

    /**
     * The meta object literal for the '<em><b>Attr Conditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAC__ATTR_CONDITIONS = eINSTANCE.getNac_AttrConditions();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.ImportImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__NAME = eINSTANCE.getImport_Name();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.UsingImpl <em>Using</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.UsingImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getUsing()
     * @generated
     */
    EClass USING = eINSTANCE.getUsing();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USING__IMPORTED_NAMESPACE = eINSTANCE.getUsing_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.OperatorPatternImpl <em>Operator Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.OperatorPatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getOperatorPattern()
     * @generated
     */
    EClass OPERATOR_PATTERN = eINSTANCE.getOperatorPattern();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATOR_PATTERN__OP = eINSTANCE.getOperatorPattern_Op();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.NamedElementsImpl <em>Named Elements</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.NamedElementsImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNamedElements()
     * @generated
     */
    EClass NAMED_ELEMENTS = eINSTANCE.getNamedElements();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENTS__NAME = eINSTANCE.getNamedElements_Name();

    /**
     * The meta object literal for the '{@link org.moflon.tgg.mosl.tgg.impl.NamePatternImpl <em>Name Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.moflon.tgg.mosl.tgg.impl.NamePatternImpl
     * @see org.moflon.tgg.mosl.tgg.impl.TggPackageImpl#getNamePattern()
     * @generated
     */
    EClass NAME_PATTERN = eINSTANCE.getNamePattern();

  }

} //TggPackage

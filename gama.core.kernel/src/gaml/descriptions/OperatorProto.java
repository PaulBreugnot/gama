/*******************************************************************************************************
 *
 * OperatorProto.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.descriptions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.ImmutableSet;

import gama.common.interfaces.IGamlIssue;
import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.ITypeProvider;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.operator;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.core.dev.utils.DEBUG;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.ICollector;
import gaml.compilation.GamaGetter;
import gaml.compilation.IValidator;
import gaml.compilation.annotations.depends_on;
import gaml.compilation.annotations.validator;
import gaml.expressions.IExpression;
import gaml.expressions.IExpressionCompiler;
import gaml.expressions.IVarExpression;
import gaml.expressions.operators.BinaryOperator;
import gaml.expressions.operators.NAryOperator;
import gaml.expressions.operators.TypeFieldExpression;
import gaml.expressions.operators.UnaryOperator;
import gaml.types.IType;
import gaml.types.Signature;
import gaml.types.Types;

/**
 * Class OperatorProto.
 *
 * @author drogoul
 * @since 7 avr. 2014
 *
 */
@SuppressWarnings ({ "rawtypes" })
public class OperatorProto extends AbstractProto implements IVarDescriptionUser {

	/** The as. */
	public static OperatorProto AS;
	
	/** The no mandatory parenthesis. */
	public static Set<String> noMandatoryParenthesis = ImmutableSet.copyOf(Arrays.<String> asList("-", "!"));
	
	/** The binaries. */
	public static Set<String> binaries = ImmutableSet.copyOf(Arrays.<String> asList("=", "+", "-", "/", "*", "^", "<",
			">", "<=", ">=", "?", "!=", ":", ".", "where", "select", "collect", "first_with", "last_with",
			"overlapping", "at_distance", "in", "inside", "among", "contains", "contains_any", "contains_all", "min_of",
			"max_of", "with_max_of", "with_min_of", "of_species", "of_generic_species", "sort_by", "accumulate", "or",
			"and", "at", "is", "group_by", "index_of", "last_index_of", "index_by", "count", "sort", "::", "as_map"));

	/** The iterator. */
	public final boolean isVarOrField, canBeConst, iterator;
	
	/** The semantic validator. */
	public final IValidator semanticValidator;
	
	/** The return type. */
	public final IType returnType;
	
	/** The helper. */
	public final GamaGetter helper;
	
	/** The signature. */
	public final Signature signature;
	
	/** The lazy. */
	public final boolean[] lazy;
	
	/** The key type provider. */
	public final int typeProvider, contentTypeProvider, keyTypeProvider;
	
	/** The expected content type. */
	public final int[] expectedContentType;
	
	/** The content type content type provider. */
	public final int contentTypeContentTypeProvider;
	
	/** The depends on. */
	public final String[] depends_on;

	/**
	 * Creates the.
	 *
	 * @param context the context
	 * @param currentEObject the current E object
	 * @param exprs the exprs
	 * @return the i expression
	 */
	public IExpression create(final IDescription context, final EObject currentEObject, final IExpression... exprs) {
		try {
			if (semanticValidator != null) {
				final boolean semantic = semanticValidator.validate(context, currentEObject, exprs);
				if (!semantic) return null;
			}
			switch (signature.size()) {
				case 1:
					if (isVarOrField) return new TypeFieldExpression(this, context, exprs[0]);
					return UnaryOperator.create(this, context, exprs[0]);
				case 2:
					if (isVarOrField)
						return new BinaryOperator.BinaryVarOperator(this, context, exprs[0], (IVarExpression) exprs[1]);
					return BinaryOperator.create(this, context, exprs);
				default:
					return NAryOperator.create(this, exprs);
			}
		} catch (final GamaRuntimeException e) {
			// this can happen when optimizing the code
			// in that case, report an error and return null as it means that
			// the code is not functional
			if (context != null) {
				context.error("This code is not functional: " + e.getMessage(), IGamlIssue.GENERAL, currentEObject);
			}
			return null;
		} catch (final Exception e) {
			// this can happen when optimizing the code
			// in that case, report an error and return null as it means that
			// the code is not functional
			if (context != null) {
				context.error("The compiler encountered an internal error: " + e.getMessage(), IGamlIssue.GENERAL,
						currentEObject);
			}
			return null;
		}
	}

	/**
	 * Instantiates a new operator proto.
	 *
	 * @param name the name
	 * @param method the method
	 * @param helper the helper
	 * @param canBeConst the can be const
	 * @param isVarOrField the is var or field
	 * @param returnType the return type
	 * @param signature the signature
	 * @param lazy the lazy
	 * @param typeProvider the type provider
	 * @param contentTypeProvider the content type provider
	 * @param keyTypeProvider the key type provider
	 * @param contentTypeContentTypeProvider the content type content type provider
	 * @param expectedContentType the expected content type
	 * @param plugin the plugin
	 */
	public OperatorProto(final String name, final AnnotatedElement method, final GamaGetter helper,
			final boolean canBeConst, final boolean isVarOrField, final IType returnType, final Signature signature,
			final boolean lazy, final int typeProvider, final int contentTypeProvider, final int keyTypeProvider,
			final int contentTypeContentTypeProvider, final int[] expectedContentType, final String plugin) {
		super(name, method, plugin);
		iterator = IExpressionCompiler.ITERATORS.contains(name);

		if (IKeyword.AS.equals(name)) { AS = this; }
		IValidator tempValidator = null;
		String[] dependencies = null;
		if (method != null) {
			final validator val = method.getAnnotation(validator.class);
			try {
				tempValidator = val != null ? val.value().newInstance() : null;
			} catch (InstantiationException | IllegalAccessException e) {
				DEBUG.ERR("Error in creating the validator for operator " + name + " on method " + method);
			}
			final depends_on d = method.getAnnotation(depends_on.class);
			dependencies = d != null ? d.value() : null;
		}
		semanticValidator = tempValidator;
		depends_on = dependencies;
		this.returnType = returnType;
		this.canBeConst = canBeConst;
		this.isVarOrField = isVarOrField;
		this.helper = helper;
		this.signature = signature;
		this.lazy = computeLazyness(method);
		this.typeProvider = typeProvider;
		this.contentTypeProvider = contentTypeProvider;
		this.keyTypeProvider = keyTypeProvider;
		this.expectedContentType = expectedContentType;
		this.contentTypeContentTypeProvider = contentTypeContentTypeProvider;
	}

	/**
	 * Compute lazyness.
	 *
	 * @param method the method
	 * @return the boolean[]
	 */
	private boolean[] computeLazyness(final AnnotatedElement method) {
		final boolean[] result = new boolean[signature.size()];
		if (result.length == 0) return result;
		if (method instanceof Method) {
			final Method m = (Method) method;
			final Class[] classes = m.getParameterTypes();
			if (classes.length == 0) return result;
			int begin = 0;
			if (classes[0] == IScope.class) { begin = 1; }
			for (int i = begin; i < classes.length; i++) {
				if (IExpression.class.isAssignableFrom(classes[i])) { result[i - begin] = true; }
			}
		}
		return result;
	}

	/**
	 * Instantiates a new operator proto.
	 *
	 * @param name the name
	 * @param method the method
	 * @param helper the helper
	 * @param canBeConst the can be const
	 * @param isVarOrField the is var or field
	 * @param returnType the return type
	 * @param signature the signature
	 * @param lazy the lazy
	 * @param typeProvider the type provider
	 * @param contentTypeProvider the content type provider
	 * @param keyTypeProvider the key type provider
	 * @param expectedContentType the expected content type
	 * @param plugin the plugin
	 */
	public OperatorProto(final String name, final AnnotatedElement method, final GamaGetter helper,
			final boolean canBeConst, final boolean isVarOrField, /* final int doc, */final int returnType,
			final Class signature, final boolean lazy, final int typeProvider, final int contentTypeProvider,
			final int keyTypeProvider, final int[] expectedContentType, final String plugin) {
		this(name, method == null ? signature : method, helper, canBeConst, isVarOrField, Types.get(returnType),
				new Signature(signature), lazy, typeProvider, contentTypeProvider, keyTypeProvider, ITypeProvider.NONE,
				expectedContentType, plugin);
	}

	/**
	 * Instantiates a new operator proto.
	 *
	 * @param op the op
	 * @param gamaType the gama type
	 */
	private OperatorProto(final OperatorProto op, final IType gamaType) {
		this(op.name, op.support, op.helper, op.canBeConst, op.isVarOrField, op.returnType, new Signature(gamaType),
				true, op.typeProvider, op.contentTypeProvider, op.keyTypeProvider, op.contentTypeContentTypeProvider,
				op.expectedContentType, op.plugin);
	}

	@Override
	public String getTitle() {
		if (isVarOrField) return "field " + getName() + " of type " + returnType + ", for values of type "
				+ signature.asPattern(false);
		return "operator " + getName() + "(" + signature.asPattern(false) + "), returns " + returnType;
	}

	@Override
	public String getDocumentation() {
		if (!isVarOrField) return super.getDocumentation();
		final vars annot = getSupport().getAnnotation(vars.class);
		if (annot != null) {
			final variable[] allVars = annot.value();
			for (final variable v : allVars) {
				if (v.name().equals(getName())) {
					if (v.doc().length > 0) return v.doc()[0].value();
					break;
				}
			}
		}
		return getTitle();
	}

	/**
	 * Verify expected types.
	 *
	 * @param context the context
	 * @param rightType the right type
	 */
	public void verifyExpectedTypes(final IDescription context, final IType<?> rightType) {
		if (expectedContentType == null || expectedContentType.length == 0 || context == null) return;
		if (expectedContentType.length == 1 && iterator) {
			final IType<?> expected = Types.get(expectedContentType[0]);
			if (!rightType.isTranslatableInto(expected)) {
				context.warning("Operator " + getName() + " expects an argument of type " + expected,
						IGamlIssue.SHOULD_CAST);
			}
		} else if (signature.isUnary()) {
			for (final int element : expectedContentType) {
				if (rightType.isTranslatableInto(Types.get(element))) return;
			}
			context.error("Operator " + getName() + " expects arguments of type " + rightType, IGamlIssue.WRONG_TYPE);
		}
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return getName() + "(" + signature.toString() + ")";
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		if (support == null) return "Other";
		final operator op = support.getAnnotation(operator.class);
		if (op == null) return "Other";
		final String[] strings = op.category();
		if (strings.length > 0)
			return op.category()[0];
		else
			return "Other";
	}

	/**
	 * Method getKind()
	 *
	 * @see gaml.descriptions.AbstractProto#getKind()
	 */
	@Override
	public int getKind() {
		return ISymbolKind.OPERATOR;
	}

	/**
	 * Gets the pattern.
	 *
	 * @param withVariables the with variables
	 * @return the pattern
	 */
	public String getPattern(final boolean withVariables) {
		final int size = signature.size();
		final String aName = getName();
		if (size == 1 || size > 2) {
			if (noMandatoryParenthesis.contains(aName))
				return aName + signature.asPattern(withVariables);
			else
				return aName + "(" + signature.asPattern(withVariables) + ")";
		}
		if (binaries.contains(aName))
			return signature.get(0).asPattern() + " " + aName + " " + signature.get(1).asPattern();
		else
			return aName + "(" + signature.asPattern(withVariables) + ")";
	}

	// @Override
	// public void collectMetaInformation(final GamlProperties meta) {
	// super.collectMetaInformation(meta);
	// meta.put(GamlProperties.OPERATORS, name);
	// }

	/**
	 * Copy with signature.
	 *
	 * @param gamaType the gama type
	 * @return the operator proto
	 */
	public OperatorProto copyWithSignature(final IType gamaType) {
		return new OperatorProto(this, gamaType);
	}

	@Override
	public void collectUsedVarsOf(final SpeciesDescription species,
			final ICollector<IVarDescriptionUser> alreadyProcessed, final ICollector<VariableDescription> result) {
		if (alreadyProcessed.contains(this)) return;
		alreadyProcessed.add(this);
		if (depends_on == null) return;
		for (final String s : depends_on) {
			if (species.hasAttribute(s)) { result.add(species.getAttribute(s)); }
		}
	}

	@Override
	public doc getDocAnnotation() {
		doc d = super.getDocAnnotation();
		if (d != null) return d;
		if (support != null && support.isAnnotationPresent(operator.class)) {
			final operator op = support.getAnnotation(operator.class);
			final doc[] docs = op.doc();
			if (docs != null && docs.length > 0) { d = docs[0]; }
		}
		return d;
	}

}
